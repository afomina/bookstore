package andrianova.bookstore.domain.discount;

import andrianova.bookstore.domain.Book;

public class BookCondition implements Condition<Book> {

    private final BookProperty property;
    private final ConditionImpl.Clause clause;
    private final Property<Object> value;

    public BookCondition(BookProperty property, ConditionImpl.Clause clause, Property<Object> value) {
        this.property = property;
        this.clause = clause;
        this.value = value;
    }

    public enum BookProperty {
        NAME, YEAR, PRICE
    }

    @Override
    public boolean applies(Book book) {
        Object object = null;
        switch (property) {
            case YEAR -> object = book.getPublishYear();
            case NAME -> object = book.getName();
            case PRICE -> object = book.getPrice();
        }
        return new ConditionImpl<>(clause, value).applies(object);
    }
}
