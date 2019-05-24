package br.edu.ifma.bookstore.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class ItemRentalPk implements Serializable {

    private static final long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

    @ManyToOne
    @JoinColumn(name = "rental_id")
    private Rental rental;

    public ItemRentalPk() {
    }

    public ItemRentalPk(Item item, Rental rental) {
        this.item = item;
        this.rental = rental;
    }

    public Item getItem() {
        return item;
    }

    public Rental getRental() {
        return rental;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((item == null) ? 0 : item.hashCode());
        result = prime * result + ((rental == null) ? 0 : rental.hashCode());
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
        ItemRentalPk other = (ItemRentalPk) obj;
        if (item == null) {
            if (other.item != null)
                return false;
        } else if (!item.equals(other.item))
            return false;
        if (rental == null) {
            if (other.rental != null)
                return false;
        } else if (!rental.equals(other.rental))
            return false;
        return true;
    }

}
