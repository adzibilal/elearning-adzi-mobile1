package com.example.pertemuan_4_adzibilal;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView text;
    private Button button;
    private Button buttonAlert;
    private Button buttonToast;
    private Button buttonCheck;
    private EditText phoneNumberInput;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = findViewById(R.id.text);
        button = findViewById(R.id.button);
        buttonAlert = findViewById(R.id.buttonAlert);
        buttonToast = findViewById(R.id.buttonToast);
        buttonCheck = findViewById(R.id.btn_check);
        phoneNumberInput = findViewById(R.id.phone_number_input);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog();
            }
        });

        buttonAlert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openAlert();
            }
        });

        buttonToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showToast("Hello Toast Adzi Bilal M H!");
            }
        });

        buttonCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getPhoneNumber(view);
            }
        });
    }

    private void openDialog() {
        DatePickerDialog dialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                openTimePicker(i, i1, i2);
            }
        }, 2024, 3, 28);

        dialog.show();
    }

    private void openTimePicker(final int year, final int month, final int day) {
        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int hour, int minute) {
                //Showing the picked value in the textView
                text.setText(String.valueOf(year)+ "-"+String.valueOf(month+1)+ "-"+String.valueOf(day) +"  "+String.valueOf(hour)+ ":"+String.valueOf(minute));
            }
        }, 15, 30, false);

        timePickerDialog.show();
    }

    private void openAlert(){
        new AlertDialog.Builder(MainActivity.this)
                .setTitle("Alert Test")
                .setMessage("Adzi Bilal M H")
                .setCancelable(true).show();
    }

    private void showToast(String message) {
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT; // Or Toast.LENGTH_LONG for a longer duration

        Toast toast = Toast.makeText(context, message, duration);
        toast.show();
    }

    public void getPhoneNumber(View view) {
        String phoneNumber = phoneNumberInput.getText().toString().trim();

        // Perform validation or further processing with the phone number here
        if (isValidPhoneNumber(phoneNumber)) {
            // Phone number is valid, do something with it
            Toast.makeText(this, "Valid Phone Number: " + phoneNumber, Toast.LENGTH_SHORT).show();
        } else {
            // Phone number is invalid, show an error message
            Toast.makeText(this, "Invalid Phone Number. Please enter a valid number.", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean isValidPhoneNumber(String phoneNumber) {
        // You can use a regular expression or a library for phone number validation
        // This is a simplified example, adjust based on your specific needs
        return phoneNumber.matches("^[\\+]?[0-9]{10,13}$");
    }
}