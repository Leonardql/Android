package leonardqoli.howest.pwa30.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import leonardqoli.howest.pwa30.R;

public class BeginScreenActivity extends AppCompatActivity {

    private ImageView logo;
    private static int splashTimeOut=5000;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beginscreen);
        logo=(ImageView)findViewById(R.id.logo);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(BeginScreenActivity.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        },splashTimeOut);

        Animation myAnim = AnimationUtils.loadAnimation(this,R.anim.splashanimation);
        logo.startAnimation(myAnim);
    }
}
