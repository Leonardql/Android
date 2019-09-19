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

public class AddTicketsActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText editTextEvent_id, editTextTitle, editTextPrice, editTextPersonsAllowed, editTextHourLimitation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addtickets);

        editTextEvent_id = findViewById(R.id.editTextEvent_id);
        editTextTitle = findViewById(R.id.editTextTitle);
        editTextPrice = findViewById(R.id.editTextPrice);
        editTextPersonsAllowed = findViewById(R.id.editTextPersonsAllowed);
        editTextHourLimitation = findViewById(R.id.editTextHourLimitation);

        findViewById(R.id.btnCreateTicket).setOnClickListener(this);
        findViewById(R.id.btnBackTicket).setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnCreateTicket:
                createTicket();
                break;

            case R.id.btnBackTicket:
                startActivity(new Intent(this, MainActivity.class));
                break;
        }
    }

    private void createTicket() {

        int event_id = Integer.parseInt(editTextEvent_id.getText().toString().trim());
        String title = editTextTitle.getText().toString().trim();
        int price = Integer.parseInt(editTextPrice.getText().toString().trim());
        int persons_allowed = Integer.parseInt(editTextPersonsAllowed.getText().toString().trim());
        int hour_limitation = Integer.parseInt(editTextHourLimitation.getText().toString().trim());

        if (editTextEvent_id.getText().toString().trim().isEmpty()){
            editTextEvent_id.setError("event id is required to create a Ticket.");
            editTextEvent_id.requestFocus();
            return;
        }

        if (title.isEmpty()){
            editTextTitle.setError("FirstName is required");
            editTextTitle.requestFocus();
            return;
        }

        if (editTextPrice.getText().toString().trim().isEmpty()){
            editTextPrice.setError("Price is required");
            editTextPrice.requestFocus();
            return;
        }

        if (editTextPersonsAllowed.getText().toString().trim().isEmpty()){
            editTextPersonsAllowed.setError("Persons allowed is required");
            editTextPersonsAllowed.requestFocus();
            return;
        }

        if (editTextHourLimitation.getText().toString().trim().isEmpty()){
            editTextHourLimitation.setError("Hour limitation is required");
            editTextHourLimitation.requestFocus();
            return;
        }

        Call<DefaultResponse> call = RetrofitClient
                .getInstance()
                .getApi()
                .createTicket(event_id, title, price, persons_allowed, hour_limitation);

        call.enqueue(new Callback<DefaultResponse>() {
            @Override
            public void onResponse(Call<DefaultResponse> call, Response<DefaultResponse> response) {
                if (response.code() == 200){
                    DefaultResponse dr = response.body();
                    Toast.makeText(AddTicketsActivity.this, dr.getMsg(), Toast.LENGTH_LONG).show();
                    startActivity(new Intent(AddTicketsActivity.this, MainActivity.class));
                }else{
                    Toast.makeText(AddTicketsActivity.this, "Ticket with the same values already exists", Toast.LENGTH_LONG).show();

                }
            }

            @Override
            public void onFailure(Call<DefaultResponse> call, Throwable t) {
                //do something
            }
        });
    }
}
