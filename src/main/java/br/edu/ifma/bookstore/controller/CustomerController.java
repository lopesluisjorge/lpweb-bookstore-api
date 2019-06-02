package br.edu.ifma.bookstore.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.edu.ifma.bookstore.controller.response.ResponseMessage;
import br.edu.ifma.bookstore.model.Customer;
import br.edu.ifma.bookstore.service.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/{id}")
    public ResponseMessage<Customer> getBookById(@PathVariable Long id) {
        final var customer = customerService.findBy(id);

        return ResponseMessage.of(customer);
    }

    @PostMapping
    public ResponseEntity<ResponseMessage<Customer>> create(@Valid @RequestBody Customer customer) {
        final var savedCustomer = customerService.save(customer);

        final var locationUri = ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(savedCustomer.getId())
                .toUri();

        return ResponseEntity.created(locationUri).body(ResponseMessage.of(savedCustomer));
    }

    @PutMapping("/{id}")
    public ResponseMessage<Customer> update(@PathVariable Long id, @RequestBody Customer customer) {
        final var toUpdate = customerService.findBy(id);
        final var updatedcustomer = customerService.update(id, toUpdate);

        return ResponseMessage.of(updatedcustomer);
    }

}
