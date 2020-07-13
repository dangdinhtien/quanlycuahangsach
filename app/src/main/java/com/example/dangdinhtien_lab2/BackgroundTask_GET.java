package com.example.dangdinhtien_lab2;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.Console;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class BackgroundTask_GET extends AsyncTask<Void, Void, Void> {
    String duongdan = "http://10.82.145.139/dangdinhtien_ps10163/student_GET.php";
    TextView tvResult;
    String strName, strScore;
    String str;
    ProgressDialog dialog;
    Context context;
    public BackgroundTask_GET(Context context, TextView tvResult, String strName, String strScore){
        this.context = context;
        this.tvResult = tvResult;
        this.strName = strName;
        this.strScore = strScore;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        dialog = new ProgressDialog(context);
        dialog.setMessage("Sending...");
        dialog.setIndeterminate(false);
        dialog.show();
    }

    @Override
    protected Void doInBackground(Void... voids) {
        duongdan += "?name=" + this.strName + "&score=" + this.strScore;
        try {
            URL url = new URL(duongdan);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            BufferedReader bfr = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String line = "";
            StringBuffer sb = new StringBuffer();
            while ((line = bfr.readLine()) != null){
                sb.append(line);
            }
            str = sb.toString();
            Log.d("dulieu",str);
            urlConnection.disconnect();
        }catch (Exception e){
            e.printStackTrace();
            Log.d("dulieu1",e.toString());
        }

        return null;
    }

    @Override
    protected void onPostExecute(Void result) {
        super.onPostExecute(result);
        if(dialog.isShowing()){
            dialog.dismiss();
        }
        tvResult.setText(str);

    }


}
