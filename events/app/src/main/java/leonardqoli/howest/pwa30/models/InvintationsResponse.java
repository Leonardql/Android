package leonardqoli.howest.pwa30.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class InvintationsResponse {

        @SerializedName("error")
        private boolean err;

        private List<Invintation> invintations;

    public InvintationsResponse(boolean err, List<Invintation> invintations) {
        this.err = err;
        this.invintations = invintations;
    }

    public boolean isErr() {
        return err;
    }

    public List<Invintation> getInvintations() {
        return invintations;
    }
}
