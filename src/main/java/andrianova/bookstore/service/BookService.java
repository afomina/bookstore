package andrianova.bookstore.service;

import andrianova.bookstore.domain.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> getAll();

    Optional<Book> findByName(String name);
}
