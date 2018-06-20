package com.balkhiz.mrng;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.widget.TextView;

public class SplashScreen1 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= 19) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        } else {
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
        setContentView(R.layout.activity_splash);

        Typeface myTypeface=Typeface.createFromAsset( getAssets(),"Lato-Light.ttf" );
        TextView myTextView =(TextView) findViewById( R.id.textView2 );
        myTextView.setTypeface( myTypeface );

        Typeface myTypeface2=Typeface.createFromAsset( getAssets(),"Lato-Light.ttf" );
        TextView myTextView2 =(TextView) findViewById( R.id.textView3 );
        myTextView2.setTypeface( myTypeface2 );


        Handler handler = new Handler();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashScreen1.this, LoginScreen2.class));
                finish();
            }
        }, 5000);
    }

}
