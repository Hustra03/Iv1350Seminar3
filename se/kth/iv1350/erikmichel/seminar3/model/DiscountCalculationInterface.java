package se.kth.iv1350.erikmichel.seminar3.model;

public interface DiscountCalculationInterface {
    /*Definition of calculateTotalPriceAfterDiscount
     * @param saleInfo the saleInfo for which totalPriceAfterDiscount should be calculated
     * @return totalPriceAfterDiscount is the double calculated by the method
    */
    public double calculateTotalPriceAfterDiscount(SaleInfo saleInfo);
    /*Definition of calculateTotalVATAfterDiscount
     * @param saleInfo the saleInfo for which totalVATAfterDiscount should be calculated
     * @return totalVATAfterDiscount is the double calculated by the method
    */
    public double calculateTotalVATAfterDiscount(SaleInfo saleInfo);
}
