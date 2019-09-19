package leonardqoli.howest.pwa30.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TicketsResponse {

    @SerializedName("error")
    private boolean err;

    private List<Ticket> tickets;

    public TicketsResponse(boolean err, List<Ticket> tickets) {
        this.err = err;
        this.tickets = tickets;
    }

    public boolean isErr() {
        return err;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }
}
