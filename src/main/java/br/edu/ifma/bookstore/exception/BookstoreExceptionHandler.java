package br.edu.ifma.bookstore.exception;

import java.util.Locale;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.edu.ifma.bookstore.controller.response.ErrorMessage;
import br.edu.ifma.bookstore.controller.response.ResponseMessage;

@RestControllerAdvice
public class BookstoreExceptionHandler  extends ResponseEntityExceptionHandler {
    
    @Autowired
    private MessageSource messageSource;

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException exeption,
                                                                  HttpHeaders headers,
                                                                  HttpStatus status,
                                                                  WebRequest request) {
        final var message = messageSource.getMessage("parameter.invalid", null, new Locale("pt", "BR"));

        final var response = new ResponseMessage<Object>();

        response.add(new ErrorMessage(message, exeption.getLocalizedMessage()));

        return super.handleExceptionInternal(exeption, response, headers, HttpStatus.BAD_REQUEST, request);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException exception,
                                                                  HttpHeaders headers,
                                                                  HttpStatus status,
                                                                  WebRequest request) {
        final var fieldErrors = exception.getBindingResult().getFieldErrors();

        final var errors = fieldErrors.stream()
                .map((fieldError) -> new ErrorMessage(fieldError.getField(), fieldError.getDefaultMessage()))
                .collect(Collectors.toList());

        final var response = new ResponseMessage<Object>();
        errors.forEach(error -> response.add(error));

        return super.handleExceptionInternal(exception, response, headers, HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler(EmptyResultDataAccessException.class)
    public ResponseMessage<ErrorMessage> handleEmptyResultDataAccess(EmptyResultDataAccessException exception) {
        final var message = String.format("Recurso não encontrado. Expectativa: %d, Encontrado: %d",
                                          exception.getExpectedSize(), exception.getActualSize());

        final var response = new ResponseMessage<ErrorMessage>();

        response.add(new ErrorMessage(message, exception.getMostSpecificCause().toString()));

        return response;
    }

}
