package br.edu.ifma.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifma.bookstore.model.Tag;

public interface TagRepository extends JpaRepository<Tag, Integer> { }
