package br.edu.ifma.bookstore.controller.dto;

import org.springframework.beans.BeanUtils;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.edu.ifma.bookstore.model.Book;
import br.edu.ifma.bookstore.utils.ObjectAtributes;

public final class BookDto {

    private Long id;

    private String isbn;

    private String title;

    private String publishingCompany;

    private String author;

    private Integer releaseYear;

    private String subject;

    private BookDto() {}

    public static BookDto createFrom(Book book) {
        BookDto dto = new BookDto();
        BeanUtils.copyProperties(book, dto);
        return dto;
    }

    public Book bookIgnoringNullAttributesInDto(final Book book) {
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

}