# bookstore app

* To run the app use command

`mvn install && java -jar target\bookstore-1.0.0.jar`

* use Java 15
* book catalog is parsed from `books.txt` file
* format is `%book name% (%year%) £%price%`
* only `£` currency is supported
* discounts are hardcoded in `andrianova.bookstore.service.impl.DiscountServiceImpl`
* assuming that total sum discount is applied after other discounts
