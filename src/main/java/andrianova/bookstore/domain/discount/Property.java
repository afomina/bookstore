package andrianova.bookstore.domain.discount;

import java.util.Objects;

public class Property<T> {

    protected final T value;

    public Property(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Property<?> property = (Property<?>) o;
        return value.equals(property.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
