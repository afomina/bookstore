package andrianova.bookstore;

import andrianova.bookstore.domain.Book;
import andrianova.bookstore.service.BookService;
import andrianova.bookstore.service.impl.BookServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CheckoutTest {

	private final BookService bookService = new BookServiceImpl();
	private final Checkout checkout = new Checkout();

	@Test
	public void checkoutTest1() {
		List<Book> books = Arrays.asList(
				bookService.findByName("The Terrible Privacy of Maxwell Sim").orElseThrow(),
				bookService.findByName("Three Men in a Boat").orElseThrow()
		);
		assertEquals(BigDecimal.valueOf(24.69), checkout.checkoutSum(books));
	}

    @Test
    public void checkoutTest2() {
		List<Book> books = Arrays.asList(
				bookService.findByName("Still Life With Woodpecker").orElseThrow(),
				bookService.findByName("Three Men in a Boat").orElseThrow(),
				bookService.findByName("Great Expectations").orElseThrow()
		);
		assertEquals(BigDecimal.valueOf(35.27), checkout.checkoutSum(books));
	}

	@Test
	public void checkoutTest3() {
		List<Book> books = Arrays.asList(
				bookService.findByName("The Terrible Privacy of Maxwell Sim").orElseThrow(),
				bookService.findByName("Three Men in a Boat").orElseThrow(),
				bookService.findByName("Great Expectations").orElseThrow()
		);
		assertEquals(BigDecimal.valueOf(36.01), checkout.checkoutSum(books));
	}

	@Test
	public void should_calc_when_oneBook() {
		List<Book> books = Collections.singletonList(
				bookService.findByName("Moby Dick").orElseThrow()
		);
		assertEquals(BigDecimal.valueOf(15.20).setScale(2), checkout.checkoutSum(books));
	}

	@Test
	public void should_calc_when_books_empty() {
		List<Book> books = Collections.emptyList();
		assertEquals(BigDecimal.ZERO.setScale(2), checkout.checkoutSum(books));
	}
}
