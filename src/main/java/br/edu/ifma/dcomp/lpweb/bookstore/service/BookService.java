package br.edu.ifma.dcomp.lpweb.bookstore.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.edu.ifma.dcomp.lpweb.bookstore.model.Book;
import br.edu.ifma.dcomp.lpweb.bookstore.repository.BookRepository;

@Service
public class BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Transactional(readOnly = true)
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Book findBy(Long id) {
        return bookRepository.findById(id).get();
    }

    @Transactional
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Transactional
    public Book update(Long id, Book book) {
        final var onDatabaseBook = findBy(id);
        BeanUtils.copyProperties(book, onDatabaseBook, "id");

        return onDatabaseBook;
    }

    @Transactional
    public void deleteBy(Long id) {
        bookRepository.deleteById(id);
    }

}
