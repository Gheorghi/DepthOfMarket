package orderbook.interfaces;

import orderbook.Order;

import java.util.List;
import java.util.UUID;

public interface BookInterface {
    public void setOrder(Double price, int volume, String type);
    public List<Order> getOrderById(UUID id);
    public void removeOrderById(UUID id);
}
