package test;

import orderbook.Bids;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestBids {

    public String[][] bindsUnsorted = {
            {"51.4", "7"},
            {"50.7", "5"},
            {"52.3", "23"},
            {"56.4", "12"},
            {"57.9", "5"},
            {"54.3", "12"},
            {"53.5", "43"}
    };

    public String[][] bidsSorted = {
            {"50.7", "5"},
            {"51.4", "7"},
            {"52.3", "23"},
            {"53.5", "43"},
            {"54.3", "12"},
            {"56.4", "12"},
            {"57.9", "5"}
    };

    @Test
    void checkBidssIsSortedAsDescending() {
        Bids bids = new Bids(setTestData(bindsUnsorted));
        for (int i = 0; i<bidsSorted.length; i++){
            assertEquals(Double.parseDouble(bidsSorted[i][0]),bids.orders.get(i).getPrice());
            assertEquals(Double.parseDouble(bidsSorted[i][1]),bids.orders.get(i).getVolume());
        }
    }

    ArrayList<Map<String, String>> setTestData(String[][] bids) {
        ArrayList<Map<String, String>> ordersList = new ArrayList<>();
        for (String[] order : bids) {
            Map<String, String> orderMap = new HashMap<String, String>();
            orderMap.put("price", order[0]);
            orderMap.put("volume", order[1]);
            ordersList.add(orderMap);
        }
        return ordersList;
    }
}
