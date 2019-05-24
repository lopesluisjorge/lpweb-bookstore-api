package br.edu.ifma.bookstore.model;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "item_id_seq")
    @SequenceGenerator(name = "item_id_seq", sequenceName = "item_id_seq", allocationSize = 1)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    @Column(nullable = false, unique = true)
    private String code;

    private BigDecimal rentalPrice;

    @Enumerated(EnumType.STRING)
    private ItemStatus status;

    @OneToMany(mappedBy = "id.item")
    private Set<ItemRental> itemRentals = new LinkedHashSet<>();

    public void beforePersist() {
        this.rentalPrice = book.getPrice();
    }

    public Long getId() {
        return id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public BigDecimal getPrice() {
        return rentalPrice;
    }

    public ItemStatus getStatus() {
        return status;
    }
    
    public void setStatus(ItemStatus status) {
        this.status = status;
    }

    public Set<ItemRental> getItemRentals() {
        return itemRentals;
    }

    public void add(ItemRental... itemRentals) {
        this.itemRentals.addAll(Arrays.asList(itemRentals));
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
        Item other = (Item) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

}
