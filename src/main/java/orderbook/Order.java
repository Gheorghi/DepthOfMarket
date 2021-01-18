package orderbook;

import orderbook.interfaces.OrderInterface;

import java.util.UUID;

public abstract class Order implements OrderInterface {

    private Double price;
    private int volume;
    private UUID id;

    public Order(Double price, int volume, UUID id) {
        this.price = price;
        this.volume = volume;
        this.id = id;
    }

    protected UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }
}
