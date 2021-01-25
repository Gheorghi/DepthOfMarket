import orderbook.Asks;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestAsks {

    public String[][] asksUnsorted = {
            {"51.4", "7"},
            {"50.7", "5"},
            {"52.3", "23"},
            {"56.4", "12"},
            {"57.9", "5"},
            {"54.3", "12"},
            {"53.5", "43"}
    };

    public String[][] asksSorted = {
            {"57.9", "5"},
            {"56.4", "12"},
            {"54.3", "12"},
            {"53.5", "43"},
            {"52.3", "23"},
            {"51.4", "7"},
            {"50.7", "5"}
    };

    @Test
    void checkAsksIsSortedAsDescending() {
        Asks asks = new Asks(setTestData(asksUnsorted));
        for (int i = 0; i<asksSorted.length; i++){
            assertEquals(Double.parseDouble(asksSorted[i][0]),asks.getOrders().get(i).getPrice());
            assertEquals(Double.parseDouble(asksSorted[i][1]),asks.getOrders().get(i).getVolume());
        }
    }

    ArrayList<Map<String, String>> setTestData(String[][] orders) {
        ArrayList<Map<String, String>> ordersList = new ArrayList<>();
        for (String[] order : orders) {
            Map<String, String> orderMap = new HashMap<String, String>();
            orderMap.put("price", order[0]);
            orderMap.put("volume", order[1]);
            ordersList.add(orderMap);
        }
        return ordersList;
    }
}
