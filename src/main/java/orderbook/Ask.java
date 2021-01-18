package orderbook;

import java.util.Collections;
import java.util.UUID;

public class Ask extends Order {

    public Ask(Double price, int volume, UUID id) {
        super(price, volume, id);
    }

}
