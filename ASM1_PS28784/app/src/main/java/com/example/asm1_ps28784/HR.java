package com.example.asm1_ps28784;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.ui.AppBarConfiguration;

public class HR extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
//    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hr);

        Button btnHR = findViewById(R.id.btnHR);
        Button btnExit = findViewById(R.id.btnExit);
        Button btnStaff = findViewById(R.id.btnStaff);
        Button btnLogOut = findViewById(R.id.btnLogOut);

        btnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HR.this, Firth_Screen.class);
                startActivity(intent);
            }
        });

        btnHR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(HR.this, PhongBan.class);
                startActivity(intent);

            }
        });
        btnStaff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(HR.this, NhanVien.class);
                startActivity(intent);

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