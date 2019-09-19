package leonardqoli.howest.pwa30.activities;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import leonardqoli.howest.pwa30.Storage.SharedPrefManager;
import leonardqoli.howest.pwa30.fragments.CreateEventFragment;
import leonardqoli.howest.pwa30.fragments.DetailsFragment;
import leonardqoli.howest.pwa30.fragments.HomeFragment;
import leonardqoli.howest.pwa30.R;
import leonardqoli.howest.pwa30.fragments.ShowEventsFragment;
import leonardqoli.howest.pwa30.fragments.UsersFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();
    }

    @Override
    protected void onStart() {
        super.onStart();

        if (!SharedPrefManager.getInstance(this).isLoggedIn()){
            Intent intent = new Intent(this, LoginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    Fragment selectedFragment = null;

                    switch (menuItem.getItemId()){

                        case R.id.nav_show_events:
                            selectedFragment = new ShowEventsFragment();
                            break;

                        case R.id.nav_show_orders:
                            selectedFragment = new DetailsFragment();
                            break;
                        case R.id.nav_create_event:
                            selectedFragment = new CreateEventFragment();
                            break;
                        case R.id.nav_show_users:
                            selectedFragment = new UsersFragment();
                            break;
                    }

                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();

                    return true;
                }
            };
}
