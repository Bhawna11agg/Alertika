package com.example.alertika;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputLayout;

public class SignUpActivity extends AppCompatActivity {
    TextInputLayout name,moblie,emailid,emergencyno ,emergencyContactName;
    Button confirmbutton;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        name = findViewById(R.id.name_til);
        moblie = findViewById(R.id.mobileNumber_til);
        emailid = findViewById(R.id.emailId_til);
        emergencyno = findViewById(R.id.emergencyNumber_til);
        emergencyContactName = findViewById(R.id.emergencyContactName_til);
        confirmbutton = findViewById(R.id.confirmButton);
        sharedPreferences = getSharedPreferences("com.example.alertika" , MODE_PRIVATE);

        confirmbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("username" , name.getEditText().getText().toString().trim());
                editor.putString("mobile" , moblie.getEditText().getText().toString().trim());
                editor.putString("emailid", moblie.getEditText().getText().toString().trim());
                editor.apply();

                MainActivity.emergencyContactsDbHelper.insertContact(emergencyContactName.getEditText().getText().toString().trim() , emergencyno.getEditText().getText().toString().trim());
                finish();
            }
        });

    }
}
