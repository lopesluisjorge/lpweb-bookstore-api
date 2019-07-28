package br.edu.ifma.bookstore.controller.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import org.springframework.beans.BeanUtils;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.edu.ifma.bookstore.model.Book;
import br.edu.ifma.bookstore.model.Tag;
import br.edu.ifma.bookstore.utils.ObjectAtributes;
import lombok.Data;

@Data
public final class BookDto {

    private Long id;

    @NotNull
    // @ISBN
    private String isbn;

    @NotNull
    @Size(min = 5)
    private String title;

    @NotEmpty
    private String publishingCompany;

    @NotEmpty
    private String author;

    private Integer releaseYear;

    private String subject;

    private List<Tag> tags = new ArrayList<>();

    @NotNull
    @Positive
    private BigDecimal price;

    public static BookDto createFrom(Book book) {
        BookDto dto = new BookDto();
        BeanUtils.copyProperties(book, dto);
        return dto;
    }

    public Book getBookIgnoringNullAttributesInDto(final Book book) {
        BeanUtils.copyProperties(this, book, ObjectAtributes.getNullAttributesOf(this));
        return book;
    }

    @JsonIgnore
    public Book getBook() {
        Book book = new Book();
        BeanUtils.copyProperties(this, book, "id");
        return book;
    }

}
