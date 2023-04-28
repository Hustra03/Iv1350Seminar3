package model;

public class Discount {

	private int discountPercent;

	private int applicableId;

	private SaleInfo saleInfo;


	public Discount(int discountPercent, int applicableId, SaleInfo saleInfo) {
		this.discountPercent=discountPercent;
		this.applicableId=applicableId;
		this.saleInfo = saleInfo;
	}

}
