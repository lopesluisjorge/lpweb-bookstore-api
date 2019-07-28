package br.edu.ifma.bookstore.book;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import org.springframework.beans.BeanUtils;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.edu.ifma.bookstore.support.utils.ObjectAtributes;
import lombok.Data;

@Data
class BookDto {

    private Long id;

    @NotNull
    // @ISBN
    private String isbn;

    @NotNull
    @Size(min = 5)
    private String title;

    @NotBlank
    private String publishingCompany;

    @NotBlank
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

    @JsonIgnore
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
