package br.edu.ifma.bookstore.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

import lombok.Data;

@Data
@Entity
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_id_seq")
    @SequenceGenerator(name = "address_id_seq", sequenceName = "address_id_seq", allocationSize = 1)
    private Long id;

    @NotNull
    @Size(min = 8, max = 8)
    @NumberFormat(style = Style.NUMBER)
    private String cep;

    @Size(min = 3)
    private String street;

    @NumberFormat(style = Style.NUMBER)
    private String number;

    @NotEmpty
    private String neighborhood;

    @NotEmpty
    private String city;

    @Column(name = "uf", length = 2)
    private String uf;

    @Lob
    private String complement;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

}
