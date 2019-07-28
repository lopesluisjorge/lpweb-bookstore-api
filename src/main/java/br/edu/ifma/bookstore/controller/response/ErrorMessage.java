package br.edu.ifma.bookstore.controller.response;

import lombok.Data;

@Data
public class ErrorMessage {

    private String message;

    private String details;

    public ErrorMessage(String message, String details) {
        this.message = message;
        this.details = details;
    }

}
