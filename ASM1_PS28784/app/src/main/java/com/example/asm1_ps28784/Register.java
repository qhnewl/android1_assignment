package com.example.asm1_ps28784;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import org.jetbrains.annotations.NotNull;

public class Register extends AppCompatActivity {

    private TextInputEditText tieUsername2, tiePass2;
    private Button btnRegister2, btnBack;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mAuth = FirebaseAuth.getInstance();

        tieUsername2 = findViewById(R.id.tieUsername2);
        tiePass2 = findViewById(R.id.tiePass2);
        btnRegister2 = findViewById(R.id.btnRegister2);
        btnBack = findViewById(R.id.btnBack);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Register.this, Firth_Screen.class);
                startActivity(intent);
                finish();
            }
        });

        btnRegister2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Register2();
            }
        });
    }

    private void Register2() {

        String email, pass;
        email = tieUsername2.getText().toString();
        pass = tiePass2.getText().toString();

        if (TextUtils.isEmpty(email)) {
            Toast.makeText(this, "Vui lòng nhập lại email!!!", Toast.LENGTH_SHORT).show();
        }
        if (TextUtils.isEmpty(pass)) {
            Toast.makeText(this, "Vui lòng nhập lại password!!!", Toast.LENGTH_SHORT).show();
        }
        mAuth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull @NotNull Task<AuthResult> task) {
                if(task.isSuccessful()) {
                    Toast.makeText(getApplicationContext(),"Tạo tài khoản thành công", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Register.this, Login.class);
                    startActivity(intent);
                }else {
                    Toast.makeText(getApplicationContext(),"Tạo tài khoản không thành công!!!!", Toast.LENGTH_SHORT).show();

                }

            }
        });
    }
}

