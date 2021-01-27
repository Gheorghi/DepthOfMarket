package orderbook;

import java.util.UUID;

/**
 * Ask class that extends the Order and delegates the data to Order
 * @author Gheorghi
 */
public class Ask extends Order {
    public Ask(Double price, int volume, UUID id) {
        super(price, volume, id);
    }
}
