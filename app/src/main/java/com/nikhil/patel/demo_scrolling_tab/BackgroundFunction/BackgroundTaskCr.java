package com.nikhil.patel.demo_scrolling_tab.BackgroundFunction;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.view.Display;
import android.widget.Toast;

import com.nikhil.patel.demo_scrolling_tab.Activity.Under5_Core;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by ABC on 04-Apr-17.
 */

public class BackgroundTaskCr extends AsyncTask<String,Void,String> {
    Context ctx;
    TaskCompleteCR t;
    private final ProgressDialog dialog ;
    static String method;

    public BackgroundTaskCr(Context ctx , ProgressDialog dialog , TaskCompleteCR t )
    {
        this.ctx =ctx; this.dialog = dialog; this.t = t;
    }

    protected String doInBackground(String...params)
    {
        String select="http://nikhil4969.esy.es/Ayurvihar/child_rec_display2.php";
        String childidentifier=params[0];
        try
        {
            URL url =new URL(select);
            HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            OutputStream outputStream = httpURLConnection.getOutputStream();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
            String data = URLEncoder.encode("childidentifier", "UTF-8") + "=" + URLEncoder.encode(childidentifier, "UTF-8");
            bufferedWriter.write(data);
            bufferedWriter.flush();
            bufferedWriter.close();
            outputStream.close();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
            String response = "";
            String line  = "";
            while ((line = bufferedReader.readLine())!=null)
            {
                response+= line;
            }
            bufferedReader.close();
            inputStream.close();
            httpURLConnection.disconnect();

            Log.i("Content" , response);
            String R[] = response.split(",");
            Under5_Core.childidentifier = R[0];
            Under5_Core.familyidentifier = R[1];
            Under5_Core.address = R[2];
            Under5_Core.mobilenumber = R[3];
            Under5_Core.childname = R[4];
            Under5_Core.fathername = R[5];
            Under5_Core.mothername = R[6];
            Under5_Core.dob = R[7];
            Under5_Core.sex = R[8];

            return "Update RS";
        }
        catch(MalformedURLException e)
        {
            e.printStackTrace();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        return null;
    }
}
