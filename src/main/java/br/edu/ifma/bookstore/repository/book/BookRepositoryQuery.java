package br.edu.ifma.bookstore.repository.book;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.edu.ifma.bookstore.model.Book;
import br.edu.ifma.bookstore.repository.filter.BookFilter;

public interface BookRepositoryQuery {

    Page<Book> filterBy(BookFilter bookFilter, Pageable page);

}
