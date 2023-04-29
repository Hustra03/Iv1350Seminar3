package intergration;

public class ItemDescriptionDTO {

	private int itemId;

	private String name;

	private double price;

	private int VATrate;

	private String description;

	/*
	 * Constructor for an empty ItemDescriptionDTO
	 */
	public ItemDescriptionDTO() {
	}

	/*
	 * Constructor for an ItemDescriptionDTO with specified price and VAT-rate for testing purposes
	 * @param price represents the price for one item of this type
	 * @param VATrate represents the percent of price as VAT
	 */
	public ItemDescriptionDTO(int itemId,double price, int VATrate) {
		this.itemId=itemId;
		this.price = price;
		this.VATrate = VATrate;
	}

	/*
	 * Constructor for an ItemDescriptionDTO with specified attributes
	 * @param itemId represents this items identification number
	 * @param name represents this items name
	 * @param price represents the price for one item of this type
	 * @param VATrate represents the percent of price as VAT
	 * @param description represents a short description of this item
	 * 
	 */
	public ItemDescriptionDTO(int itemId, String name, double price, int VATrate, String description) {
		this.itemId=itemId;
		this.name=name;
		this.price = price;
		this.VATrate = VATrate;
		this.description=description;
	}

	/*
	 * Returns itemId from itemDescriptionDTO
	 * 
	 * @return itemId this is the id for an item, represented by an int
	 */
	public int getItemId() {
		return this.itemId;
	}

	/*
	 * Returns name from itemDescriptionDTO
	 * 
	 * @return name this is the name for an item, represented by a String
	 */
	public String getName() {
		return this.name;
	}

	/*
	 * Returns price from itemDescriptionDTO
	 * 
	 * @return price this is the id for an item, represented by a double
	 */
	public double getPrice() {
		return this.price;
	}

	/*
	 * Returns VATrate from itemDescriptionDTO
	 * 
	 * @return VATrate this is the tax rate for an item, represented by an int
	 */
	public int getVATrate() {
		return this.VATrate;
	}

	/*
	 * Returns itemId from itemDescriptionDTO
	 * 
	 * @return itemId this is the description for an item, represented by a String
	 */
	public String getDescription() {
		return this.description;
	}
}
