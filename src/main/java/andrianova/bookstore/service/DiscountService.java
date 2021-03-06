package andrianova.bookstore.service;

import andrianova.bookstore.domain.Book;
import andrianova.bookstore.domain.Price;
import andrianova.bookstore.domain.discount.Discount;

import java.util.List;

public interface DiscountService {

	List<Discount<Book>> getBookDiscounts();

	List<Discount<Price>> getPriceDiscounts();
}
