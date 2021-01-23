package orderbook;

import java.util.Comparator;

class OrderCompareDesc implements Comparator<Order>
{
    public int compare(Order one, Order two)
    {
        return one.getPrice().compareTo(two.getPrice());
    }
}