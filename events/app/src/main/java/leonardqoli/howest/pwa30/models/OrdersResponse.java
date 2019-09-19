package leonardqoli.howest.pwa30.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class OrdersResponse {

    @SerializedName("error")
    private boolean err;

    private List<Order> orders;

    public OrdersResponse(boolean err, List<Order> orders) {
        this.err = err;
        this.orders = orders;
    }

    public boolean isErr() {
        return err;
    }

    public List<Order> getOrders() {
        return orders;
    }
}
