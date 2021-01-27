package orderbook;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.Scanner;
import java.util.UUID;

/**
 * ConsoleApp is a class that provides to the USER to interact with the program through console
 *
 * @author Gheorghi
 */
public class ConsoleApp {
    OrderBook orderBook;
    ConsoleOrderPresenter presenter = new ConsoleOrderPresenter();

    /**
     * Provides an OrderBook object to the ConsoleApp object to operate with
     */
    public ConsoleApp(OrderBook orderBook) {
        this.orderBook = orderBook;
    }

    /**
     * Method menu() shows the options that are available for the USER
     */
    private void menu() {
        System.out.println("\n");
        System.out.println("************************");
        System.out.println("****Application Menu****");
        System.out.println("************************");
        System.out.println("1. Market Status");
        System.out.println("2. Market Report");
        System.out.println("3. Register order");
        System.out.println("4. See order");
        System.out.println("5. Remove order");
        System.out.println("6. Quit");
    }

    /**
     * The inputReader() reads the keyboard input values
     * @return String
     */
    private String inputReader() {
        Scanner keyboard = new Scanner(System.in);
        return keyboard.next();
    }

    /**
     * The askForInput() method asks from the user the input values for a proper purposes
     * @return String
     */
    private String askForInput(String question) {
        String input = "";

        while (input.equals("")) {
            System.out.println(question);
            input = this.inputReader();
        }

        return input;
    }

    /**
     * The method run() is using for providing/retrieving/viewing the data from/to application
     * provides a user friendly interaction
     *
     * @throws JsonProcessingException that comes from getMarketShapshot()
     */
    public void run() throws JsonProcessingException {
        String selection = "";
        while (!selection.equalsIgnoreCase("6")) {
            this.menu();
            selection = this.askForInput("Enter please the action you would like to perform from above list");
            switch (selection) {
                case "1": {
                    this.displayTheMarket();
                    break;
                }
                case "2": {
                    String report = new MarketDataReport().getMarketShapshot(this.orderBook.asks, this.orderBook.bids);
                    System.out.println(report);
                    break;
                }
                case "3": {
                    Double price = Double.parseDouble(this.askForInput("Please enter order price:"));
                    int volume = Integer.parseInt(this.askForInput("Please enter order volume:"));
                    String type = this.askForInput("Please enter order type:");
                    orderBook.setOrder(price, volume, type);
                    this.displayTheMarket();
                    break;
                }
                case "4": {
                    String id = this.askForInput("Please enter the order id for details:");
                    try {
                        this.orderBook.getOrderById(UUID.fromString(id)).showDetails(presenter);
                    } catch (Exception e) {
                        System.out.println("There is no order with provided ID: " + id);
                    }
                    break;
                }
                case "5": {
                    String id = this.askForInput("Please enter the order id for removal:");
                    String agree = "";
                    try {
                        this.orderBook.getOrderById(UUID.fromString(id)).showDetails(presenter);
                        agree = this.askForInput(
                                "You are going to permanently remove the above order. Are you sure? (Yes/No)"
                        );
                    } catch (Exception e) {
                        System.out.println("There is no order with provided ID: " + id);
                    }

                    if (agree.equalsIgnoreCase("yes")) {
                        this.orderBook.removeOrderById(UUID.fromString(id));
                    }
                    this.displayTheMarket();
                    break;
                }
                case "6": {
                    selection = "6";
                    break;
                }
            }
        }
    }

    /**
     * The displayTheMarket() method is displaying the markets actual elements
     */
    private void displayTheMarket() {
        this.presenter.display(this.orderBook.getDepthOfMarket());
    }
}
