package orderbook;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import orderbook.interfaces.ReportInterface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MarketDataReport implements ReportInterface {
    @Override
    public String getMarkerShapshot(Asks asks, Bids bids) throws JsonProcessingException {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        Map<String, ArrayList> asksList = new HashMap<>();
        Map<String, ArrayList> bidsList = new HashMap<>();
        asks.sort();
        bids.sort();
        asksList.put("asks", asks.getOrders());
        bidsList.put("bids", bids.getOrders());
        String json = ow.writeValueAsString(asksList) +  ow.writeValueAsString(bidsList);
        return json;
    }
}
