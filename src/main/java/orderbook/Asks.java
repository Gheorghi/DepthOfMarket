package orderbook;

import orderbook.interfaces.SortableInterface;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.UUID;

/**
 * Asks is a realization class of Orders which provides a constructor to add new Ask orders,
 * also implements the sorting behavior of SortableInterface
 * @author Gheorghi
 */
public class Asks extends Orders implements SortableInterface {

    /**
     * Constructor that fills the list of Ask orders
     * by existing market data
     * @param orders Market orders
     */
    public Asks(ArrayList<Map<String, String>> orders) {
        for (Map<String, String> order : orders) {
            this.addOrder(
                    new Ask(
                            Double.parseDouble(order.get("price")),
                            Integer.parseInt(order.get("volume")),
                            UUID.randomUUID()
                    )
            );
        }
        this.sort();
    }

    /**
     * Method sort() to sort Asks orders by price in DESC order
     */
    @Override
    public void sort() {
        this.getOrders().sort(Collections.reverseOrder(new OrderCompareDesc()));
    }
}
