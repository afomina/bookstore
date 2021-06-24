package andrianova.bookstore.service.impl;

import andrianova.bookstore.domain.Book;
import andrianova.bookstore.domain.Price;
import andrianova.bookstore.domain.Product;
import andrianova.bookstore.domain.discount.BookCondition;
import andrianova.bookstore.domain.discount.ConditionImpl;
import andrianova.bookstore.domain.discount.Discount;
import andrianova.bookstore.domain.discount.Property;
import andrianova.bookstore.service.DiscountService;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

import static andrianova.bookstore.domain.discount.BookCondition.BookProperty.YEAR;
import static andrianova.bookstore.domain.discount.ConditionImpl.Clause.MORE;

public class DiscountServiceImpl implements DiscountService {

    @Override
    public List<Discount<Book>> getBookDiscounts() {
        return Collections.singletonList(
                new Discount<>(Collections.singletonList(new BookCondition(YEAR, MORE, new Property<>(2000))),
                               BigDecimal.valueOf(0.9)));
    }

    @Override
    public List<Discount<Product>> getPriceDiscounts() {
        return Collections.singletonList(
                new Discount<>(Collections.singletonList(
                        new ConditionImpl<>(MORE, new Property<>(new Product(Price.of(BigDecimal.valueOf(30.0)))))),
                               BigDecimal.valueOf(0.95)));
    }
}
