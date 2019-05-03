package br.edu.ifma.dcomp.lpweb.bookstore.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.edu.ifma.dcomp.lpweb.bookstore.controller.dto.BookDto;
import br.edu.ifma.dcomp.lpweb.bookstore.model.Book;
import br.edu.ifma.dcomp.lpweb.bookstore.service.BookService;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public List<BookDto> getAll() {
        final var books = bookService.findAll();

        return books
            .stream()
            .map(book -> {
                        BookDto bookDto = new BookDto();
                        BeanUtils.copyProperties(book, bookDto);
                        return bookDto;
                    })
            .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public BookDto getBookById(@PathVariable Long id) {
        var book = bookService.findBy(id);
        BookDto bookDto = new BookDto();
        BeanUtils.copyProperties(book, bookDto);

        return bookDto;
    }

    @PostMapping
    public ResponseEntity<BookDto> create(@RequestBody BookDto bookDto, Book injectedBook) {
        BeanUtils.copyProperties(bookDto, injectedBook, "id");
        var savedBook = bookService.save(injectedBook);
        BeanUtils.copyProperties(savedBook, bookDto);
        
        var locationUri = ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(savedBook.getId())
                .toUri();

        return ResponseEntity.created(locationUri).body(bookDto);
    }

    @PutMapping("/{id}")
    public BookDto update(@PathVariable Long id, @RequestBody BookDto bookDto, Book injectedBook) {
        BeanUtils.copyProperties(bookDto, injectedBook, "id");
        var updatedBook = bookService.updateBy(id, injectedBook);
        BeanUtils.copyProperties(updatedBook, bookDto);

        return bookDto;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void remove(@PathVariable Long id) {
        bookService.deleteBy(id);
    }

}
