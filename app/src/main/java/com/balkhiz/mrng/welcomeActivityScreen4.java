package com.balkhiz.mrng;

import android.content.Intent;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;


public class welcomeActivityScreen4 extends AppCompatActivity {

    Button getstart;
    ImageButton imageButton;
    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        if (Build.VERSION.SDK_INT >= 19) {
            getWindow().addFlags( WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS );
        } else {
            getWindow().clearFlags( WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS );
        }
        setContentView( R.layout.activity_welcome );
        addButtonClickListener();

        Typeface myTypeface=Typeface.createFromAsset( getAssets(),"Lato-Light.ttf" );
        TextView myTextView =(TextView) findViewById( R.id.textView2 );
        myTextView.setTypeface( myTypeface );

        Typeface myTypeface2=Typeface.createFromAsset( getAssets(),"Lato-Light.ttf" );
        TextView myTextView2=(TextView)findViewById( R.id.textView3 );
        myTextView2.setTypeface( myTypeface2 );

        Typeface myTypeface3=Typeface.createFromAsset( getAssets(),"Lato-Semibold.ttf" );
        TextView myTextView3 =(TextView) findViewById( R.id.textView4 );
        myTextView3.setTypeface( myTypeface3 );

        Typeface myTypeface12=Typeface.createFromAsset( getAssets(),"Lato-Regular.ttf" );
        TextView myTextView12 =(TextView) findViewById( R.id.textView5 );
        myTextView12.setTypeface( myTypeface12 );

        Typeface myTypeface4=Typeface.createFromAsset( getAssets(),"Lato-Semibold.ttf" );
        TextView myTextView4 =(TextView) findViewById( R.id.textView );
        myTextView4.setTypeface( myTypeface4 );

        Typeface myTypeface5=Typeface.createFromAsset( getAssets(),"Lato-Regular.ttf" );
        TextView myTextView5 =(TextView) findViewById( R.id.textView7 );
        myTextView5.setTypeface( myTypeface5 );

        Typeface myTypeface6=Typeface.createFromAsset( getAssets(),"Lato-Semibold.ttf" );
        TextView myTextView6 =(TextView) findViewById( R.id.textView9 );
        myTextView6.setTypeface( myTypeface6 );

        Typeface myTypeface7=Typeface.createFromAsset( getAssets(),"Lato-Regular.ttf" );
        TextView myTextView7 =(TextView) findViewById( R.id.textView10 );
        myTextView7.setTypeface( myTypeface7 );

        Typeface myTypeface8=Typeface.createFromAsset( getAssets(),"Lato-Semibold.ttf" );
        TextView myTextView8 =(TextView) findViewById( R.id.textView12 );
        myTextView8.setTypeface( myTypeface8 );

        Typeface myTypeface9=Typeface.createFromAsset( getAssets(),"Lato-Regular.ttf" );
        TextView myTextView9 =(TextView) findViewById( R.id.textView13 );
        myTextView9.setTypeface( myTypeface9 );

        Typeface myTypeface10=Typeface.createFromAsset( getAssets(),"Lato-Semibold.ttf" );
        TextView myTextView10 =(TextView) findViewById( R.id.textView15 );
        myTextView10.setTypeface( myTypeface10 );

        Typeface myTypeface11=Typeface.createFromAsset( getAssets(),"Lato-Regular.ttf" );
        TextView myTextView11 =(TextView) findViewById( R.id.textView16 );
        myTextView11.setTypeface( myTypeface11 );

        Typeface myTypeface13=Typeface.createFromAsset( getAssets(),"Lato-Bold.ttf" );
        Button myButton13 =(Button) findViewById( R.id.getstart );
        myButton13.setTypeface( myTypeface13 );




        imageButton = (ImageButton) findViewById( R.id.image );
        final MediaPlayer mp = MediaPlayer.create( this, R.raw.maghadheera );
        imageButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mp.isPlaying()) {
                    mp.pause();
                    imageButton.setImageResource( R.drawable.ic_play_button );

                } else {
                    mp.start();
                    imageButton.setImageResource( R.drawable.ic_pause_button );
                }
            }
        } );
    }

        @Override
        protected void onStop () {
            super.onStop();
           //   mp.stop();
          }



    public void addButtonClickListener(){
        getstart =(Button)findViewById(R.id.getstart);
        getstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(welcomeActivityScreen4.this, NavDrawerH5.class);
                startActivity(i);
            }
        });
    }
}

