package br.edu.ifma.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifma.bookstore.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> { }
