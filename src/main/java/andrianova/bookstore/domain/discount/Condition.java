package andrianova.bookstore.domain.discount;

public interface Condition<T> {

	boolean applies(T object);
}
