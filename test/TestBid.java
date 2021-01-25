
import orderbook.Bid;
import orderbook.Order;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class TestBid {

    @Test
    void testBidHasCorrectData(){
        UUID id = UUID.randomUUID();
        Bid bid = new Bid(11.23, 2, id);
        assertAll("Bid",
                () -> assertEquals(11.23, bid.getPrice()),
                () -> assertEquals(2, bid.getVolume()),
                () -> assertEquals(id, bid.getId()),
                () -> assertTrue(bid instanceof Order)
        );
    }

    @Test
    void testBidSetters(){
        UUID id = UUID.randomUUID();
        Bid  bid = new Bid(42.23, 4, id);
        bid.setPrice(57.0);
        bid.setVolume(9);
        assertAll("Bid",
                () -> assertEquals(57.0, bid.getPrice()),
                () -> assertEquals(9, bid.getVolume()),
                () -> assertEquals(id, bid.getId()),
                () -> assertTrue(bid instanceof Order)
        );
    }

}
