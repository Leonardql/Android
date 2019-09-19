package leonardqoli.howest.events;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private TextView textViewResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewResult = findViewById(R.id.text_view_result);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.56.1:3000/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

        Call<List<Guest>> call = jsonPlaceHolderApi.getGuests();

        call.enqueue(new Callback<List<Guest>>() {
            @Override
            public void onResponse(Call<List<Guest>> call, Response<List<Guest>> response) {
                if (!response.isSuccessful())
                {
                    textViewResult.setText("Code: " + response.code() );
                    return;
                }
                List<Guest> guests = response.body();

                for (Guest guest : guests)
                {
                    String content = "";
                    content += "ID: " + guest.getGuestId() + "\n";
                    content += "FirstName: " + guest.getFirstName() + "\n";
                    content += "LastName: " + guest.getLastName() + "\n";
                    content += "Role: " + guest.getRole() + "\n";
                    content += "Avatar: " + guest.getAvatar() + "\n\n";

                    textViewResult.append(content);
                }

            }

            @Override
            public void onFailure(Call<List<Guest>> call, Throwable t) {
                textViewResult.setText(t.getMessage());
            }
        });
    }
}
