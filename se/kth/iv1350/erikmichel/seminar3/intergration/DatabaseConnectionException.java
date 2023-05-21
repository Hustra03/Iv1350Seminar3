package se.kth.iv1350.erikmichel.seminar3.intergration;

public class DatabaseConnectionException extends RuntimeException  {
    /*
     * Creates a new DatabaseConnectionException 
     * 
     */
    public DatabaseConnectionException() {
        super("Database could not be reached due to unspecified error, ensure local connection is functional and database not down for maintenance");
    }
}
