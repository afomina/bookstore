package andrianova.bookstore.domain.discount;

import java.math.BigDecimal;
import java.util.List;

/**
 * Discount
 *
 * @param <T> type of the object for which discount applies
 */
public class Discount<T> {

    private final List<Condition<T>> conditions;
    private final BigDecimal multiplier;

    /**
     * @param conditions list of discount conditions
     * @param multiplier discount multiplier
     */
    public Discount(List<Condition<T>> conditions, BigDecimal multiplier) {
        this.conditions = conditions;
        this.multiplier = multiplier;
    }

    /**
     * Checks if product meets the conditions for applying the discount
     * @param product product
     * @return true if discount applies to this product
     */
    public boolean applies(T product) {
        for (Condition<T> condition : conditions) {
            if (!condition.check(product)) {
                return false;
            }
        }
        return true;
    }

    public BigDecimal getMultiplier() {
        return multiplier;
    }
}
