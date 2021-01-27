package orderbook;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import orderbook.interfaces.ReportInterface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Class MarketDataReport provides a JSON report of market values
 */
public class MarketDataReport implements ReportInterface {

    /**
     * Method getMarketShapshot(..) combines together the provided parameters of Asks and Bids,
     * filters out the ID
     * @return String
     */
    @Override
    public String getMarketShapshot(Asks asks, Bids bids) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        SimpleFilterProvider filterProvider = new SimpleFilterProvider();

        filterProvider.addFilter(
                "uuidFilter",
                SimpleBeanPropertyFilter.filterOutAllExcept("price","volume")
        );
        mapper.setFilterProvider(filterProvider);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();

        Map<String, ArrayList> asksList = new HashMap<>();
        Map<String, ArrayList> bidsList = new HashMap<>();

        asksList.put("asks", asks.getOrders());
        bidsList.put("bids", bids.getOrders());

        return ow.writeValueAsString(asksList) + ow.writeValueAsString(bidsList);
    }
}
