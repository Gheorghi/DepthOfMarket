package orderbook;

import orderbook.interfaces.BookInterface;

import java.util.*;

public class OrderBook implements BookInterface {
    public Asks asks;
    public Bids bids;

    public OrderBook(Asks asks, Bids bids) {
        this.asks = asks;
        this.bids = bids;
    }

    public OrderBook() {
    }

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

    @Override
    public Order getOrderById(UUID id) {
        return this.getDepthOfMarket()
                .stream()
                .filter((order) -> order.getId().equals(id))
                .reduce((prev, next) -> next)
                .orElse(null);
    }

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

    private ArrayList<Order> mergeOrders() {
        ArrayList<Order> depthOfMarket = new ArrayList<Order>();
        this.asks.getOrders().sort(Collections.reverseOrder(new OrderCompareDesc()));
        this.bids.getOrders().sort(Comparator.comparingDouble(Order::getPrice));

        depthOfMarket.addAll(this.asks.getOrders());
        depthOfMarket.addAll(this.bids.getOrders());
        return depthOfMarket;
    }


    public ArrayList<Order> getDepthOfMarket() {
        return mergeOrders();
    }

}

