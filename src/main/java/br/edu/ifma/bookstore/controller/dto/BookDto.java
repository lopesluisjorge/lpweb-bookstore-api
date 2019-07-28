package br.edu.ifma.bookstore.controller.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.ISBN;
import org.springframework.beans.BeanUtils;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.edu.ifma.bookstore.model.Book;
import br.edu.ifma.bookstore.model.Tag;
import br.edu.ifma.bookstore.utils.ObjectAtributes;

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

    private BookDto() {
    }

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublishingCompany() {
        return publishingCompany;
    }

    public void setPublishingCompany(String publishingCompany) {
        this.publishingCompany = publishingCompany;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public BigDecimal getPrice() {
        return price;
    }
    
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

}
