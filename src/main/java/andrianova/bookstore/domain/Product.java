package andrianova.bookstore.domain;

public class Product implements Comparable<Product> {

    private final Price price;

    public Product(Price price) {
        this.price = price;
    }

    public Price getPrice() {
        return price;
    }

    @Override
    public int compareTo(Product o) {
        return price.compareTo(o.getPrice());
    }
}
