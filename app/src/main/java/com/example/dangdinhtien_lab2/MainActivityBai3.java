package com.example.dangdinhtien_lab2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivityBai3 extends AppCompatActivity implements View.OnClickListener {
    Button btnSend;
    EditText edtcanh;
    TextView tvketqua;
    String str;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_bai3);
        edtcanh = findViewById(R.id.edtcanh);
        btnSend = findViewById(R.id.btnSend);
        tvketqua = findViewById(R.id.tvResult);

        btnSend.setOnClickListener(this);
    }

    public static final String SERVER_NAME = "http://10.82.145.139/dangdinhtien_ps10163/canh_POST.php";

    @Override
    public void onClick(View view) {
        str = edtcanh.getText().toString();
        BackgroundTask_POST_bai3 bai3 = new BackgroundTask_POST_bai3(this,tvketqua);
        bai3.execute(str);
        }
    }