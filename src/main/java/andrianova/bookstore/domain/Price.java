package andrianova.bookstore.domain;

import java.math.BigDecimal;

public class Price implements Comparable<Price> {

    private final BigDecimal value;

    private Price(BigDecimal value) {
        this.value = value;
    }

    public static Price of(BigDecimal value) {
        return new Price(value);
    }

    public BigDecimal getValue() {
        return value;
    }

    @Override
    public int compareTo(Price o) {
        return value.compareTo(o.getValue());
    }
}
