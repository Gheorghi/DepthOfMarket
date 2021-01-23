package orderbook;

import orderbook.interfaces.BookInterface;

import java.util.*;

public class OrderBook implements BookInterface {
    ArrayList<Order> asks;
    ArrayList<Order> bids;

    public OrderBook(Orders asks, Orders bids) {
        this.asks = asks.orders;
        this.bids = bids.orders;

        this.asks.sort(Comparator.comparingDouble(Order::getPrice));
        Collections.sort(this.asks, Collections.reverseOrder(new OrderCompareDesc()));
        this.bids.sort(Comparator.comparingDouble(Order::getPrice));
    }

    @Override
    public void setOrder(Double price, int volume, String type) {
        if (type.equalsIgnoreCase("B")) {
            this.bids.add((new Bid(price, volume, UUID.randomUUID())));
        } else if (type.equalsIgnoreCase("A")) {
            this.asks.add((new Ask(price, volume, UUID.randomUUID())));
        }
    }

    @Override
    public List<Order> getOrderById(UUID id) {
        List<Order> orders = new ArrayList<>();
        for (Order order : this.getDepthOfMarket()) {
            if (order.getId() == id) {
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
            if (order.getId() == id) {
                orders.remove(order);
                System.out.println("Order has been removed by ID: " + id);
            }
        }
    }

    private ArrayList<Order> mergeOrders() {
        ArrayList<Order> depthOfMarket = new ArrayList<Order>();
        this.asks.sort(Comparator.comparingDouble(Order::getPrice));
        Collections.sort(this.asks, Collections.reverseOrder(new OrderCompareDesc()));
        this.bids.sort(Comparator.comparingDouble(Order::getPrice));

        depthOfMarket.addAll(this.asks);
        depthOfMarket.addAll(this.bids);
        return depthOfMarket;
    }

    public ArrayList<Order> getDepthOfMarket() {
        return mergeOrders();
    }

    public void fillTheBookFromConsole() {
        System.out.println("Would you like to enter a new Order? (Yes/No)");
        String desitionString = new Scanner(System.in).next();
        while (desitionString.equalsIgnoreCase("yes")) {
            System.out.println("Enter an order details like: price, volume, type(A for asks || B for bids");
            Scanner keyboard = new Scanner(System.in);
            Double price = keyboard.nextDouble();
            int volume = keyboard.nextInt();
            String type = keyboard.next();
            System.out.println("Entered-: Price: " + price + ", volume: " + volume + ", type: " + type);
            this.setOrder(price, volume, type);
            System.out.println("Would you like to enter more Order? (Yes/No)");
            desitionString = new Scanner(System.in).next();
        }
    }
}

