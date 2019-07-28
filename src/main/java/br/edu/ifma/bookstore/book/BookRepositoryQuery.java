package br.edu.ifma.bookstore.book;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

interface BookRepositoryQuery {

    Page<Book> filterBy(BookFilter bookFilter, Pageable page);

}
