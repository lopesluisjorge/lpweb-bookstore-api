package br.edu.ifma.dcomp.lpweb.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifma.dcomp.lpweb.bookstore.model.Tag;

public interface TagRepository extends JpaRepository<Tag, Integer> { }