package br.edu.ifma.bookstore.model;

import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_id_seq")
    @SequenceGenerator(name = "customer_id_seq", sequenceName = "customer_id_seq", allocationSize = 1)
    private Long id;

    @NotEmpty
    @Size(max = 255)
    @Column(nullable = false)
    private String name;

    @NotNull
    @CPF
    @Column(nullable = false, unique = true)
    private String cpf;

    @NotNull
    @Past
    @Column(nullable = false)
    private LocalDate birthdate;

    @OneToOne(mappedBy = "customer", cascade = CascadeType.ALL)
    private Address address;

    @NotNull
    @Email
    private String email;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @ElementCollection
    @CollectionTable(name = "phones",
                     joinColumns = @JoinColumn(name = "customer_id"))
    @Column(name = "phone")
    private final Set<@NotEmpty String> phones = new LinkedHashSet<>();

    @OneToMany(mappedBy = "customer")
    private final Set<Rental> rentals = new LinkedHashSet<>();

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String fullName) {
        this.name = fullName;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Set<String> getPhones() {
        return phones;
    }

    public void addPhone(String phone) {
        this.phones.add(phone);
    }
    
    public Set<Rental> getRentals() {
        return rentals;
    }
    
    public void add(Rental... rentals) {
        this.rentals.addAll(Arrays.asList(rentals));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Customer other = (Customer) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

}
