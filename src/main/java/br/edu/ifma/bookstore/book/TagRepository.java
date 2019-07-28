package br.edu.ifma.bookstore.book;

import org.springframework.data.jpa.repository.JpaRepository;

interface TagRepository extends JpaRepository<Tag, Integer> {

}
