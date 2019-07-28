package br.edu.ifma.bookstore.support.http;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
class ErrorMessage {

    private String message;

    private String details;

}
