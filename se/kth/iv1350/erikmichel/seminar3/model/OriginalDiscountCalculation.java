package se.kth.iv1350.erikmichel.seminar3.model;

import se.kth.iv1350.erikmichel.seminar3.intergration.DiscountDTO;

public class OriginalDiscountCalculation implements DiscountInterface {

    /* Creates empty object of OriginalDiscountCalculation class
     * 
     */
    public OriginalDiscountCalculation() {
    }
    /* Calculates total price after discount for specified saleInfo
     * @param saleInfo is the object for which total price should be calculated
     * @return is the calculated totalPrice
     */
    @Override
    public double calculateTotalPriceAfterDiscount(SaleInfo saleInfo) {
        double discountTotalPrice = saleInfo.getSale().getTotalPrice();
        if (!saleInfo.getRecordedDiscounts().isEmpty()) {
            discountTotalPrice = 0;
            for (Item item : saleInfo.getSale().getSoldItems()) {
                double actualDiscount = 1;
                for (DiscountDTO discount : saleInfo.getRecordedDiscounts()) {
                    if (discount.getApplicableId().contains(item.getItemDescriptionDTO().getItemId())) {
                        double thisDiscount = 100 - discount.getDiscountPercent();
                        thisDiscount /= 100;
                        actualDiscount = actualDiscount * thisDiscount;
                    }
                }
                discountTotalPrice += item.getPriceForQuantity() * actualDiscount;
            }
        }
        return discountTotalPrice;
    }
    /* Calculates total vat after discount for specified saleInfo
     * @param saleInfo is the object for which total vat should be calculated
     * @return is the calculated totalVat
     */
    @Override
    public double calculateTotalVATAfterDiscount(SaleInfo saleInfo) {
        double discountTotalVAT = saleInfo.getSale().getTotalVAT();
        if (!saleInfo.getRecordedDiscounts().isEmpty()) {
            discountTotalVAT = 0;
            for (Item item : saleInfo.getSale().getSoldItems()) {
                double actualDiscount = 1;
                for (DiscountDTO discount : saleInfo.getRecordedDiscounts()) {
                    if (discount.getApplicableId().contains(item.getItemDescriptionDTO().getItemId())) {
                        double thisDiscount = 100 - discount.getDiscountPercent();
                        thisDiscount /= 100;
                        actualDiscount = actualDiscount * thisDiscount;
                    }
                }
                discountTotalVAT += item.getPriceForQuantity() * actualDiscount
                        * (item.getItemDescriptionDTO().getVATrate() / 100);
            }
        }
        return discountTotalVAT;
    }
}
