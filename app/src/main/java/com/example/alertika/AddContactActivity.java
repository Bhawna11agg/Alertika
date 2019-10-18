package com.example.alertika;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.alertika.data.EmergencyContactsDbHelper;
import com.google.android.material.textfield.TextInputLayout;

public class AddContactActivity extends AppCompatActivity {

    TextInputLayout contactname , contactnumber;
    //EmergencyContactsDbHelper emergencyContactsDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);
        setTitle("Add Emergency Contact");
        contactname = findViewById(R.id.contact_name_til);
        contactnumber = findViewById(R.id.contact_Number_til);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.savebutton_menu , menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.save_button){
            //save it to database and exit the activity
            //checks should be applied here on data entered by the user
            boolean response = MainActivity.emergencyContactsDbHelper.insertContact(contactname.getEditText().getText().toString().trim()
                               , contactnumber.getEditText().getText().toString().trim());
            if(response == true)
                Toast.makeText(this , "added successfully" , Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(this,"unsuccessful" , Toast.LENGTH_SHORT).show();
            finish();
            return true;
        }
        return false;
    }

}
