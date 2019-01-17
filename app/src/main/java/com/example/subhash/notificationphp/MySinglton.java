package com.example.subhash.notificationphp;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class MySinglton  {
    private static MySinglton mInstance;
    private static Context mcxt;
    private RequestQueue requestQueue;
    private MySinglton (Context context)
    {
        mcxt=context;
        requestQueue=getRequestQueue();

    }
    private RequestQueue getRequestQueue()
    {
        if (requestQueue==null)
        {
            requestQueue=Volley.newRequestQueue(mcxt.getApplicationContext());
        }
        return requestQueue;
    }
    public static synchronized MySinglton getmInstance(Context context)
    {
        if (mInstance==null)
        {
            mInstance=new MySinglton(context);
        }
        return mInstance;
    }
    public<T> void addToRequestqueue(Request<T> request)
    {
        getRequestQueue().add(request);
    }

}
