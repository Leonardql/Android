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

public class AddSpecialGuestActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editTextEvent_id, editTextFirstName, editTextLastName, editTextRole;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_special_guest);
        editTextEvent_id = findViewById(R.id.editTextEvent_id);
        editTextFirstName = findViewById(R.id.editTextFirstName);
        editTextLastName = findViewById(R.id.editTextLastName);
        editTextRole = findViewById(R.id.editTextRole);

        findViewById(R.id.btnCreate).setOnClickListener(this);
        findViewById(R.id.btnBack).setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnCreate:
                createSpecialGuest();

                break;

            case R.id.btnBack:
                startActivity(new Intent(this, MainActivity.class));
                break;
        }
    }

    private void createSpecialGuest(){

            int event_id = Integer.parseInt(editTextEvent_id.getText().toString().trim());
            String firstName = editTextFirstName.getText().toString().trim();
            String lastName = editTextLastName.getText().toString().trim();
            String role = editTextRole.getText().toString().trim();

            if (editTextEvent_id.getText().toString().trim().isEmpty()){
                editTextEvent_id.setError("event id is required to create a guest.");
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



            Call<DefaultResponse> call = RetrofitClient
                    .getInstance()
                    .getApi()
                    .createGuest(event_id, firstName, lastName, role);

            call.enqueue(new Callback<DefaultResponse>() {
                @Override
                public void onResponse(Call<DefaultResponse> call, Response<DefaultResponse> response) {
                    if (response.code() == 200){
                        DefaultResponse dr = response.body();
                        Toast.makeText(AddSpecialGuestActivity.this, dr.getMsg(), Toast.LENGTH_LONG).show();
                        startActivity(new Intent(AddSpecialGuestActivity.this, MainActivity.class));

                    }else{
                        Toast.makeText(AddSpecialGuestActivity.this, "Special Guest already exists", Toast.LENGTH_LONG).show();
                    }


                }

                @Override
                public void onFailure(Call<DefaultResponse> call, Throwable t) {
                    //do something
                }
            });

    }
}
