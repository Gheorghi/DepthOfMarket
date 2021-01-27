package orderbook;

import orderbook.interfaces.SortableInterface;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;
import java.util.UUID;
/**
 * Bids is a realization class of Orders which provides a constructor to add new Bid orders,
 * also implements the sorting behavior of SortableInterface
 * @author Gheorghi
 */
public class Bids extends Orders implements SortableInterface {

    /**
     * Constructor that fills the list of Bid orders
     * by existing market data
     * @param orders Market orders
     */
    public Bids(ArrayList<Map<String, String>> orders) {
        for (Map<String, String> order : orders) {
            this.addOrder(
                    new Bid(
                            Double.parseDouble(order.get("price")),
                            Integer.parseInt(order.get("volume")),
                            UUID.randomUUID()
                    )
            );
        }
        this.sort();
    }

    /**
     * Method sort() to sort Bids orders by price
     */
    @Override
    public void sort() {
        this.getOrders().sort(Comparator.comparingDouble(Order::getPrice));
    }
}
