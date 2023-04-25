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
	public ItemDescriptionDTO()
	{}

	/*
	 * Returns itemId from itemDescriptionDTO
	 * @return itemId this is the id for an item, represented by an int
	 */
	public int getItemId()
	{
		return this.itemId;
	}

	/*
	 * Returns name from itemDescriptionDTO
	 * @return name this is the name for an item, represented by a String
	 */
	public String getName()
	{
		return this.name;
	}

	/*
	 * Returns price from itemDescriptionDTO
	 * @return price this is the id for an item, represented by a double
	 */
	public double getPrice()
	{
		return this.price;
	}

	/*
	 * Returns VATrate from itemDescriptionDTO
	 * @return VATrate this is the tax rate for an item, represented by an int
	 */
	public int getVATrate()
	{
		return this.VATrate;
	}

	/*
	 * Returns itemId from itemDescriptionDTO
	 * @return itemId this is the description for an item, represented by a String
	 */
	public String getDescription()
	{
		return this.description;
	}
}
