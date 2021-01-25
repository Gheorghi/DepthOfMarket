import orderbook.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class TestOrderBook {
    OrderBook book;

    @BeforeEach
    void setUp() {
        DataSource dataSet = new DataSource();
        this.book = new OrderBook(
                new Asks(dataSet.getMap("asks")),
                new Bids(dataSet.getMap("bids"))
        );
    }

    @Test
    void testSetOrderInOrderBook() {
        this.book.setOrder(1.0, 3, "a");
        this.book.setOrder(1.1, 5, "b");

        assertEquals(1.0, this.book.asks.getOrders().get(this.book.asks.getOrders().size() - 1).getPrice());
        assertEquals(1.1, this.book.bids.getOrders().get(this.book.bids.getOrders().size() - 1).getPrice());
        assertEquals(3, this.book.asks.getOrders().get(this.book.asks.getOrders().size() - 1).getVolume());
        assertEquals(5, this.book.bids.getOrders().get(this.book.bids.getOrders().size() - 1).getVolume());
    }

    @Test
    void testGetOrderByIdFromOrderBook() {
        UUID id = this.book.getDepthOfMarket().get(0).getId();

        assertEquals(this.book.getDepthOfMarket().get(0).getId(), book.getOrderById(id).getId());
        assertEquals(this.book.getDepthOfMarket().get(0).getPrice(), book.getOrderById(id).getPrice());
        assertEquals(this.book.getDepthOfMarket().get(0).getVolume(), book.getOrderById(id).getVolume());
    }

    @Test
    void testRemoveOrderByIdFromOrderBook() {
        UUID id = this.book.getDepthOfMarket().get(0).getId();
        this.book.removeOrderById(id);
        assertEquals(null, this.book.getOrderById(id));
    }

    @Test
    void testGetDepthOfMarket() {
        this.book.setOrder(1.0, 3, "a");
        this.book.setOrder(1.1, 5, "b");

        DataSource dataSet = new DataSource();
        OrderBook testBook = new OrderBook(
                new Asks(dataSet.getMap("asks")),
                new Bids(dataSet.getMap("bids"))
        );
        testBook.setOrder(1.0, 3, "a");
        testBook.setOrder(1.1, 5, "b");

        assertEquals(this.book.getDepthOfMarket().size(), testBook.getDepthOfMarket().size());
        for (int i = 0; i < testBook.getDepthOfMarket().size(); i++) {
            assertEquals(this.book.getDepthOfMarket().get(i).getPrice(), testBook.getDepthOfMarket().get(i).getPrice());
            assertEquals(this.book.getDepthOfMarket().get(i).getVolume(), testBook.getDepthOfMarket().get(i).getVolume());
        }
    }
}
