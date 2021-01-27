package orderbook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * The class that is using as a data source class for initial values
 */
public class DataSource {

    public String[][] bids = {
            {"55.1", "12"},
            {"56.2", "13"},
            {"58.4", "6"},
            {"53.5", "77"},
            {"55.6", "54"},
            {"58.7", "3"},
            {"50.8", "7"}
    };

    public String[][] asks = {
            {"51.4", "7"},
            {"50.7", "5"},
            {"52.3", "23"},
            {"56.4", "12"},
            {"57.9", "5"},
            {"54.3", "12"},
            {"53.5", "43"}
    };

    /**
     * Method getMap(..) converts the array of orders to the ArrayList of Maps
     * @return ArrayList<Map<String, String>>
     */
    public ArrayList<Map<String, String>> getMap(String type){
        ArrayList<Map<String, String>> ordersList = new ArrayList<>();
        String[][] orders;

        if(type.equals("asks")){
            orders = this.asks;
        } else {
            orders = this.bids;
        }
        for (String[] order : orders) {
            Map<String, String> orderMap = new HashMap<String, String>();
            orderMap.put("price", order[0]);
            orderMap.put("volume", order[1]);
            ordersList.add(orderMap);
        }

        return ordersList;
    }
}
