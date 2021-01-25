package orderbook;

import com.fasterxml.jackson.core.JsonProcessingException;

public class MainMarket {

    public static void main(String[] args) throws JsonProcessingException {
        DataSource dataSet = new DataSource();
        Asks asks = new Asks(dataSet.getMap("asks"));
        Bids bids = new Bids(dataSet.getMap("bids"));
        ConsoleApp app = new ConsoleApp(new OrderBook(asks, bids));
        app.run();
    }
}
