package andrianova.bookstore;

import andrianova.bookstore.domain.Book;
import andrianova.bookstore.service.BookService;
import andrianova.bookstore.service.impl.BookServiceImpl;

import java.util.Arrays;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        BookService bookService = new BookServiceImpl();

        List<Book> books = Arrays.asList(
                bookService.findByName("The Terrible Privacy of Maxwell Sim").orElseThrow(),
                bookService.findByName("Three Men in a Boat").orElseThrow()
        );
    }
}
