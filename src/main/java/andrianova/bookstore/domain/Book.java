package andrianova.bookstore.domain;

import java.math.BigDecimal;

public class Book extends Product {

    private final String name;
    private final Integer publishYear;

    public Book(String name, Integer publishYear, Double price) {
        super(Price.of(BigDecimal.valueOf(price)));
        this.name = name;
        this.publishYear = publishYear;
    }

    public String getName() {
        return name;
    }

    public Integer getPublishYear() {
        return publishYear;
    }

}
