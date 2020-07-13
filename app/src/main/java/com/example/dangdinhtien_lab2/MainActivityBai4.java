package com.example.dangdinhtien_lab2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivityBai4 extends AppCompatActivity implements View.OnClickListener {
    EditText edtA, edtB, edtC;
    Button btnSend;
    TextView tvKetqua;
    String strA, strB, strC;

    public static final String SERVER_NAME = "http://10.82.145.139/dangdinhtien_ps10163/giaiphuongtrinh.php";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_bai4);

        edtA = findViewById(R.id.edtA);
        edtB = findViewById(R.id.edtB);
        edtC = findViewById(R.id.edtC);
        btnSend = findViewById(R.id.btnSend);
        tvKetqua = findViewById(R.id.tvResult);

        btnSend.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnSend:
                strA = edtA.getText().toString();
                strB = edtB.getText().toString();
                strC = edtC.getText().toString();
                BackgroundTask_bai4 backgroundTask_bai4 = new BackgroundTask_bai4(this, tvKetqua);
                backgroundTask_bai4.execute(strA, strB, strC);
                break;
        }
    }
}
