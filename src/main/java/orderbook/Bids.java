package orderbook;

import orderbook.interfaces.SortableInterface;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;
import java.util.UUID;

public class Bids extends Orders implements SortableInterface {

    public Bids(ArrayList<Map<String, String>> orders) {
        for (Map<String, String> order : orders) {
            this.orders.add(
                    new Bid(
                            Double.parseDouble(order.get("price")),
                            Integer.parseInt(order.get("volume")),
                            UUID.randomUUID()
                    )
            );
        }
        this.sort();
    }

    @Override
    public void sort() {
        this.orders.sort(Comparator.comparingDouble(Order::getPrice));
    }
}
