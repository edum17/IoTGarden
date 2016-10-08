package com.example.german.iotgarden;


import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class LogIn extends FragmentActivity {

    private Context context;
    private EditText userID;
    private EditText passwordID;
    private Button logInButton;
    private TextView errorMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_log_in);
        context = this;

        userID = (EditText) findViewById(R.id.userID);
        passwordID = (EditText) findViewById(R.id.passwordID);
        logInButton = (Button) findViewById(R.id.logInButton);
        errorMessage = (TextView) findViewById(R.id.errorMessage);
        logInButton.setFocusable(false);
        logInButton.setEnabled(false);


        if (userID.getText().toString() != null && passwordID.getText().toString() != null) {
            logInButton.setFocusable(true);
            logInButton.setEnabled(true);
        }

        logInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("--------------------------------------------------");
                System.out.println("userID.getText().toString(): " + userID.getText().toString());
                System.out.println("userID.getText().toString(): " + userID.getText().toString());
                System.out.println("--------------------------------------------------");
                if (userID.getText().toString().equals("a") && userID.getText().toString().equals("a")) {
                    Intent logInIntent = new Intent(context, MainActivity.class);
                    startActivity(logInIntent);
                }
            }
        });
    }


}
