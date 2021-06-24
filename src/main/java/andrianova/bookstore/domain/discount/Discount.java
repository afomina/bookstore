package andrianova.bookstore.domain.discount;

import java.math.BigDecimal;
import java.util.List;

public class Discount<T> {

    private final List<Condition<T>> conditions;
    private final BigDecimal multiplier;

    public Discount(List<Condition<T>> conditions, BigDecimal multiplier) {
        this.conditions = conditions;
        this.multiplier = multiplier;
    }

    public boolean applies(T object) {
        for (Condition<T> condition : conditions) {
            if (!condition.applies(object)) {
                return false;
            }
        }
        return true;
    }

    public BigDecimal getMultiplier() {
        return multiplier;
    }
}
