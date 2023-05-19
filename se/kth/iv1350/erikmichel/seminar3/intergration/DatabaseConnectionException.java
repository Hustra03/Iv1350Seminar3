package se.kth.iv1350.erikmichel.seminar3.intergration;

public class DatabaseConnectionException extends RuntimeException  {
    /*
     * Creates a new DatabaseConnectionException 
     * 
     */
    public DatabaseConnectionException() {
        super("Database Could Not Be Reached Due To Unspecified Error");
    }
}
