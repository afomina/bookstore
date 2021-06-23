package andrianova.bookstore;

import andrianova.bookstore.domain.Book;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class Checkout {

    public static Double checkoutSum(List<Book> books) {
        Double sum = 0.0;
        for (Book book : books) {
            if (book.getPublishYear() > 2000) {
                sum += book.getPrice() * 0.9;
            } else {
                sum += book.getPrice();
            }
        }
        if (sum > 30.0) {
            sum *= 0.95;
        }
        return new BigDecimal(sum).setScale(2, RoundingMode.FLOOR).doubleValue();
    }
}
