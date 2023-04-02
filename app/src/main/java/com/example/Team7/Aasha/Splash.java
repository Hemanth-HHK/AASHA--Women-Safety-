package com.example.Team7.Aasha;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.Team7.Aasha.R;


public class Splash extends Activity {
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        new Thread() {
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (Exception e) {

                }

                startActivity( new Intent(Splash.this, MainActivity.class));
            }
        }.start();

    }

    @Override
         protected void onPause() {
         super.onPause();
         finish();
   }

}



