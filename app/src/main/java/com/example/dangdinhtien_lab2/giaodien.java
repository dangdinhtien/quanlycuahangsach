package com.example.dangdinhtien_lab2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class giaodien extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.giaodien);

    }
    public void bai1(View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    public void bai2(View v){
        Intent intent = new Intent(this, MainActivitBbai2.class);
        startActivity(intent);
    }
    public void bai3(View v){
        Intent intent = new Intent(this, MainActivityBai3.class);
        startActivity(intent);
    }
    public void bai4(View v){
        Intent intent = new Intent(this, MainActivityBai4.class);
        startActivity(intent);
    }
}
