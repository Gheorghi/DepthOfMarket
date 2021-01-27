package orderbook;

import orderbook.interfaces.Presenter;

import java.util.ArrayList;

/**
 * Class ConsoleOrderPresenter that implements Presenter
 * to display the description of orders and header of market columns
 */
public class ConsoleOrderPresenter implements Presenter {

    /**
     * Method display(..) that displays the Order details.
     */
    @Override
    public void display(Order order) {
        System.out.println("Id: " + order.getId());
        System.out.println("Price: " + order.getPrice());
        System.out.println("Volume: " + order.getVolume());
        System.out.println("Type: " + order.getClass().getSimpleName());
    }

    /**
     * Method display(..) provides a header for market columns
     */
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
