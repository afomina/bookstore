package andrianova.bookstore.domain.discount;

import andrianova.bookstore.domain.Book;
import andrianova.bookstore.domain.Price;

public class BookCondition implements Condition<Book> {

    public enum BookPropertyType {
        NAME, YEAR, PRICE
    }

    private final BookPropertyType property;
    private final Clause clause;
    private final Object value;

    public static BookCondition year(Clause clause, Integer value) {
        return new BookCondition(BookPropertyType.YEAR, clause, value);
    }

    private BookCondition(BookPropertyType property,
                          Clause clause,
                          Object value) {
        this.property = property;
        this.clause = clause;
        this.value = value;
    }

    @Override
    public boolean check(Book book) {
        switch (property) {
            case YEAR -> {
                return new ComparingCondition<>(clause, (Integer) value).check(book.getPublishYear());
            }
            case NAME -> {
                return new ComparingCondition<>(clause, (String) value).check(book.getName());
            }
            case PRICE -> {
                return new ComparingCondition<>(clause, (Price) value).check(book.getPrice());
            }
        }
        return false;
    }
}
