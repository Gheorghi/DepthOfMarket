package orderbook;

import orderbook.interfaces.SortableInterface;

import java.util.*;

public class Asks extends Orders implements SortableInterface {

    public Asks(ArrayList<Map<String, String>> orders) {
        for (Map<String, String> order : orders) {
            this.orders.add(
                    new Ask(
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
        this.orders.sort(Collections.reverseOrder(new OrderCompareDesc()));
    }
}
