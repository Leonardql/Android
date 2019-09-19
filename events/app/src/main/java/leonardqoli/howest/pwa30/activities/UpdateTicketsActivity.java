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

public class UpdateTicketsActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText editTextTicket_id, editTextEvent_id, editTextTitle, editTextPrice, editTextPersonsAllowed, editTextHourLimitation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updatetickets);

        editTextTicket_id = findViewById(R.id.editTextTicket_id);
        editTextEvent_id = findViewById(R.id.editTextEvent_id);
        editTextTitle = findViewById(R.id.editTextTitle);
        editTextPrice = findViewById(R.id.editTextPrice);
        editTextPersonsAllowed = findViewById(R.id.editTextPersonsAllowed);
        editTextHourLimitation = findViewById(R.id.editTextHourLimitation);

        findViewById(R.id.btnUpdateTicket).setOnClickListener(this);
        findViewById(R.id.btnBackUpdateTicket).setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnUpdateTicket:
                updateTicket();
                break;

            case R.id.btnBackUpdateTicket:
                startActivity(new Intent(this, MainActivity.class));
                break;
        }
    }

    private void updateTicket() {

        int ticket_id = Integer.parseInt(editTextTicket_id.getText().toString().trim());
        int event_id = Integer.parseInt(editTextEvent_id.getText().toString().trim());
        String title = editTextTitle.getText().toString().trim();
        int price = Integer.parseInt(editTextPrice.getText().toString().trim());
        int persons_allowed = Integer.parseInt(editTextPersonsAllowed.getText().toString().trim());
        int hour_limitation = Integer.parseInt(editTextHourLimitation.getText().toString().trim());

        if (title.isEmpty()){
            editTextTitle.setError("Title is required");
            editTextTitle.requestFocus();
            return;
        }

        Call<DefaultResponse> call = RetrofitClient
                .getInstance()
                .getApi()
                .updateTicket(ticket_id, event_id, title, price, persons_allowed, hour_limitation);

        call.enqueue(new Callback<DefaultResponse>() {
            @Override
            public void onResponse(Call<DefaultResponse> call, Response<DefaultResponse> response) {
                if (response.code() == 200){
                    DefaultResponse dr = response.body();
                    Toast.makeText(UpdateTicketsActivity.this, dr.getMsg(), Toast.LENGTH_LONG).show();
                    startActivity(new Intent(UpdateTicketsActivity.this, MainActivity.class));
                }else{
                    Toast.makeText(UpdateTicketsActivity.this, "Ticket with the same values already exists", Toast.LENGTH_LONG).show();

                }
            }

            @Override
            public void onFailure(Call<DefaultResponse> call, Throwable t) {
                    //do something
            }
        });
    }
}
