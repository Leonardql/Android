package leonardqoli.howest.pwa30.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class EventsResponse {

    @SerializedName("error")
    private boolean err;

    private List<Event> events;

    public EventsResponse(boolean err, List<Event> events) {
        this.err = err;
        this.events = events;
    }

    public boolean isErr() {
        return err;
    }

    public List<Event> getEvents() {
        return events;
    }
}
