package leonardqoli.howest.pwa30.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GuestsResponse {

    @SerializedName("error")
    private boolean err;

    private List<Guest> guests;

    public GuestsResponse(boolean err, List<Guest> guests) {
        this.err = err;
        this.guests = guests;
    }

    public boolean isErr() {
        return err;
    }

    public List<Guest> getGuests() {
        return guests;
    }
}
