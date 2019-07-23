package br.edu.ifma.bookstore.controller.response;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ResponseMessage<T> {

    private T content;
    private final Set<ErrorMessage> errors = new HashSet<>();

    private ResponseMessage() {
    }

    public static <T> ResponseMessage<T> of(T t) {
        final ResponseMessage<T> responseMessage = new ResponseMessage<>();
        responseMessage.setContent(t);
        return responseMessage;
    }

    public static <T> ResponseMessage<T> of(ErrorMessage... errors) {
        final ResponseMessage<T> responseMessage = new ResponseMessage<>();
        responseMessage.add(errors);
        return responseMessage;
    }

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
