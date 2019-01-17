package com.example.subhash.notificationphp;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String url = "http://192.168.0.103/fcminsert.php";
        SharedPreferences sharedPreferences=getApplicationContext().getSharedPreferences(getString(R.string.fcmp),MODE_PRIVATE);
        final String token=sharedPreferences.getString("tk","");

        Toast.makeText(this, "token id : "+token, Toast.LENGTH_SHORT).show();
        StringRequest stringRequest= new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Log.e(getPackageName(),"fcminsert"+response);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {


            }
        })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String,String> parms=new HashMap<String, String>();
                parms.put("fcm_token",token);
                return parms;
            }
        };
        MySinglton.getmInstance(MainActivity.this).addToRequestqueue(stringRequest);
    }
}
