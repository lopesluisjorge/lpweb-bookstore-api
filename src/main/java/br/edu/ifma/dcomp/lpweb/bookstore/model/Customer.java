package br.edu.ifma.dcomp.lpweb.bookstore.model;

import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotEmpty;

public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_id_seq")
    @SequenceGenerator(name = "customer_id_seq", sequenceName = "customer_id_seq", allocationSize = 1)
    private Long id;

    @Column(name = "name")
    private String fullName;

    @CPF
    @Column(unique = true)
    private String cpf;

    private LocalDate birthdate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    private Address address;

    private String email;

    @ElementCollection
    @CollectionTable(name = "phones",
                     joinColumns = @JoinColumn(name = "customer_id"))
    @Column(name = "phone")
    private List<@NotEmpty String> phones = new ArrayList<>();

}
