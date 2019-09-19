package leonardqoli.howest.events;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonPlaceHolderApi {

    @GET("guests")
    Call<List<Guest>> getGuests();
}
