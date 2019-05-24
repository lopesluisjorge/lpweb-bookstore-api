package br.edu.ifma.bookstore.controller.response;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ResponseMessage<T> {

    private T content;
    private final Set<ErrorMessage> errors = new HashSet<>();

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }

    public Set<ErrorMessage> getErrors() {
        return errors;
    }

    public void add(ErrorMessage... errors) {
        this.errors.addAll(Arrays.asList(errors));
    }

}
