package leonardqoli.howest.pwa30.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import leonardqoli.howest.pwa30.R;
import leonardqoli.howest.pwa30.api.RetrofitClient;
import leonardqoli.howest.pwa30.models.DefaultResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UpdateArtistsActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editTextArtist_id, editTextEvent_id, editTextFirstName, editTextLastName, editTextRole, editTextMotto , editTextfacebook_link, editTextInstagram_link, editTextTwitter_link;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updateartist);

        editTextArtist_id = findViewById(R.id.editTextArtist_id);
        editTextEvent_id = findViewById(R.id.editTextEvent_id);
        editTextFirstName = findViewById(R.id.editTextFirstName);
        editTextLastName = findViewById(R.id.editTextLastName);
        editTextRole = findViewById(R.id.editTextRole);
        editTextMotto = findViewById(R.id.editTextMotto);
        editTextfacebook_link = findViewById(R.id.editTextfacebook_link);
        editTextInstagram_link = findViewById(R.id.editTextInstagram_link);
        editTextTwitter_link = findViewById(R.id.editTextTwitter_link);

        findViewById(R.id.btnUpdateArtist).setOnClickListener(this);
        findViewById(R.id.btnBackUpdateArtist).setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnUpdateArtist:
                updateArtist();
                break;

            case R.id.btnBackUpdateArtist:
                startActivity(new Intent(this, MainActivity.class));
                break;
        }
    }

    private void updateArtist(){

        int artist_id = Integer.parseInt(editTextArtist_id.getText().toString().trim());
        int event_id = Integer.parseInt(editTextEvent_id.getText().toString().trim());
        String firstName = editTextFirstName.getText().toString().trim();
        String lastName = editTextLastName.getText().toString().trim();
        String role = editTextRole.getText().toString().trim();
        String motto = editTextMotto.getText().toString().trim();
        String facebook_link = editTextfacebook_link.getText().toString().trim();
        String instagram_link = editTextInstagram_link.getText().toString().trim();
        String twitter_link = editTextTwitter_link.getText().toString().trim();

        if (editTextEvent_id.getText().toString().trim().isEmpty()){
            editTextEvent_id.setError("event id is required to update an artist.");
            editTextEvent_id.requestFocus();
            return;
        }

        if (firstName.isEmpty()){
            editTextFirstName.setError("FirstName is required");
            editTextFirstName.requestFocus();
            return;
        }

        if (lastName.isEmpty()){
            editTextLastName.setError("LastName is required");
            editTextLastName.requestFocus();
            return;
        }

        if (role.isEmpty()){
            editTextRole.setError("Role is required");
            editTextRole.requestFocus();
            return;
        }

        if (motto.isEmpty()){
            editTextMotto.setError("Motto is required");
            editTextMotto.requestFocus();
            return;
        }





        Call<DefaultResponse> call = RetrofitClient
                .getInstance()
                .getApi()
                .updateArtist(artist_id, event_id, firstName, lastName, role, motto, facebook_link, instagram_link, twitter_link);

        call.enqueue(new Callback<DefaultResponse>() {
            @Override
            public void onResponse(Call<DefaultResponse> call, Response<DefaultResponse> response) {
                if (response.code() == 200){
                    DefaultResponse dr = response.body();
                    Toast.makeText(UpdateArtistsActivity.this, dr.getMsg(), Toast.LENGTH_LONG).show();
                    startActivity(new Intent(UpdateArtistsActivity.this, MainActivity.class));

                }else{
                    Toast.makeText(UpdateArtistsActivity.this, "Artist already exists", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<DefaultResponse> call, Throwable t) {
                    //do something
            }
        });

    }
}
