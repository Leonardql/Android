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

public class UpdateDescriptionActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editTextEvent_id, editTextEventTitle, editTextDate, editTextCity,editTextStreet, editTextCountry, editTextPostal , editTextInfo, editTextAbout_the_party;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updatedescription);

        editTextEvent_id = findViewById(R.id.editTextEvent_id);
        editTextEventTitle = findViewById(R.id.editTextEventTitle);
        editTextDate = findViewById(R.id.editTextDate);
        editTextCity = findViewById(R.id.editTextCity);
        editTextStreet = findViewById(R.id.editTextStreet);
        editTextCountry = findViewById(R.id.editTextCountry);
        editTextPostal = findViewById(R.id.editTextPostal);
        editTextInfo = findViewById(R.id.editTextInfo);
        editTextAbout_the_party = findViewById(R.id.editTextAbout_the_party);

        findViewById(R.id.btnUpdateDescription).setOnClickListener(this);
        findViewById(R.id.btnBackUpdateDescription).setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnUpdateDescription:
                updateEvent();
                break;

            case R.id.btnBackUpdateDescription:
                startActivity(new Intent(this, MainActivity.class));
                break;
        }
    }

    private void updateEvent(){

        int event_id = Integer.parseInt(editTextEvent_id.getText().toString().trim());
        String title = editTextEventTitle.getText().toString().trim();
        String date = editTextDate.getText().toString().trim();
        String city = editTextCity.getText().toString().trim();
        String street = editTextStreet.getText().toString().trim();
        String country = editTextCountry.getText().toString().trim();
        String postal = editTextPostal.getText().toString().trim();
        String info = editTextInfo.getText().toString().trim();
        String about_the_party = editTextAbout_the_party.getText().toString().trim();

        if (title.isEmpty()){
            editTextEventTitle.setError("Title is required");
            editTextEventTitle.requestFocus();
            return;
        }

        if (date.isEmpty()){
            editTextDate.setError("Date is required");
            editTextDate.requestFocus();
            return;
        }

        if (city.isEmpty()){
            editTextCity.setError("City is required");
            editTextCity.requestFocus();
            return;
        }

        if (street.isEmpty()){
            editTextStreet.setError("Street is required");
            editTextStreet.requestFocus();
            return;
        }
        if (country.isEmpty()){
            editTextCountry.setError("Country is required");
            editTextCountry.requestFocus();
            return;
        }

        if (postal.isEmpty()){
            editTextPostal.setError("postal is required");
            editTextPostal.requestFocus();
            return;
        }

        if (info.isEmpty()){
            editTextInfo.setError("Info is required");
            editTextInfo.requestFocus();
            return;
        }

        if (about_the_party.isEmpty()){
            editTextAbout_the_party.setError("About is required");
            editTextAbout_the_party.requestFocus();
            return;
        }

        Call<DefaultResponse> call = RetrofitClient
                .getInstance()
                .getApi()
                .updateEvent(event_id, title, date, city, street, country, postal, info, about_the_party);

        call.enqueue(new Callback<DefaultResponse>() {
            @Override
            public void onResponse(Call<DefaultResponse> call, Response<DefaultResponse> response) {
                if (response.code() == 200){
                    DefaultResponse dr = response.body();
                    Toast.makeText(UpdateDescriptionActivity.this, dr.getMsg(), Toast.LENGTH_LONG).show();
                    startActivity(new Intent(UpdateDescriptionActivity.this, MainActivity.class));
                }else{
                    Toast.makeText(UpdateDescriptionActivity.this, "Event already exists" + response, Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<DefaultResponse> call, Throwable t) {
                //do something
            }
        });

    }
}
