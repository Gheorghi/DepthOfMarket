package orderbook;

import orderbook.interfaces.BookInterface;

import java.util.*;

public class OrderBook implements BookInterface {
    ArrayList<Order> asks;
    ArrayList<Order> bids;

    public OrderBook(Orders asks, Orders bids) {
        this.asks = asks.orders;
        this.bids = bids.orders;
    }

    @Override
    public void setOrder(Double price, int volume, String type) {
        if(type.equals("B")){
            this.bids.add((new Bid(price, volume, UUID.randomUUID())));
        } else if (type.equals("A")){
            this.asks.add((new Ask(price, volume, UUID.randomUUID())));
        }
    }

    @Override
    public List<Order> getOrderById(UUID id) {
        List<Order> orders = new ArrayList<>();
        for (Order order : this.getDepthOfMarket()) {
            if (order.getId() == id){
                orders.add(order);
                System.out.println("The order has been added");
            }
        }
        return orders;
    }

    @Override
    public void removeOrderById(UUID id) {
        List<Order> orders = new ArrayList<>();
        for (Order order : this.getDepthOfMarket()) {
            if (order.getId() == id){
                orders.remove(order);
                System.out.println("Order has been removed by ID: " + id);
            }
        }
    }

    private ArrayList<Order> mergeOrders(){
        ArrayList<Order> depthOfMarket = new ArrayList<Order>();
        this.asks.sort(Comparator.comparingDouble(Order::getPrice));
        Collections.sort(this.asks, Collections.reverseOrder(new OrderCompare()));
        this.bids.sort(Comparator.comparingDouble(Order::getPrice));

        depthOfMarket.addAll(this.asks);
        depthOfMarket.addAll(this.bids);
        return depthOfMarket;
    }

    public ArrayList<Order> getDepthOfMarket() {
        return mergeOrders();
    }
}

