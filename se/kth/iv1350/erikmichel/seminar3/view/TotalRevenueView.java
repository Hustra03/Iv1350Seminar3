package se.kth.iv1350.erikmichel.seminar3.view;

import se.kth.iv1350.erikmichel.seminar3.model.TotalRevenueObserver;

/* Is supposed to show the total income on the usersinterface
     *
     */
public class TotalRevenueView implements TotalRevenueObserver {
    private double totalRevenue;

    /*
     * Creates a new observer of TotalRevenueView class with empty attributes
     * 
     */
    public TotalRevenueView() {
    }

    /*
     * Updates attribute totalRevenue and prints that value to system.out
     * 
     * @param totalRevenue this represents the current total revenue which is to be
     * printed to sytem.out
     */
    @Override
    public void TotalRevenueUpdate(double totalRevenue) {
        this.totalRevenue = totalRevenue;
        PrintTotalRevenue();
    }

    /*
     * Prints current totalRevenue attribute to system.out
     */
    private void PrintTotalRevenue() {
        System.out.println("Total Revenue :" + totalRevenue);
    }
}
