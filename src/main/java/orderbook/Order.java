package orderbook;

import com.fasterxml.jackson.annotation.JsonFilter;
import orderbook.interfaces.OrderInterface;
import orderbook.interfaces.Presenter;

import java.util.UUID;

@JsonFilter("uuidFilter")
public abstract class Order implements OrderInterface {

    private Double price;
    private int volume;
    private UUID id;

    public Order(Double price, int volume, UUID id) {
        this.setPrice(price);
        this.setVolume(volume);
        this.setId(id);
    }

    public UUID getId() {
        return id;
    }

    protected void setId(UUID id) {
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

    public void showDetails(Presenter presenter){
        presenter.display(this);
    }
}
