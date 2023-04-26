# se.kth.iv1350.ErikMichel.Seminar3

This project will attempt to produce a working program based on a design produced as part of IV1350 Object Oriented Design at KTH Kista. The assignment flow is as follows:

Basic Flow
1. Customer arrives at POS with goods to purchase.
2. Cashier starts a new sale.
3. Cashier enters item identifier.
4. Program retrieves price, VAT (tax) rate, and item description from the external
inventory system. Program records the sold item. Program also presents item
description, price, and running total (including VAT).
5. Steps three and four are repeated until the cashier has registered all items.
6. Cashier asks customer if they want to buy anything more.
7. Customer answers ’no’ (a ’yes’ answer will be considered later).
8. Cashier ends the sale.
9. Program presents total price, including VAT.
10. Cashier tells customer the total, and asks for payment.
11. Customer pays cash.
12. Cashier enters amount paid
13. Program logs completed sale.
14. Program sends sale information to external accounting system (for accounting)
and external inventory system (to update inventory).
15. Program increases the amount present in the register with the amount paid.
16. Program prints receipt and tells how much change to give customer.
17. Customer leaves with receipt and goods.

Alternative Flows:
3-4a. No item with the specified identifier is found.
1. Program tells that identifier is invalid.

3-4b. An item with the specified identifier has already been entered in the current sale.
1. Program increases the sold quantity of the item, and presents item description,
price, and running total.

3-4c. Customer purchases multiple items of the same goods (with the same identifier),
and cashier registers them together.
1. Cashier enters item identifier.
2. Cashier enters quantity
3. Program calculates price, records the sold item and quantity, and presents item
description, price, and running total.

9a (may also be 10a or 11a) Customer says they are eligible for a discount.
1. Cashier signals discount request.
2. Cashier enters customer identification.
3. Program fetches discount from the discount database, see Business Rules and Clar-
ifications below.
4. Program presents price after discount, based on discount rules. See Business Rules
and Clarifications below for more details on discounts.

Business Rules and Clarifications
Taxes/VAT The VAT mentioned in basic flow, bullets four and six, is not included in
the price stored in the store’s item registry. It must instead be added before the
total price is calculated. There are three different VAT rates: 25%, 12% and 6%.
Each item description in the item registry must contain information about that
item’s VAT rate.

Sale log: Bullet ten in basic flow specifies that each sale shall be logged. This log shall
contain all available information about each sale.

Receipt: The receipt mentioned in basic flow, bullets 13 and 14, contains the following
information:
 Date and time of sale.
 Name, quantity and price for each item.
 Total price for the entire sale.
 VAT for the entire sale
 Amount paid and change

Discounts: The discounts mentioned in alternative flow 9a are calculated based on bought
item, number of items bought, total cost for the entire sale, and customer id. A
customer might be eligible for more than one type of discount. There’s already a
database which contains information about all existing discounts, discount infor-
mation must be fetched from this database.

The code shall be compilable and executable. You have to program in Java, since
everyone must be able to understand your solution at the seminar. Also, don’t use
exceptions now, since that’s a topic of seminar four, not understood by everyone
now at seminar three.
 If the user interface is replaced with hard-coded method calls, the class calling
the controller must print everything that is returned by the controller.
Also the receipt must be printed (to System.out).

 To pass (1 point) you must write unit tests for two classes. Try to find something
more interesting to test than get/set methods. You have to write new test classes,
you’re not allowed to use the given tests, that is AmountTest from the textbook and
MainTest from the lecture Practice Programming and Unit Testing.
 To pass with distinction (2 points) you must write unit tests for all classes in the
layers controller, model, and integration, except classes that have just getters
and constructors that only store values. It is also not required to test that output
to System.out is correct, just ignore testing methods that only produce output to
System.out.

This will be done in collaboration between Erik Paulinder and Michel Högberg.
