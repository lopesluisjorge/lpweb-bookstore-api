package br.edu.ifma.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifma.bookstore.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> { }
