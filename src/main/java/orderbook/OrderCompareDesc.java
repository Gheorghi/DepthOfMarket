package orderbook;

import java.util.Comparator;

/**
 * Class OrderCompareDesc implements Comparator<Order>
 * to implement a contract method to compare objects by value
 * @author Gheorghi
 */
class OrderCompareDesc implements Comparator<Order>
{
    /**
     * Method compare(..) that compares Orders by price
     * @param one Order one to be compared
     * @param two Order two to be compared
     */
    public int compare(Order one, Order two)
    {
        return one.getPrice().compareTo(two.getPrice());
    }
}