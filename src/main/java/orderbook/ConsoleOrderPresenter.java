package orderbook;

import orderbook.interfaces.Presenter;

import java.util.ArrayList;

public class ConsoleOrderPresenter implements Presenter {
    @Override
    public void display(Order order) {
        System.out.println("Id: " + order.getId());
        System.out.println("Price: " + order.getPrice());
        System.out.println("Volume: " + order.getVolume());
        System.out.println("Type: " + order.getClass().getSimpleName());
    }

    @Override
    public void display(ArrayList<Order> orders) {
        System.out.println("***********************");
        System.out.println("ID  |  Price  :  Volume");
        System.out.println("***********************");
        for (Order order : orders) {
            System.out.println(order.getId().toString()+"  |  "+order.getPrice().toString() + " : " + order.getVolume());
        }
    }
}
