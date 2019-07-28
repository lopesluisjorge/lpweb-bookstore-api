package br.edu.ifma.bookstore.customer;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifma.bookstore.support.service.CrudService;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    private final CrudService<Customer, Long> crudService;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;

        this.crudService = new CrudService<>(customerRepository);
    }

    public Customer findBy(Long id) {
        return crudService.findBy(id);
    }

    public Customer save(Customer customer) {
        Customer toSave = new Customer();
        BeanUtils.copyProperties(customer, toSave, "id");
        return customerRepository.save(customer);
    }

    public Customer update(Long id, Customer customer) {
        return crudService.update(id, customer);
    }

}
