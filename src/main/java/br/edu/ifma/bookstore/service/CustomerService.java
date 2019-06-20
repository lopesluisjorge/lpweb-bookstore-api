package br.edu.ifma.bookstore.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.edu.ifma.bookstore.model.Customer;
import br.edu.ifma.bookstore.repository.CustomerRepository;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository bookRepository) {
        this.customerRepository = bookRepository;
    }

    @Transactional(readOnly = true)
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Customer findBy(Long id) {
        return customerRepository.findById(id).get();
    }

    @Transactional
    public Customer save(Customer book) {
        return customerRepository.save(book);
    }

    @Transactional
    public Customer update(Long id, Customer book) {
        final Customer onDatabaseBook = findBy(id);
        BeanUtils.copyProperties(book, onDatabaseBook, "id");

        return onDatabaseBook;
    }

    @Transactional
    public void deleteBy(Long id) {
        customerRepository.deleteById(id);
    }

}
