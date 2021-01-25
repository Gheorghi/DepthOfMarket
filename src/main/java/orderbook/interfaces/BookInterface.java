package orderbook.interfaces;

import orderbook.Order;

import java.util.UUID;

public interface BookInterface {
    void setOrder(Double price, int volume, String type);
    Order getOrderById(UUID id);
    void removeOrderById(UUID id);
}
