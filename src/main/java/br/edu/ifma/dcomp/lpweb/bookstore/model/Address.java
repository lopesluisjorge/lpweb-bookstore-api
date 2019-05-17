package br.edu.ifma.dcomp.lpweb.bookstore.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_id_seq")
    @SequenceGenerator(name = "address_id_seq", sequenceName = "address_id_seq", allocationSize = 1)
    @Column(name = "customer_id")
    private Long id;

    private String cep;

    private String street;

    private String number;

    private String neighborhood;

    private String city;

    private String state;

    @Lob
    private String complement;

    @OneToOne(mappedBy = "address")
    private Customer customer;
}
