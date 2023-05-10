package se.kth.iv1350.erikmichel.seminar3.intergration;
import java.util.List;
import se.kth.iv1350.erikmichel.seminar3.model.SaleInfo;

public class SaleInfoDTO {
    private SaleDTO saledto;

	private List<DiscountDTO> recordedDiscounts;

	private CustomerPaymentDTO customerPayment;

	private double discountTotalPrice;

	private double discountTotalVAT;

	private int customerId;

    /*
	 * Creates an SaleInfo object based upon a sale with an empty discount list and
	 * calculates discountTotalPrice and discountTotalVAT
	 * 
	 * @param Sale is the sale object this saleInfo describes and becomes the sale
	 * attribute
	 */
	public SaleInfoDTO(SaleInfo saleInfo) {
		this.saledto = new SaleDTO(saleInfo.getSale());
        this.recordedDiscounts=saleInfo.getRecordedDiscounts();
        this.customerPayment=saleInfo.getCustomerPaymentDTO();
        this.discountTotalPrice=saleInfo.getTotalPriceAfterDiscount();
        this.discountTotalVAT=saleInfo.getTotalVATAfterDiscount();
        this.customerId=saleInfo.getCustomerId();
	}

    /*
	 * Returns discounted total price
	 * 
	 * @return discountTotalPrice represents the total price after every discount
	 * has been applied
	 */
	public double getTotalPriceAfterDiscount() {
		return this.discountTotalPrice;
	}

	/*
	 * Returns total Value Added Tax after discount
	 * 
	 * @return discountetTotalVAT represents the total VAT after every discount has
	 * been applied
	 */
	public double getTotalVATAfterDiscount() {
		return this.discountTotalVAT;
	}

	/*
	 * Returns the sale object this class describes
	 * 
	 * @return this.sale represents the sale this saleInfo should describe
	 */
	public SaleDTO getSale() {
		return this.saledto;
	}

	/*
	 * Returns the customerPayment included in this object and for the sale it
	 * describes
	 * 
	 * @return this.customerPayment represents the payment made by the customer
	 * along with
	 * information about it
	 */
	public CustomerPaymentDTO getCustomerPaymentDTO() {
		return this.customerPayment;
	}

	/*
	 * Returns the customerId included in this object and for the sale it
	 * describes
	 * 
	 * @return this.customerId represents the customerId for the customer this sale
	 * is for
	 */
	public int getCustomerId() {
		return this.customerId;
	}

	/*
	 * Returns the recordedDiscounts included in this object and for the sale it
	 * describes
	 * 
	 * @return this.recordedDiscounts list of applicable discounts applied to this
	 * sale
	 */
	public List<DiscountDTO> getRecordedDiscounts() {
		return this.recordedDiscounts;
	}
}
