package orderbook;

import java.util.Comparator;

class OrderCompare implements Comparator<Order>
{
    public int compare(Order one, Order two)
    {
        return one.getPrice().compareTo(two.getPrice());
    }
}