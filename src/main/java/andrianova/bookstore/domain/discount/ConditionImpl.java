package andrianova.bookstore.domain.discount;

public class ConditionImpl<T extends Comparable<T>> implements Condition<T> {

	protected final Clause clause;
	protected final T value;

	public ConditionImpl(Clause clause, T value) {
		this.clause = clause;
		this.value = value;
	}

	public boolean applies(T object) {
		switch (clause) {
			case LESS -> {
				return object.compareTo(value) < 0;
			}
			case MORE -> {
				return object.compareTo(value) > 0;
			}
			case EQUAL -> {
				return object.equals(value);
			}
		}
		return false;
	}
}
