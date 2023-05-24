package com.example.asm1_ps28784;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HR extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hr);

        Button btnHR = findViewById(R.id.btnHR);
        Button btnExit = findViewById(R.id.btnExit);
        Button btnStaff = findViewById(R.id.btnStaff);

        btnHR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(HR.this, PhongBan.class);
                Bundle bundle = new Bundle();
                startActivity(intent, bundle);

            }
        });
        btnStaff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(HR.this, NhanVien.class);
                Bundle bundle = new Bundle();
                startActivity(intent, bundle);

            }
        });

        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishAffinity();
            }
        });
    }
}