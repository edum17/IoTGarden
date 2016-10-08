package com.example.german.iotgarden;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.content.Intent;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by German on 08/10/2016.
 */
public class SplashScreenActivity extends FragmentActivity {
    private static final long SPLASH_SCREEN_DELAY = 6000;
    private ImageView image;
    private TextView tittleApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        // Set portrait orientation
        //setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        // Hide title bar


        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.splash_screen);

        image = (ImageView) findViewById(R.id.inicialImage);
        Animation animationImage = AnimationUtils.loadAnimation(SplashScreenActivity.this, R.anim.move_from_rigth_to_left);
        image.startAnimation(animationImage);


        tittleApp = (TextView) findViewById(R.id.appName);
        tittleApp.setText("IoTGarden");
        Typeface face = Typeface.createFromAsset(getAssets(), "Fonts/MixBrush.ttf");
        tittleApp.setTypeface(face);
        Animation animationTittle = AnimationUtils.loadAnimation(SplashScreenActivity.this, R.anim.move_from_left_to_rigth);
        tittleApp.startAnimation(animationTittle);

        TimerTask task = new TimerTask() {
            @Override
            public void run() {

                // Start the next activity
                Intent logInIntent = new Intent(SplashScreenActivity.this, LogIn.class);
                startActivity(logInIntent);

                // Close the activity so the user won't able to go back this
                // activity pressing Back button
                finish();
            }
        };

        // Simulate a long loading process on application startup.
        Timer timer = new Timer();
        timer.schedule(task, SPLASH_SCREEN_DELAY);
    }
}
