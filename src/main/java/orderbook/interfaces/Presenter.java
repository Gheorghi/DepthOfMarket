package orderbook.interfaces;

import orderbook.Order;

import java.util.ArrayList;

public interface Presenter {
    void display(Order order);
    void display(ArrayList<Order> order);
}
