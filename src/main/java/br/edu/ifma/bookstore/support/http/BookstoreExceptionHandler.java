package br.edu.ifma.bookstore.support.http;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class BookstoreExceptionHandler  extends ResponseEntityExceptionHandler {
    
    @Autowired
    private MessageSource messageSource;

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException exeption,
                                                                  HttpHeaders headers,
                                                                  HttpStatus status,
                                                                  WebRequest request) {
        final String message = messageSource.getMessage("parameter.invalid", null, new Locale("pt", "BR"));

        final ResponseMessage<Object> response = ResponseMessage.ofErrors(new ErrorMessage(message, exeption.getLocalizedMessage()));

        return super.handleExceptionInternal(exeption, response, headers, HttpStatus.BAD_REQUEST, request);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException exception,
                                                                  HttpHeaders headers,
                                                                  HttpStatus status,
                                                                  WebRequest request) {
        final List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();

        List<ErrorMessage> errors = fieldErrors.stream()
                .map((fieldError) -> new ErrorMessage(fieldError.getField(), fieldError.getDefaultMessage()))
                .collect(Collectors.toList());

        final ResponseMessage<Object> response = ResponseMessage.ofErrors(errors.toArray(new ErrorMessage[errors.size()]));

        return super.handleExceptionInternal(exception, response, headers, HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler(EmptyResultDataAccessException.class)
    public ResponseMessage<Object> handleEmptyResultDataAccess(EmptyResultDataAccessException exception) {
        final String message = String.format("Recurso não encontrado. Expectativa: %d, Encontrado: %d",
                                          exception.getExpectedSize(), exception.getActualSize());

        return ResponseMessage.ofErrors(new ErrorMessage(message, exception.getMostSpecificCause().toString()));
    }

}
