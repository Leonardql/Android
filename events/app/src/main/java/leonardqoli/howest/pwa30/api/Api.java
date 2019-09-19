package leonardqoli.howest.pwa30.api;

import leonardqoli.howest.pwa30.models.ArtistsResponse;
import leonardqoli.howest.pwa30.models.DefaultResponse;
import leonardqoli.howest.pwa30.models.EventsResponse;
import leonardqoli.howest.pwa30.models.GuestsResponse;
import leonardqoli.howest.pwa30.models.InvintationsResponse;
import leonardqoli.howest.pwa30.models.LoginResponse;
import leonardqoli.howest.pwa30.models.OrdersResponse;
import leonardqoli.howest.pwa30.models.TestimonialResponse;
import leonardqoli.howest.pwa30.models.TicketsResponse;
import leonardqoli.howest.pwa30.models.UsersResponse;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface Api {

    @FormUrlEncoded
    @POST("createuser")
   Call<DefaultResponse> createUser(
           @Field("userName") String userName,
           @Field("email") String email,
           @Field("password") String password
    );

    @FormUrlEncoded
    @POST("/users/login")
    Call<LoginResponse> userLogin(
            @Field("email") String email,
            @Field("password") String password
    );

    @GET("users")
    Call<UsersResponse> getUsers();

    @GET("orders")
    Call<OrdersResponse> getOrders();

    @GET("events")
    Call<EventsResponse> getEvents();

    @GET("artists")
    Call<ArtistsResponse> getArtists();

    @GET("guests")
    Call<GuestsResponse> getGuests();

    @GET("tickets")
    Call<TicketsResponse> getTickets();

    @GET("invintations")
    Call<InvintationsResponse> getInvintations();

    @GET("testimonials")
    Call<TestimonialResponse> getTestimonials();

    @FormUrlEncoded
    @POST("/events/createevent")
    Call<DefaultResponse> createEvent(
            @Field("title") String title,
            @Field("date") String firstName,
            @Field("city") String lastName,
            @Field("street") String role,
            @Field("country") String country,
            @Field("postal") String postal,
            @Field("info") String info,
            @Field("about_the_party") String about_the_party
    );

    @FormUrlEncoded
    @POST("/artists/createartist")
    Call<DefaultResponse> createArtist (
            @Field("event_id") int event_id,
            @Field("firstName") String firstName,
            @Field("lastName") String lastName,
            @Field("role") String role,
            @Field("motto") String motto,
            @Field("facebook_link") String facebook_link,
            @Field("instagram_link") String instagram_link,
            @Field("twitter_link") String twitter_link
    );

    @FormUrlEncoded
    @POST("/guests/createguest")
    Call<DefaultResponse> createGuest(
            @Field("event_id") int event_id,
            @Field("firstName") String firstName,
            @Field("lastName") String lastName,
            @Field("role") String role
    );




    @FormUrlEncoded
    @POST("/tickets/createticket")
    Call<DefaultResponse> createTicket(
            @Field("event_id") int event_id,
            @Field("title") String title,
            @Field("price") int price,
            @Field("persons_allowed") int persons_allowed,
            @Field("hour_limitation") int hour_limitation
    );

     @FormUrlEncoded
     @PUT("/artists/updateartist")
     Call<DefaultResponse> updateArtist (
             @Field("artist_id") int artist_id,
             @Field("event_id") int event_id,
             @Field("firstName") String firstName,
             @Field("lastName") String lastName,
             @Field("role") String role,
             @Field("motto") String motto,
             @Field("facebook_link") String facebook_link,
             @Field("instagram_link") String instagram_link,
             @Field("twitter_link") String twitter_link
     );





    @FormUrlEncoded
    @PUT("/events/updateevent")
    Call<DefaultResponse> updateEvent(
            @Field("event_id") int event_id,
            @Field("title") String title,
            @Field("date") String firstName,
            @Field("city") String lastName,
            @Field("street") String role,
            @Field("country") String country,
            @Field("postal") String postal,
            @Field("info") String info,
            @Field("about_the_party") String about_the_party
    );

     @FormUrlEncoded
     @PUT("/guests/updateguest")
     Call<DefaultResponse> updateGuest(
             @Field("guest_id") int guest_id,
             @Field("event_id") int event_id,
             @Field("firstName") String firstName,
             @Field("lastName") String lastName,
             @Field("role") String role
     );




     @FormUrlEncoded
     @PUT("/tickets/updateticket")
     Call<DefaultResponse> updateTicket(
             @Field("ticket_id") int ticket_id,
             @Field("event_id") int event_id,
             @Field("title") String title,
             @Field("price") int price,
             @Field("persons_allowed") int persons_allowed,
             @Field("hour_limitation") int hour_limitation
     );

}
