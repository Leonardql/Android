package leonardqoli.howest.pwa30.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ArtistsResponse {

        @SerializedName("error")
        private boolean err;

        private List<Artist> artists;

    public ArtistsResponse(boolean err, List<Artist> artists) {
        this.err = err;
        this.artists = artists;
    }

    public boolean isErr() {
        return err;
    }

    public List<Artist> getArtists() {
        return artists;
    }
}
