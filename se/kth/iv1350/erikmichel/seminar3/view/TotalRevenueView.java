package se.kth.iv1350.erikmichel.seminar3.view;

import se.kth.iv1350.erikmichel.seminar3.model.TotalRevenueObserver;

/* Is supposed to show the total income on the usersinterface
     *
     */
public class TotalRevenueView implements TotalRevenueObserver{
    public void TotalRevenueUpdate(double totalRevenue)
    {System.out.println("Total Revenue :" + totalRevenue);}
}
