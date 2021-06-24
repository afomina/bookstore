package andrianova.bookstore.domain.discount;

public interface Condition<T> {

	enum Clause {
		LESS, MORE, EQUAL
	}

	boolean applies(T object);
}
