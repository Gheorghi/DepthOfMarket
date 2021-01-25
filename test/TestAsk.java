
import orderbook.Ask;
import orderbook.Order;
import org.junit.jupiter.api.Test;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class TestAsk {

    @Test
    void testAskHasCorrectData(){
        UUID id = UUID.randomUUID();
        Ask ask = new Ask(33.33, 3, id);
        assertAll("Ask",
                () -> assertEquals(33.33, ask.getPrice()),
                () -> assertEquals(3, ask.getVolume()),
                () -> assertEquals(id, ask.getId()),
                () -> assertTrue(ask instanceof Order)
        );
    }

    @Test
    void testAskSetters(){
        UUID id = UUID.randomUUID();
        Ask  ask = new Ask(44.33, 4, id);
        ask.setPrice(55.0);
        ask.setVolume(5);
        assertAll("Ask",
                () -> assertEquals(55.0, ask.getPrice()),
                () -> assertEquals(5, ask.getVolume()),
                () -> assertEquals(id, ask.getId()),
                () -> assertTrue(ask instanceof Order)
        );
    }

}
