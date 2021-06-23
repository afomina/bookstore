package andrianova.bookstore.service.impl;

import andrianova.bookstore.domain.Book;
import andrianova.bookstore.service.BookService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BookServiceImpl implements BookService {

    private static final String INPUT_FILE = "books.txt";
    private static final Pattern BOOK_PATTERN = Pattern.compile("(.+) \\((\\d+)\\) £([\\d.]+)");

    private final List<Book> books;

    public BookServiceImpl() {
        books = parseInput();
    }

    @Override
    public List<Book> getAll() {
        return books;
    }

    @Override
    public Optional<Book> findByName(String name) {
        return books.stream().filter(book -> name.equals(book.getName())).findFirst();
    }

    private List<Book> parseInput() {
        List<Book> books = new ArrayList<>();
        try {
            for (String line : Files.readAllLines(Path.of(INPUT_FILE))) {
                Matcher matcher = BOOK_PATTERN.matcher(line);
                if (matcher.matches()) {
                    Book book = new Book(matcher.group(1),
                            Integer.parseInt(matcher.group(2)),
                            Double.parseDouble(matcher.group(3)));
                    books.add(book);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return books;
    }

}
