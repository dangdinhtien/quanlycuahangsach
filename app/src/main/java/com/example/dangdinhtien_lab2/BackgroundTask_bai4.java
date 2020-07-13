package com.example.dangdinhtien_lab2;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class BackgroundTask_bai4 extends AsyncTask<String, Void, Void> {

    String duongdan = MainActivityBai4.SERVER_NAME;
    TextView tvKetqua;
    String str;
    ProgressDialog dialog;
    Context context;
    public BackgroundTask_bai4(Context context, TextView tvketqua){
        this.context = context;
        this.tvKetqua = tvketqua;


    }
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        dialog = new ProgressDialog(context);
        dialog.setMessage("Calculating...");
        dialog.setIndeterminate(false);
        dialog.show();
    }


    @Override
    protected Void doInBackground(String... strings) {
        try {
            URL url = new URL(duongdan);
            String param = "a=" + URLEncoder.encode(strings[0].toString(), "utf-8") + "&b="
                    + URLEncoder.encode(strings[1].toString(), "utf-8")
                    + URLEncoder.encode(strings[2].toString(), "utf-8");
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setDoOutput(true);
            urlConnection.setRequestMethod("POST");
            urlConnection.setFixedLengthStreamingMode(param.getBytes().length);
            urlConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

            PrintWriter printWriter = new PrintWriter(urlConnection.getOutputStream());
            printWriter.print(param);
            printWriter.close();

            String line = "";
            BufferedReader bfr = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

            StringBuffer sb = new StringBuffer();
            while ((line = bfr.readLine()) != null){
                sb.append(line);
            }
            str = sb.toString();
            urlConnection.disconnect();
        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        if (dialog.isShowing()){
            dialog.dismiss();
        }
        tvKetqua.setText(str);
    }
}
