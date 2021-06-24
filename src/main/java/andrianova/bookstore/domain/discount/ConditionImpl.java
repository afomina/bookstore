package andrianova.bookstore.domain.discount;

public class ConditionImpl<T> implements Condition<T> {

	protected final Clause clause;
	protected final Property<T> value;

	public enum Clause {
		LESS, MORE, EQUAL
	}

	public ConditionImpl(Clause clause, Property<T> value) {
		this.clause = clause;
		this.value = value;
	}

	public boolean applies(T object) {
		switch (clause) {
			case LESS -> {
				return ((Comparable) object).compareTo(value.getValue()) < 0;
			}
			case MORE -> {
				return ((Comparable) object).compareTo(value.getValue()) > 0;
			}
			case EQUAL -> {
				return object.equals(value.getValue());
			}
		}
		return false;
	}
}
