package com.example.german.iotgarden;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.content.Intent;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by German on 08/10/2016.
 */
public class SplashScreenActivity extends Activity {
    private static final long SPLASH_SCREEN_DELAY = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set portrait orientation
        //setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        // Hide title bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.splash_screen);

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
