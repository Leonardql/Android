package leonardqoli.howest.pwa30.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import leonardqoli.howest.pwa30.Storage.SharedPrefManager;
import leonardqoli.howest.pwa30.fragments.HomeFragment;
import leonardqoli.howest.pwa30.models.DefaultResponse;
import leonardqoli.howest.pwa30.R;
import leonardqoli.howest.pwa30.api.RetrofitClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText editTextEmail, editTextUserName, editTextPassword;





    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        editTextUserName = findViewById(R.id.editTextUserName);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);

        findViewById(R.id.btnSignUp).setOnClickListener(this);
        findViewById(R.id.btnLogin).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnSignUp:
                userSignUp();
                break;

            case R.id.btnLogin:
                startActivity(new Intent(this, LoginActivity.class));
                break;
        }
    }

//    @Override
//    protected void onStart() {
//        super.onStart();
//
//        if (SharedPrefManager.getInstance(this).isLoggedIn()){
//            Intent intent = new Intent(this, MainActivity.class);
//            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
//            startActivity(intent);
//        }
//    }

    private void userSignUp() {
        String userName = editTextUserName.getText().toString().trim();
        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

        if (userName.isEmpty()){
            editTextUserName.setError("Username  required");
            editTextUserName.requestFocus();
            return;
        }

        if (userName.length() < 5){
            editTextUserName.setError("Username  has to have atleast 5 characters");
            editTextUserName.requestFocus();
            return;
        }

        if (email.isEmpty()){
            editTextEmail.setError("Mail is required");
            editTextEmail.requestFocus();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            editTextEmail.setError("Enter a valid email");
            editTextEmail.requestFocus();
            return;
        }

        if (password.isEmpty()){
            editTextPassword.setError("Password required");
            editTextPassword.requestFocus();
            return;
        }

        if (password.length() < 5){
            editTextPassword.setError("Password has to have atleast 5 characters");
            editTextPassword.requestFocus();
            return;
        }

        Call<DefaultResponse> call = RetrofitClient
                .getInstance()
                .getApi()
                .createUser(userName, email, password);

        call.enqueue(new Callback<DefaultResponse>() {
            @Override
            public void onResponse(Call<DefaultResponse> call, Response<DefaultResponse> response) {
                if (response.code() == 201){
                    DefaultResponse dr = response.body();
                    Toast.makeText(RegisterActivity.this, dr.getMsg(), Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(RegisterActivity.this, "User already exists", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<DefaultResponse> call, Throwable t) {

            }
        });
//        call.enqueue(new Callback<ResponseBody>() {
//            @Override
//            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
//
//                String r = null;
//
//                try {
//                    if (response.code() == 201) {
//                        r = response.body().string();
//
//                    } else {
//                        r = response.errorBody().string();
//
//                    }
//                }catch (IOException e){
//                        e.printStackTrace();
//                }
//
//                if (r != null){
//                    try {
//
//                        JSONObject jsonObject = new JSONObject(r);
//
//                        String errorMessage = jsonObject.getString("message");
//                        Toast.makeText(RegisterActivity.this, errorMessage, Toast.LENGTH_LONG).show();
//                    } catch (JSONException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//
//            @Override
//            public void onFailure(Call<ResponseBody> call, Throwable t) {
//                Toast.makeText(RegisterActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
//            }
//        });

    }
}
