package andrianova.bookstore;

import andrianova.bookstore.domain.Book;
import andrianova.bookstore.domain.Price;
import andrianova.bookstore.domain.Product;
import andrianova.bookstore.domain.discount.Discount;
import andrianova.bookstore.service.DiscountService;
import andrianova.bookstore.service.impl.DiscountServiceImpl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class Checkout {

    private final DiscountService discountService = new DiscountServiceImpl();

    public Double checkoutSum(List<Book> books) {
        List<Discount<Book>> bookDiscounts = discountService.getBookDiscounts();
        BigDecimal sum = BigDecimal.ZERO;
        for (Book book : books) {
            BigDecimal price = book.getPrice().getValue();
            for (Discount<Book> discount : bookDiscounts) {
                if (discount.applies(book)) {
                    price = price.multiply(discount.getMultiplier());
                }
            }
            sum = sum.add(price);
        }

        List<Discount<Product>> discounts = discountService.getPriceDiscounts();
        for (Discount<Product> discount : discounts) {
            if (discount.applies(new Product(Price.of(sum)))) {
                sum = sum.multiply(discount.getMultiplier());
            }
        }
        return sum.setScale(2, RoundingMode.FLOOR).doubleValue();
    }
}
