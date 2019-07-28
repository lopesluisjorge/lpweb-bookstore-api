package br.edu.ifma.bookstore.model;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

import br.edu.ifma.bookstore.book.Book;
import br.edu.ifma.bookstore.rental.Item;
import br.edu.ifma.bookstore.rental.ItemRental;
import br.edu.ifma.bookstore.rental.ItemRentalPk;
import br.edu.ifma.bookstore.rental.Rental;

public class RentalTest {

    @Test
    public void shouldSumAllPricesOfItemsInARental() {
        Book book1 = new Book();
        book1.setPrice(new BigDecimal("2"));
        Book book2 = new Book();
        book2.setPrice(new BigDecimal("3"));

        final Item item1 = Item.of(book1);
        final Item item2 = Item.of(book2);

        Rental rental = new Rental();

        ItemRental itemRental1 = new ItemRental(new ItemRentalPk(item1, rental));
        ItemRental itemRental2 = new ItemRental(new ItemRentalPk(item2, rental));

        rental.add(itemRental1, itemRental2);
        BigDecimal subtotal = rental.getSubtotal();
        BigDecimal expected = new BigDecimal("5");

        assertEquals(expected, subtotal);
    }

}
