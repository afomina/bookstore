package andrianova.bookstore.domain.discount;

public class ComparingCondition<T extends Comparable<T>> implements Condition<T> {

	protected final Clause clause;
	protected final T value;

	public ComparingCondition(Clause clause, T value) {
		this.clause = clause;
		this.value = value;
	}

	public boolean check(T object) {
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
