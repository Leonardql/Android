package leonardqoli.howest.pwa30.Storage;

import android.content.Context;
import android.content.SharedPreferences;

import leonardqoli.howest.pwa30.models.User;

public class SharedPrefManager  {
    //local Storage
    private static final  String SHARED_PREF_NAME = "my_shared_preff";

    private static SharedPrefManager mySharedInstace;
    private Context myCtx;

    public SharedPrefManager(Context myCtx) {
        this.myCtx = myCtx;
    }

    public static synchronized SharedPrefManager getInstance(Context myCtx){
        if (mySharedInstace == null){
            mySharedInstace = new SharedPrefManager(myCtx);
        }
        return mySharedInstace;
    }

    public void saveUser(User user){
        SharedPreferences sharedPreferences = myCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putInt("id", user.getId());
        editor.putString("userName", user.getUserName());
        editor.putString("email", user.getEmail());
        editor.putString("created_at", user.getCreated_at());

        editor.apply();
    }

    public boolean isLoggedIn(){
        SharedPreferences sharedPreferences = myCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getInt("id", -1 ) != 1;
    }

    public User getUser(){
        SharedPreferences sharedPreferences = myCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return new User(
                sharedPreferences.getInt("id", -1),
                sharedPreferences.getString("userName", null),
                sharedPreferences.getString("email", null),
                sharedPreferences.getString("created_at", null)
        );
    }

    public void clearStorage(){
        SharedPreferences sharedPreferences = myCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
    }
}
