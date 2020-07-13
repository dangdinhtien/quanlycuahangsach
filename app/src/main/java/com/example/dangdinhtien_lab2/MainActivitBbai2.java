package com.example.dangdinhtien_lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivitBbai2 extends AppCompatActivity implements View.OnClickListener {
    public static final String SERVER_NAME = "http://192.168.43.214/dangdinhtien_ps10163/rectangle_POST.php";
    Button btnSend;
    EditText edtWidth, edtLength;
    TextView tvResult;

    String strWidth, strLength;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activit_bbai2);
        edtWidth = findViewById(R.id.edtWidth);
        edtLength = findViewById(R.id.edtLength);
        btnSend = findViewById(R.id.btnSend);
        tvResult = findViewById(R.id.tvResult);

        btnSend.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnSend:
                strWidth = edtWidth.getText().toString();
                strLength = edtLength.getText().toString();
                BackgroundTask_GET backgroundTask_get = new BackgroundTask_GET(this, tvResult, strWidth, strLength);
                backgroundTask_get.execute();
                break;
        }
    }
}