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
    public boolean applies(Book book) {
        switch (property) {
            case YEAR -> {
                return new ConditionImpl<>(clause, (Integer) value).applies(book.getPublishYear());
            }
            case NAME -> {
                return new ConditionImpl<>(clause, (String) value).applies(book.getName());
            }
            case PRICE -> {
                return new ConditionImpl<>(clause, (Price) value).applies(book.getPrice());
            }
        }
        return false;
    }
}
