package br.edu.ifma.bookstore.repository.filter;

public class BookFilter {

    private String title;

    private Integer tag;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getTagId() {
        return tag;
    }

    public void setTag(Integer tag) {
        this.tag = tag;
    }

}
