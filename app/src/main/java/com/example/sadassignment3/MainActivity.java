package com.example.sadassignment3;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText etName, etEmail, etPhone;
    private Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.et_name);
        etEmail = findViewById(R.id.et_email);
        etPhone = findViewById(R.id.et_phone);
        btnSubmit = findViewById(R.id.btn_submit);

        btnSubmit.setOnClickListener(view -> {
            if (validateForm()) {
                Toast.makeText(MainActivity.this, "Form Submitted Successfully", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private boolean validateForm() {
        String name = etName.getText().toString().trim();
        String email = etEmail.getText().toString().trim();
        String phone = etPhone.getText().toString().trim();

        if (TextUtils.isEmpty(name)) {
            etName.setError("Name is required");
            etName.requestFocus();
            return false;
        }

        if (!name.matches("[a-zA-Z\\s]+")) {
            etName.setError("Enter a valid name");
            etName.requestFocus();
            return false;
        }

        if (TextUtils.isEmpty(email)) {
            etEmail.setError("Email is required");
            etEmail.requestFocus();
            return false;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            etEmail.setError("Enter a valid email address");
            etEmail.requestFocus();
            return false;
        }

        if (TextUtils.isEmpty(phone)) {
            etPhone.setError("Phone number is required");
            etPhone.requestFocus();
            return false;
        }

        if (!phone.matches("^[+]?[0-9]{10,13}$")) {  // Phone validation regex
            etPhone.setError("Enter a valid phone number");
            etPhone.requestFocus();
            return false;
        }

        return true;
    }
}
