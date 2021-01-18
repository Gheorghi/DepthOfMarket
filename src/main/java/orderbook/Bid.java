package orderbook;

import java.util.UUID;

public class Bid extends Order {

    public Bid(Double price, int volume, UUID id) {
        super(price, volume, id);
    }


}
