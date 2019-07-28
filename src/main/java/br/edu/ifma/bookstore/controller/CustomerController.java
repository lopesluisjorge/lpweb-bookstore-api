package br.edu.ifma.bookstore.controller;

import java.net.URI;

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
        final Customer customer = customerService.findBy(id);

        return ResponseMessage.ofContent(customer);
    }

    @PostMapping
    public ResponseEntity<ResponseMessage<Customer>> create(@Valid @RequestBody Customer customer) {
        final Customer savedCustomer = customerService.save(customer);

        final URI locationUri = ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(savedCustomer.getId())
                .toUri();

        return ResponseEntity.created(locationUri).body(ResponseMessage.ofContent(savedCustomer));
    }

    @PutMapping("/{id}")
    public ResponseMessage<Customer> update(@PathVariable Long id, @RequestBody Customer customer) {
        final Customer toUpdate = customerService.findBy(id);
        final Customer updatedcustomer = customerService.update(id, toUpdate);

        return ResponseMessage.ofContent(updatedcustomer);
    }

}
