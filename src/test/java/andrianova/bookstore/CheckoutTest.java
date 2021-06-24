package andrianova.bookstore;

import andrianova.bookstore.domain.Book;
import andrianova.bookstore.service.BookService;
import andrianova.bookstore.service.impl.BookServiceImpl;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CheckoutTest {

    private BookService bookService = new BookServiceImpl();
	private Checkout checkout = new Checkout();

    @Test
    public void checkoutTest1() {
        List<Book> books = Arrays.asList(
                bookService.findByName("The Terrible Privacy of Maxwell Sim").orElseThrow(),
                bookService.findByName("Three Men in a Boat").orElseThrow()
        );
		assertEquals(checkout.checkoutSum(books), Double.valueOf(24.69));
    }

    @Test
    public void checkoutTest2() {
        List<Book> books = Arrays.asList(
                bookService.findByName("Still Life With Woodpecker").orElseThrow(),
                bookService.findByName("Three Men in a Boat").orElseThrow(),
                bookService.findByName("Great Expectations").orElseThrow()
        );
		assertEquals(checkout.checkoutSum(books), Double.valueOf(35.27));
    }

    @Test
    public void checkoutTest3() {
        List<Book> books = Arrays.asList(
                bookService.findByName("The Terrible Privacy of Maxwell Sim").orElseThrow(),
                bookService.findByName("Three Men in a Boat").orElseThrow(),
                bookService.findByName("Great Expectations").orElseThrow()
        );
		assertEquals(checkout.checkoutSum(books), Double.valueOf(36.01));
    }
}
