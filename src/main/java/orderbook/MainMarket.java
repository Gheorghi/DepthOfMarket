package orderbook;

import com.fasterxml.jackson.core.JsonProcessingException;

public class MainMarket {

    public static void main(String[] args) {
        DataSource dataSet = new DataSource();
        Asks asks = new Asks(dataSet.getMap("asks"));
        Bids bids = new Bids(dataSet.getMap("bids"));
        OrderBook book = new OrderBook(asks, bids);
        book.setOrder(60.3,24,"A");
        book.setOrder(111.0,23,"A");


        try {
            System.out.println(new MarketDataReport().getMarkerShapshot(asks,bids));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        for (Order order : book.getDepthOfMarket()) {
            System.out.println(order.getPrice().toString()+':'+order.getVolume());
        }
    }
}
