package andrianova.bookstore.domain;

public class Book {
    private final String name;
    private final Integer publishYear;
    private final Double price;

    public Book(String name, Integer publishYear, Double price) {
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

    public Double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", publishYear=" + publishYear +
                ", price=" + price +
                '}';
    }
}
