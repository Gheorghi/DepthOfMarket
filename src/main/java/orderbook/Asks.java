package orderbook;

import orderbook.interfaces.SortableInterface;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.UUID;

public class Asks extends Orders implements SortableInterface {

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

    @Override
    public void sort() {
        this.getOrders().sort(Collections.reverseOrder(new OrderCompareDesc()));
    }
}
