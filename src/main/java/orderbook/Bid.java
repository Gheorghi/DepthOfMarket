package orderbook;

import java.util.UUID;
/**
 * Bid class that extends the Order and delegates the data to Order
 * @author Gheorghi
 */
public class Bid extends Order {

    public Bid(Double price, int volume, UUID id) {
        super(price, volume, id);
    }


}
