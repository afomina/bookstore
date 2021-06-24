package andrianova.bookstore.domain.discount;

/**
 * A condition
 *
 * @param <T> object type for which condition can apply
 */
public interface Condition<T> {

	/**
	 * Checks if object meets the condition
	 *
	 * @param object object
	 *
	 * @return true if objects meets the condition
	 */
	boolean check(T object);
}
