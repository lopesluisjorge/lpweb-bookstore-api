package br.edu.ifma.bookstore.controller.response;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import lombok.Data;

@Data
public class ResponseMessage<T> {

    private T content;
    private final Set<ErrorMessage> errors = new HashSet<>();

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

    public void add(ErrorMessage... errors) {
        this.errors.addAll(Arrays.asList(errors));
    }

}
