package br.edu.ifma.bookstore.controller;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

import br.edu.ifma.bookstore.controller.dto.BookDto;
import br.edu.ifma.bookstore.controller.response.ResponseMessage;
import br.edu.ifma.bookstore.model.Book;
import br.edu.ifma.bookstore.repository.filter.BookFilter;
import br.edu.ifma.bookstore.service.BookService;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public ResponseMessage<Page<BookDto>> queryPaginated(BookFilter bookFilter, Pageable pageable) {
        final Page<Book> paginatedBooks = bookService.search(bookFilter, pageable);
        final Page<BookDto> paginatedBookDtos = paginatedBooks.map(book -> BookDto.createFrom(book));

        return ResponseMessage.of(paginatedBookDtos);
    }

    @GetMapping("/{id}")
    public ResponseMessage<BookDto> getBookById(@PathVariable Long id) {
        final Book book = bookService.findBy(id);

        return ResponseMessage.of(BookDto.createFrom(book));
    }

    @PostMapping
    public ResponseEntity<ResponseMessage<BookDto>> create(final @Valid @RequestBody BookDto bookDto) {
        final Book book = bookDto.getBook();
        Book savedBook = bookService.save(book);
        BookDto savedBookDto = BookDto.createFrom(book);

        final URI locationUri = ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(savedBook.getId())
                .toUri();

        return ResponseEntity.created(locationUri).body(ResponseMessage.of(savedBookDto));
    }

    @PutMapping("/{id}")
    public ResponseMessage<BookDto> update(@PathVariable Long id, @RequestBody BookDto bookDto) {
        final Book book = bookService.findBy(id);
        final Book toUpdate = bookDto.getBookIgnoringNullAttributesInDto(book);
        final Book updatedBook = bookService.update(id, toUpdate);

        return ResponseMessage.of(BookDto.createFrom(updatedBook));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void remove(@PathVariable Long id) {
        bookService.deleteBy(id);
    }

}
