package br.edu.ifma.bookstore.support.service;

import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public class CrudService<T, ID> {

    private final JpaRepository<T, ID> repository;

    public CrudService(JpaRepository<T, ID> repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public Page<T> paginate(Pageable page) {
        return repository.findAll(page);
    }

    @Transactional(readOnly = true)
    public T findBy(ID id) {
        return repository.findById(id).get();
    }

    @Transactional
    public T save(final T t) {
        return repository.save(t);
    }

    @Transactional
    public T update(ID id, final T t) {
        T onDatabase = findBy(id);
        BeanUtils.copyProperties(t, onDatabase, "id");

        return onDatabase;
    }

    @Transactional
    public void deleteBy(ID id) {
        repository.deleteById(id);
    }

}
