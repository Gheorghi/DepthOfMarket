package orderbook;

import java.util.ArrayList;

/**
 * Abstract Orders class that provides the common functionality to interact with any order
 * @author Gheorghi
 */
public abstract class Orders {
    private ArrayList<Order> orders = new ArrayList<>();

    /**
     * Method getOrders() to get orders list
     * @return ArrayList<Order> of orders
     */
    public ArrayList<Order> getOrders() {
        return orders;
    }

    /**
     * Method addOrder() adds orders from existing source of orders to the Asks/Bids order's list
     * @param order order to add
     */
    public void addOrder(Order order) {
        this.orders.add(order);
    }
}
