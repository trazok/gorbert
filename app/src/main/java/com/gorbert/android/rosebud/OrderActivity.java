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
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
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
        mOrder = "tea";

        System.setProperty("http.proxyHost", "127.0.0.1");
        System.setProperty("https.proxyHost", "127.0.0.1");
	    System.setProperty("http.proxyPort", "8888");
	    System.setProperty("https.proxyPort", "8888");



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
                url = new URL("https://fcd8aacf.ngrok.io/receive_order/order");
            } catch (MalformedURLException e)
            {
                e.printStackTrace();
            }

            Map<String, Object> params = new LinkedHashMap<>();
                params.put("order", "Black Coffee");

                StringBuilder postData = new StringBuilder();
                for (Map.Entry<String, Object> param : params.entrySet())
                {
                    if (postData.length() != 0) postData.append('&');
                    try
                    {
                        postData.append(URLEncoder.encode(param.getKey(), "UTF-8"));
                    } catch (UnsupportedEncodingException e)
                    {
                        e.printStackTrace();
                    }
                    postData.append('=');
                    try
                    {
                        postData.append(URLEncoder.encode(String.valueOf(param.getValue()), "UTF-8"));
                    } catch (UnsupportedEncodingException e)
                    {
                        e.printStackTrace();
                    }
                }
            byte[] postDataBytes = new byte[0];
            try
            {
                postDataBytes = postData.toString().getBytes("UTF-8");
            } catch (UnsupportedEncodingException e)
            {
                e.printStackTrace();
            }

            HttpURLConnection conn = null;
            if (url != null)
            {
                try
                {
                    conn = (HttpURLConnection) url.openConnection();
                } catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
            if (conn != null)
            {
                try
                {
                    conn.setRequestMethod("POST");
                } catch (ProtocolException e)
                {
                    e.printStackTrace();
                }
            }
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                conn.setRequestProperty("Content-Length", String.valueOf(postDataBytes.length));
                conn.setDoOutput(true);
            try
            {
                conn.getOutputStream().write(postDataBytes);
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
