package br.edu.ifma.bookstore.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.edu.ifma.bookstore.controller.dto.BookDto;
import br.edu.ifma.bookstore.controller.response.ResponseMessage;
import br.edu.ifma.bookstore.service.BookService;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @Value("${bookstore.pagination.length}")
    private Integer pageLength;

    @GetMapping
    public ResponseMessage<Page<BookDto>> queryPaginated(
            @RequestParam(defaultValue = "") String name,
            @RequestParam(defaultValue = "") String tags,
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "3") Integer size,
            @RequestParam(defaultValue = "title") String orderBy,
            @RequestParam(defaultValue = "ASC") String direction) {
        final List<Integer> tagIds = Arrays.asList(tags.split(",")).stream()
                .map(s -> Integer.valueOf(s))
                .collect(Collectors.toList());

        final var pageReq = PageRequest.of(page, size, Sort.Direction.valueOf(direction), orderBy);

        final var paginatedBooks = bookService.findBy(name, tagIds, pageReq);
        final var paginatedBookDtos = paginatedBooks.map(book -> BookDto.createFrom(book));

        final ResponseMessage<Page<BookDto>> response = new ResponseMessage<>();
        response.setContent(paginatedBookDtos);

        return response;
    }

    @GetMapping("/{id}")
    public ResponseMessage<BookDto> getBookById(@PathVariable Long id) {
        final var book = bookService.findBy(id);

        final ResponseMessage<BookDto> response = new ResponseMessage<>();
        response.setContent(BookDto.createFrom(book));

        return response;
    }

    @PostMapping
    public ResponseEntity<ResponseMessage<BookDto>> create(@Valid @RequestBody BookDto bookDto) {
        final var book = bookDto.getBook();
        final var savedBook = bookService.save(book);
        bookDto = BookDto.createFrom(book);

        final var locationUri = ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(savedBook.getId())
                .toUri();

        final ResponseMessage<BookDto> response = new ResponseMessage<>();
        response.setContent(BookDto.createFrom(book));

        return ResponseEntity.created(locationUri).body(response);
    }

    @PutMapping("/{id}")
    public ResponseMessage<BookDto> update(@PathVariable Long id, @RequestBody BookDto bookDto) {
        final var book = bookService.findBy(id);
        final var toUpdate = bookDto.bookIgnoringNullAttributesInDto(book);
        final var updatedBook = bookService.update(id, toUpdate);

        final ResponseMessage<BookDto> response = new ResponseMessage<>();
        response.setContent(BookDto.createFrom(updatedBook));

        return response;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void remove(@PathVariable Long id) {
        bookService.deleteBy(id);
    }

}
