package br.edu.ifma.dcomp.lpweb.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifma.dcomp.lpweb.bookstore.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {}
