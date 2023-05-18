package se.kth.iv1350.erikmichel.seminar3.model;

public interface TotalRevenueObserver {
    /*
     * Invoked when total revenues has been calculated and should be updated
     * @param registerBalance represents current total balance
     */
    void TotalRevenueUpdate(double registerBalance);
}
