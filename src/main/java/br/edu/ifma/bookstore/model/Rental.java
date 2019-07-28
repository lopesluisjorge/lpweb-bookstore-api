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
import javax.persistence.PrePersist;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name = "rental")
public class Rental {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rental_id_seq")
    @SequenceGenerator(name = "rental_id_seq", sequenceName = "rental_id_seq", allocationSize = 1)
    private Long id;

    private BigDecimal subtotal;

    private LocalDate rentalDate;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToMany(mappedBy = "id.rental")
    private Set<ItemRental> itemsRental = new LinkedHashSet<>();

    @JsonIgnore
    private LocalDateTime createdAt;

    @JsonIgnore
    private LocalDateTime updatedAt;

    @PrePersist
    public void beforePersist() {
        this.subtotal = calculeSubtotal();
        this.createdAt = LocalDateTime.now();
    }

    public void beforeUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

    public BigDecimal getSubtotal() {
        if (subtotal == null) {
            return calculeSubtotal();
        }
        return subtotal;
    }

    public void add(ItemRental... itemsRental) {
        this.itemsRental.addAll(Arrays.asList(itemsRental));
    }

    private BigDecimal calculeSubtotal() {
        return itemsRental.stream()
                .map(itemRental -> itemRental.getRentalPrice())
                .reduce(BigDecimal.ZERO, (sum, price) -> sum.add(price));
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
        Rental other = (Rental) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

}
