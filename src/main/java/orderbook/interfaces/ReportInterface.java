package orderbook.interfaces;

import com.fasterxml.jackson.core.JsonProcessingException;
import orderbook.Asks;
import orderbook.Bids;
import orderbook.Orders;

public interface ReportInterface {
    String getMarkerShapshot(Asks asks, Bids bids) throws JsonProcessingException;
}
