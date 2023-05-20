package se.kth.iv1350.erikmichel.seminar3.intergration;

public class ItemLookUpException extends Exception {

    private int itemId;

    /*
     * Creates a new RegisterItemException with specified message and itemId
     * 
     * @param msg string message this exception will print
     * 
     * @param itemIdNotFound represents the id entered by user which caused the
     * error
     */
    public ItemLookUpException(int itemIdNotFound) {
        super("Item with id: '"+ itemIdNotFound + "' Not Found In Database, refer to list created in database contructor for full list of itemid which should be valid");
        this.itemId = itemIdNotFound;
    }

    /*
     * Returns the itemId which resulted in the exception being thrown
     * @return itemId the id which threw an exception
     */
    public int getItemId()
    {return this.itemId;}
}
