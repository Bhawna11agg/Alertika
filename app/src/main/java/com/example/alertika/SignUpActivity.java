package com.example.alertika;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputLayout;

public class SignUpActivity extends AppCompatActivity {
    TextInputLayout name,moblie,emailid,emergencyno;
    Button confirmbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        name = findViewById(R.id.name_til);
        moblie = findViewById(R.id.mobileNumber_til);
        emailid = findViewById(R.id.emailId_til);
        emergencyno = findViewById(R.id.emergencyNumber_til);
        confirmbutton = findViewById(R.id.confirmButton);

        confirmbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
