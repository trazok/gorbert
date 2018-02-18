package com.gorbert.android.rosebud;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dell on 2/3/2018.
 */

public class OrderActivity extends AppCompatActivity
{
    private Button mOrderButton;




    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        System.setProperty("http.proxyHost", "127.0.0.1");
        System.setProperty("https.proxyHost", "127.0.0.1");
        System.setProperty("http.proxyPort", "8888");
        System.setProperty("https.proxyPort", "8888");




        setContentView(R.layout.activity_order);

        mOrderButton = (Button) findViewById(R.id.order_button);
        mOrderButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                try
                {
                    placeOrder();

                }
                catch (Exception e)
                {
                    System.out.println(e.toString());

                };

            }
        });
    }

    private class PlaceOrderTask extends AsyncTask<String, Void, Integer>
    {
        private String mOrder;



        public PlaceOrderTask(String order)
        {
            mOrder = order;
        }



        @Override
        protected Integer doInBackground(String... order)
        {
            URL url = null;
            try
            {
                url = new URL("http://192.168.1.6:9999/receive_order/order");
            }
            catch (MalformedURLException e)
            {
                e.printStackTrace();
            }

            String charset = "UTF-8";
            String param1 = "black";
            String param2 = "coffee";

            String query = null;
            try
            {
                query = String.format("param1=%s&param2=%s",
                        URLEncoder.encode(param1, charset),
                        URLEncoder.encode(param2, charset));
            } catch (UnsupportedEncodingException e)
            {
                e.printStackTrace();
            }


            URLConnection connection = null;
            try
            {
                connection = url.openConnection();
            } catch (IOException e)
            {
                e.printStackTrace();
            }


            connection.setDoOutput(true); // Triggers POST.
            connection.setRequestProperty("Accept-Charset", charset);
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=" + charset);

            try (OutputStream output = connection.getOutputStream()) {
                output.write(query.getBytes(charset));

            } catch (IOException e)
            {
                e.printStackTrace();
            }

            try
            {
                InputStream response = connection.getInputStream();
            } catch (IOException e)
            {
                e.printStackTrace();
            }


            return 0;
        }



    }


    public void placeOrder() throws Exception
    {

        new PlaceOrderTask("black coffee").execute();

        //if (response == con.HTTP_OK)
        Toast.makeText(this, R.string.order_toast, Toast.LENGTH_SHORT).show();
    }
}
