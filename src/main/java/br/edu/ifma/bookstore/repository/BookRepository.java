package br.edu.ifma.bookstore.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.edu.ifma.bookstore.model.Book;
import br.edu.ifma.bookstore.model.Tag;

public interface BookRepository extends JpaRepository<Book, Long> {

    @Query("SELECT DISTINCT b FROM Book b INNER JOIN b.tags t WHERE b.title LIKE %:title% AND t IN (:tags)")
    Page<Book> findPagesByTitleAndTags(@Param(value = "title") String title, @Param(value = "tags") List<Tag> tags, Pageable page);

}
