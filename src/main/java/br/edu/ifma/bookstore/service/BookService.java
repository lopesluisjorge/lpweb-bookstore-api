package br.edu.ifma.bookstore.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.edu.ifma.bookstore.model.Book;
import br.edu.ifma.bookstore.model.Tag;
import br.edu.ifma.bookstore.repository.BookRepository;
import br.edu.ifma.bookstore.repository.filter.BookFilter;

@Service
public class BookService {

    private final BookRepository bookRepository;

    @Autowired
    private TagService tagService;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Transactional(readOnly = true)
    public Page<Book> paginate(Pageable page) {
        return bookRepository.findAll(page);
    }

    @Transactional(readOnly = true)
    public Book findBy(Long id) {
        return bookRepository.findById(id).get();
    }

    @Transactional(readOnly = true)
    public Page<Book> findBy(String title, List<Integer> tagIds, Pageable page) {
        final List<Tag> tags = tagService.findAllBy(tagIds);
        return bookRepository.findPagesByTitleAndTags(title, tags, page);
    }

    @Transactional(readOnly = true)
    public Page<Book> findBy(BookFilter bookFilter, Pageable page) {
        return bookRepository.filterBy(bookFilter, page);
    }

    @Transactional
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Transactional
    public Book update(Long id, Book book) {
        final Book onDatabaseBook = findBy(id);
        BeanUtils.copyProperties(book, onDatabaseBook, "id");

        return onDatabaseBook;
    }

    @Transactional
    public void deleteBy(Long id) {
        bookRepository.deleteById(id);
    }

}
