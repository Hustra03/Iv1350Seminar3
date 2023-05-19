package se.kth.iv1350.erikmichel.seminar3.model;

import se.kth.iv1350.erikmichel.seminar3.intergration.DiscountDTO;

public class AlternativeDiscountCalculation implements DiscountInterface{
    /* Creates empty object of AlternativeDiscountCalculation class
     * 
     */
    public AlternativeDiscountCalculation() {
    }
    /* Calculates total price after discount for specified saleInfo
     * @param saleInfo is the object for which total price should be calculated
     * @return is the calculated totalPrice
     */
    @Override
    public double calculateTotalPriceAfterDiscount(SaleInfo saleInfo) {
        double discount=1;
        if (!saleInfo.getRecordedDiscounts().isEmpty()) {
            for (DiscountDTO recoredDiscount : saleInfo.getRecordedDiscounts()) {
                discount*= (recoredDiscount.getDiscountPercent()/100);
            }
        }
        return saleInfo.getSale().getTotalPrice()*discount;
    }

    /* Calculates total vat after discount for specified saleInfo
     * @param saleInfo is the object for which total vat should be calculated
     * @return is the calculated totalVat
     */
    @Override
    public double calculateTotalVATAfterDiscount(SaleInfo saleInfo) {
        double discount=1;
        if (!saleInfo.getRecordedDiscounts().isEmpty()) {
            for (DiscountDTO recoredDiscount : saleInfo.getRecordedDiscounts()) {
                discount*= (recoredDiscount.getDiscountPercent()/100);
            }
        }
        return saleInfo.getSale().getTotalVAT()*discount;
    }
    
}
