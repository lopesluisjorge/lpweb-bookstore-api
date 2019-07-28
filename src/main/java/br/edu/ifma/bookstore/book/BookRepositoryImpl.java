package br.edu.ifma.bookstore.book;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.util.StringUtils;

class BookRepositoryImpl implements BookRepositoryQuery {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public Page<Book> filterBy(BookFilter bookFilter, Pageable page) {
        final CriteriaBuilder criteriaBuilder = manager.getCriteriaBuilder();
        final CriteriaQuery<Book> query = criteriaBuilder.createQuery(Book.class);

        final Root<Book> queryRoot = query.from(Book.class);

        final Predicate[] restrictions = this.createRestrictionFrom(bookFilter, criteriaBuilder, queryRoot);

        final CriteriaQuery<Book> criteraQuery = query.select(queryRoot)
                .where(restrictions)
                .orderBy(criteriaBuilder.desc(queryRoot.get("title")));

        final TypedQuery<Book> queryToExecute = manager.createQuery(criteraQuery);
        addPaginationRestrictions(queryToExecute, page);

        return new PageImpl<Book>(queryToExecute.getResultList(), page, total(bookFilter));
    }

    private Long total(BookFilter bookFilter) {
        final CriteriaBuilder criteraBuilder = manager.getCriteriaBuilder();
        final CriteriaQuery<Long> criteriaQuery = criteraBuilder.createQuery(Long.class);

        final Root<Book> queryRoot = criteriaQuery.from(Book.class);

        final Predicate[] predicates = createRestrictionFrom(bookFilter, criteraBuilder, queryRoot);

        criteriaQuery.where(predicates);
        criteriaQuery.select(criteraBuilder.count(queryRoot));

        return manager.createQuery(criteriaQuery).getSingleResult();
    }

    private void addPaginationRestrictions(TypedQuery<Book> query, Pageable page) {
        final Integer actual = page.getPageNumber();
        final Integer size = page.getPageSize();
        final Integer first = actual * size;

        query.setFirstResult(first);
        query.setMaxResults(size);
    }

    private Predicate[] createRestrictionFrom(
            BookFilter bookFilter,
            CriteriaBuilder criteriaBuilder,
            Root<Book> bookRoot) {
        final List<Predicate> predicates = new ArrayList<>();

        if (!StringUtils.isEmpty(bookFilter.getTitle())) {
            predicates.add(
                    criteriaBuilder.like(
                            criteriaBuilder.lower(bookRoot.get("title")),
                            String.format("%%%s%%", bookFilter.getTitle().toLowerCase())
                    )
            );
        }

        if (Objects.nonNull(bookFilter.getTag())) {
            Path<Integer> categoriaPath = bookRoot.join("tags").get("id");

            predicates.add(criteriaBuilder.equal(categoriaPath, bookFilter.getTag()));
        }

        return predicates.toArray(new Predicate[predicates.size()]);
    }

}
