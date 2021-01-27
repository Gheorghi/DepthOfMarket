package orderbook;

import orderbook.interfaces.BookInterface;

import java.util.*;

/**
 * Class OrderBook implements the behavior of BookInterface
 * Initializes Asks and Bids objects
 * Implements methods to set / get / remove orders from OrderBook
 * Provides:
 *      method getDepthOfMarket() to merge Asks and Bids orders
 *      method mergeOrders() to display the markets actual elements
 * @author Gheorghi
 */

public class OrderBook implements BookInterface {
    public Asks asks;
    public Bids bids;

    public OrderBook(Asks asks, Bids bids) {
        this.asks = asks;
        this.bids = bids;
    }

    public OrderBook() {
    }

    /**
     * Method setOrder(..) to set a new Order
     * @param price price of new order
     * @param type type of new order
     * @param volume volume of new order
     */
    @Override
    public void setOrder(Double price, int volume, String type) {
        String message = "";
        if (type.equalsIgnoreCase("B")) {
            this.bids.getOrders().add((new Bid(price, volume, UUID.randomUUID())));
            message = "The bid has been set";
        } else if (type.equalsIgnoreCase("A")) {
            this.asks.getOrders().add((new Ask(price, volume, UUID.randomUUID())));
            message = "The ask has been set";
        }
        System.out.println(message);
    }

    /**
     * Method getOrderById(..) to remove the Order by ID
     * @param id id of Order to get
     */
    @Override
    public Order getOrderById(UUID id) {
        return this.getDepthOfMarket()
                .stream()
                .filter((order) -> order.getId().equals(id))
                .reduce((prev, next) -> next)
                .orElse(null);
    }

    /**
     * Method removeOrderById(..) to remove the Order by ID
     * @param id id of Order to remove
     */
    @Override
    public void removeOrderById(UUID id) {
        for (Order order : this.getDepthOfMarket()) {
            if (order.getId().equals(id)) {
                this.asks.getOrders().remove(order);
                this.bids.getOrders().remove(order);
                System.out.println("Order has been removed by ID: " + id);
            }
        }
    }

    /**
     * Merges all orders and
     * @return ArrayList<Order> list of merged orders
     */
    private ArrayList<Order> mergeOrders() {
        ArrayList<Order> depthOfMarket = new ArrayList<Order>();
        this.asks.getOrders().sort(Collections.reverseOrder(new OrderCompareDesc()));
        this.bids.getOrders().sort(Comparator.comparingDouble(Order::getPrice));

        depthOfMarket.addAll(this.asks.getOrders());
        depthOfMarket.addAll(this.bids.getOrders());
        return depthOfMarket;
    }

    /**
     * Wrapper method to interact with private mergeOrders() method
     * @return  Merged ArrayList<Order> of Orders
     */
    public ArrayList<Order> getDepthOfMarket() {
        return mergeOrders();
    }

}

