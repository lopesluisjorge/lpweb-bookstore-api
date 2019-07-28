package br.edu.ifma.bookstore.support.http;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import lombok.Data;

@Data
public class ResponseMessage<T> {

    private T content;
    private final Set<ErrorMessage> errors = new HashSet<>();

    public static <T> ResponseMessage<T> ofContent(T t) {
        ResponseMessage<T> responseMessage = new ResponseMessage<>();
        responseMessage.setContent(t);
        return responseMessage;
    }

    public static <T> ResponseMessage<T> ofErrors(ErrorMessage... errors) {
        ResponseMessage<T> responseMessage = new ResponseMessage<>();
        responseMessage.add(errors);
        return responseMessage;
    }

    private void add(ErrorMessage... errors) {
        this.errors.addAll(Arrays.asList(errors));
    }

}
