package andrianova.bookstore.domain;

public class Book {

    private final String name;
    private final Integer publishYear;
    private final Price price;

    public Book(String name, Integer publishYear, Price price) {
        this.name = name;
        this.publishYear = publishYear;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public Integer getPublishYear() {
        return publishYear;
    }

    public Price getPrice() {
        return price;
    }
}
