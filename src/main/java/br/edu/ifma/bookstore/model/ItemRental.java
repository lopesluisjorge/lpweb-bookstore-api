package br.edu.ifma.bookstore.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "item_rental")
public class ItemRental {

    @EmbeddedId
    private ItemRentalPk id;

    private BigDecimal rentalPrice;

    @Min(value = 0)
    @Max(value = 99)
    private BigDecimal discount = BigDecimal.ZERO;

    @NotNull
    private LocalDate rentalDate;

    private LocalDate returnDate;

    @Deprecated
    public ItemRental() {
    }

    public ItemRental(ItemRentalPk itemRentalPk) {
        this.id = itemRentalPk;
        final BigDecimal itemPrice = id.getItem().getPrice();
        this.rentalPrice = itemPrice.subtract(itemPrice.multiply(this.discount));
    }

    @PrePersist
    public void beforePersist() {
        final BigDecimal itemPrice = id.getItem().getPrice();
        this.rentalPrice = itemPrice.subtract(itemPrice.multiply(this.discount));
    }

    public ItemRentalPk getId() {
        return id;
    }

    public BigDecimal getPrice() {
        return rentalPrice;
    }

    public LocalDate getRentalDate() {
        return rentalDate;
    }
    
    public void setRentalDate(LocalDate rentalDate) {
        this.rentalDate = rentalDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

}
