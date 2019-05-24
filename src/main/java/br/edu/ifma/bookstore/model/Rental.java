package br.edu.ifma.bookstore.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "rental")
public class Rental {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rental_id_seq")
    @SequenceGenerator(name = "rental_id_seq", sequenceName = "rental_id_seq", allocationSize = 1)
    private Long id;

    private BigDecimal totalPrice;

    private LocalDate rentalDate;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToMany(mappedBy = "id.rental")
    private Set<ItemRental> itemRentals = new LinkedHashSet<>();

    @JsonIgnore
    private LocalDateTime createdAt;

    @JsonIgnore
    private LocalDateTime updatedAt;

    public void beforePersist() {
        var totalPrice = BigDecimal.ZERO;
        itemRentals.forEach(itemRental -> totalPrice.add(itemRental.getPrice()));
        this.totalPrice = totalPrice;
        this.createdAt = LocalDateTime.now();
    }
    
    public void beforeUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public LocalDate getRentalDate() {
        return rentalDate;
    }

    public void setRentalDate(LocalDate rentalDate) {
        this.rentalDate = rentalDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Set<ItemRental> getItemRentals() {
        return itemRentals;
    }

    public void add(ItemRental... itemRentals) {
        this.itemRentals.addAll(Arrays.asList(itemRentals));
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

}
