package com.example.dangdinhtien_lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnSend;
    EditText edtName, edtScore;
    TextView tvResult;

    String strName, strScore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtName = findViewById(R.id.edtName);
        edtScore = findViewById(R.id.edtScore);
        btnSend = findViewById(R.id.btnSend);
        tvResult = findViewById(R.id.tvResult);

        btnSend.setOnClickListener(this);
    }
    public static final String SERVER_NAME = "http://10.82.145.139/dangdinhtien_ps10163/student_GET.php";

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnSend:
                strName = edtName.getText().toString();
                strScore = edtScore.getText().toString();
                BackgroundTask_GET backgroundTask_get = new BackgroundTask_GET(this, tvResult, strName, strScore);
                backgroundTask_get.execute();
                break;
        }
    }
}