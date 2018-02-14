package com.gorbert.android.rosebud;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

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

                };

            }
        });
    }

    public void placeOrder() throws Exception
    {
        //contact servlet to log order
        String order = "black coffee";
        String url = "[https://585302d3.ngrok.io//receive_order/order]";
        byte[] postDataBytes = order.getBytes();
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        con.setRequestMethod("POST");
        con.setDoOutput(true);
        con.getOutputStream().write(postDataBytes);

        //if (response == con.HTTP_OK)
        Toast.makeText(this, R.string.order_toast, Toast.LENGTH_SHORT).show();
    }
}
