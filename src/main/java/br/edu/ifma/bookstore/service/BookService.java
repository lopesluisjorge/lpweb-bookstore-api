package br.edu.ifma.bookstore.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.edu.ifma.bookstore.model.Book;
import br.edu.ifma.bookstore.model.Tag;
import br.edu.ifma.bookstore.repository.BookRepository;
import br.edu.ifma.bookstore.repository.filter.BookFilter;

@Service
public class BookService {

    private final BookRepository bookRepository;

    private final CrudService<Book, Long> crudService;
    
    @Autowired
    private TagService tagService;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        this.crudService = new CrudService<>(bookRepository);
    }

    public Page<Book> paginate(Pageable page) {
        return crudService.paginate(page);
    }

    public Book findBy(Long id) {
        return crudService.findBy(id);
    }

    public Page<Book> search(String title, List<Integer> tagIds, Pageable page) {
        final List<Tag> tags = tagService.findAllBy(tagIds);
        return bookRepository.findPagesByTitleAndTags(title, tags, page);
    }

    public Page<Book> search(BookFilter bookFilter, Pageable page) {
        return bookRepository.filterBy(bookFilter, page);
    }

    public Book save(Book book) {
        Book toPersist = new Book();
        BeanUtils.copyProperties(book, toPersist, "id");
        return crudService.save(book);
    }

    public Book update(Long id, Book book) {
        return crudService.update(id, book);
    }

    public void deleteBy(Long id) {
        crudService.deleteBy(id);
    }

}
