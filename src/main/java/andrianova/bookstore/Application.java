package andrianova.bookstore;

import andrianova.bookstore.domain.Book;
import andrianova.bookstore.service.BookService;
import andrianova.bookstore.service.impl.BookServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        BookService bookService = new BookServiceImpl();
        Checkout checkout = new Checkout();

        List<Book> books = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter book names to buy");
        String bookName = scanner.nextLine();
        while (!bookName.isBlank()) {
            Optional<Book> book = bookService.findByName(bookName);
            book.ifPresentOrElse(books::add, () -> System.out.println("Not valid book name"));
            bookName = scanner.nextLine();
        }
        System.out.println("Total sum: " + checkout.checkoutSum(books));
    }
}
