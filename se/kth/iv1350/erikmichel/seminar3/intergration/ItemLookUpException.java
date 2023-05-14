package se.kth.iv1350.erikmichel.seminar3.intergration;

public class ItemLookUpException extends Exception {

    private int itemId;
    /*Creates a new RegisterItemException with specified message and itemId
     * @param msg string message this exception will print
     * @param itemIdNotFound represents the id entered by user which caused the error
     */
    public ItemLookUpException(String msg, int itemIdNotFound) {
        super(msg);
        this.itemId = itemIdNotFound;
    } 

    /*
     * 
     */
    public int getItemId()
    {return this.itemId;}
}
