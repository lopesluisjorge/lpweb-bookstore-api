package br.edu.ifma.dcomp.lpweb.bookstore.controller.response;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ResponseMessage<T> {

    private T content;
    private final Set<String> errors = new HashSet<>();

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }

    public Set<String> getErrors() {
        return errors;
    }

    public void add(String... errors) {
        this.errors.addAll(Arrays.asList(errors));
    }

}
