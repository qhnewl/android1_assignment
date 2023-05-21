package com.example.asm1_ps28784;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextInputEditText tieUsername = findViewById(R.id.tieUsername);
        TextInputEditText tiePass = findViewById(R.id.tiePass);
        Button btnLogin = findViewById(R.id.btnLogin);
        Button btnRegister = findViewById(R.id.btnRegister);


        tieUsername.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() == 0 ) {
                    tieUsername.setError("Bạn chưa nhập Username nè @@");
                } else {
                    tieUsername.setError(null);
                }
            }
            @Override
            public void afterTextChanged(Editable s) {}
        });
        tiePass.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() == 0 ) {
                    tiePass.setError("Bạn chưa nhập Password nè @@");
                } else {
                    tiePass.setError(null);
                }
            }
            @Override
            public void afterTextChanged(Editable s) {}
        });

        Intent i = getIntent();
        Bundle bundle = i.getExtras();
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (bundle != null) {
                    String user = bundle.getString("username");
                    String password = bundle.getString("password");
                    boolean u = user.equals(tieUsername.getText().toString());
                    boolean p = password.equals(tiePass.getText().toString());
                    if (u && p) {
                        Toast.makeText(MainActivity.this, "Däng nhâp thânh công!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainActivity.this, HR.class);

                        Bundle bundle = new Bundle();
                        startActivity(intent, bundle);
                    } else {
                        Toast.makeText(MainActivity.this, "Sai tài khoan hoäc mât khâu!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });


        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, Register.class);

                Bundle bundle = new Bundle();
                startActivity(intent, bundle);

            }
        });
    }
}