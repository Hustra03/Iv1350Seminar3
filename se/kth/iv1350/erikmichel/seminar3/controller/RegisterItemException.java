package se.kth.iv1350.erikmichel.seminar3.controller;

public class RegisterItemException  extends Exception{
    private int itemId;
    /*
     * Creates a new RegisterItemException with specified message and itemId
     * 
     * @param msg string message this exception will print
     * 
     * @param itemIdNotFound represents the id entered by user which caused the
     * error
     */
    public RegisterItemException(int itemIdNotFound, Exception cause) {
        super("Item with id: '"+ itemIdNotFound + "' Could not be registered due to Exception :",cause);
        this.itemId = itemIdNotFound;
    }

    /*
     * Returns the itemId which resulted in the exception being thrown
     * @return itemId the id which threw an exception
     */
    public int getItemId()
    {return this.itemId;}
}
