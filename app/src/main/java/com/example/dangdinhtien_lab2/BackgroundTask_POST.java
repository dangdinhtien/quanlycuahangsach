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

public class BackgroundTask_POST extends AsyncTask<Void, Void, Void> {
    String duongdan = MainActivitBbai2.SERVER_NAME;
    TextView tvResult;
    String strWidth, strLength;
    String str;
    ProgressDialog dialog;
    Context context;
    public BackgroundTask_POST(Context context, TextView tvResult, String strWidth, String strLength){
        this.context = context;
        this.tvResult = tvResult;
        this.strWidth = strWidth;
        this.strLength = strLength;
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
    protected Void doInBackground(Void... params) {
        try {
            URL url = new URL(duongdan);
            String param = "chieurong=" + URLEncoder.encode(strWidth, "utf-8") + "&chieudai="
                    + URLEncoder.encode(strLength, "utf-8");
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
    protected void onPostExecute(Void result) {
        super.onPostExecute(result);
        if(dialog.isShowing()){
            dialog.dismiss();
        }
        tvResult.setText(str);

    }
}
