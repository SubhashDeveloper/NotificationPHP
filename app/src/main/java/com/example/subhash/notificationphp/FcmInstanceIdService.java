package com.example.subhash.notificationphp;

import android.content.Intent;
import android.content.SharedPreferences;

import com.android.volley.Request;
import com.android.volley.toolbox.StringRequest;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

public class FcmInstanceIdService extends FirebaseInstanceIdService {

    @Override
    public void onTokenRefresh() {
        String recent_token=FirebaseInstanceId.getInstance().getToken();
        SharedPreferences sharedPreferences=getApplicationContext().getSharedPreferences(getString(R.string.fcmp),MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString("tk",recent_token);
        editor.commit();
//        Intent intent=new Intent(getApplicationContext(),MainActivity.class);
//        intent.putExtra("tk",recent_token);
//        startActivity(intent);

    }
}
