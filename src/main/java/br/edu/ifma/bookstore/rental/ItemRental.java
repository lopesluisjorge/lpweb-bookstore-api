package br.edu.ifma.bookstore.rental;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.PrePersist;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity
public class ItemRental implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private ItemRentalPk id;

    private BigDecimal rentalPrice;

    @Min(value = 0)
    @Max(value = 99)
    private BigDecimal discount = BigDecimal.ZERO;

    @NotNull
    private LocalDate rentalDate;

    private LocalDate returnDate;

    public ItemRental(ItemRentalPk itemRentalPk) {
        this.id = itemRentalPk;
    }

    @PrePersist
    public void beforePersist() {
        final BigDecimal itemPrice = id.getItem().getPrice();
        this.rentalPrice = itemPrice.subtract(itemPrice.multiply(this.discount));
    }

}
