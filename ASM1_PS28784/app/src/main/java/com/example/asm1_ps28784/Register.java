package com.example.asm1_ps28784;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class Register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        TextInputEditText tieUsername2 = findViewById(R.id.tieUsername2);
        TextInputEditText tiePass2 = findViewById(R.id.tiePass2);
        TextInputEditText tieConfirmPass = findViewById(R.id.tieConfirmPass);
        Button btnRegister = findViewById(R.id.btnRegister);

        Button btnBack = findViewById(R.id.btnBack);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = tieUsername2.getText().toString();
                String password = tiePass2.getText().toString();
                String confPass = tieConfirmPass.getText().toString();
                boolean p = password.equals(confPass);
                if (p) {
                    Toast.makeText(Register.this, "Dang ky thanh cong", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(Register.this, MainActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("username", user);
                    bundle.putString("password", password);
                    i.putExtras(bundle);
                    startActivity(i);
                }
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Register.this, MainActivity.class);

                Bundle bundle = new Bundle();
                startActivity(intent, bundle);
            }
        });


    }
}