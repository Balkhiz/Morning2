package com.balkhiz.mrng;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class HomeScreen5 extends AppCompatActivity {

    ImageButton imageButton;
    TextView textView;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    Button button6;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        if (Build.VERSION.SDK_INT >= 19) {
            getWindow().addFlags( WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS );
        } else {
            getWindow().clearFlags( WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS );
        }
        setContentView( R.layout.activity_home_screen );

        Typeface myTypeface=Typeface.createFromAsset( getAssets(),"Lato-Regular.ttf" );
        TextView myTextView =(TextView) findViewById( R.id.textView );
        myTextView.setTypeface( myTypeface );

        Typeface myTypeface2=Typeface.createFromAsset( getAssets(),"Lato-Bold.ttf" );
        TextView myButton2 =(TextView) findViewById( R.id.button2 );
        myButton2.setTypeface( myTypeface2 );

        Typeface myTypeface3=Typeface.createFromAsset( getAssets(),"Lato-Bold.ttf" );
        TextView myButton3 =(TextView) findViewById( R.id.button3 );
        myButton3.setTypeface( myTypeface3 );

        Typeface myTypeface4=Typeface.createFromAsset( getAssets(),"Lato-Bold.ttf" );
        TextView myButton4 =(TextView) findViewById( R.id.button4 );
        myButton4.setTypeface( myTypeface4 );

        Typeface myTypeface5=Typeface.createFromAsset( getAssets(),"Lato-Bold.ttf" );
        TextView myButton5 =(TextView) findViewById( R.id.button5 );
        myButton5.setTypeface( myTypeface5 );

        Typeface myTypeface6=Typeface.createFromAsset( getAssets(),"Lato-Bold.ttf" );
        TextView myButton6 =(TextView) findViewById( R.id.button6 );
        myButton6.setTypeface( myTypeface6 );

        imageButton = (ImageButton)findViewById( R.id.image );
        textView = (TextView)findViewById( R.id.textView );
        button2 = (Button)findViewById( R.id.button2 );
        button3 = (Button)findViewById( R.id.button3 );
        button4 = (Button)findViewById( R.id.button4 );
        button5 = (Button)findViewById( R.id.button5 );
        button6 = (Button)findViewById( R.id.button6 );


        button2 = (Button)findViewById( R.id.button2 );
        button2.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent( HomeScreen5.this,VisionBoardScreen6.class );
                startActivity( i );
            }
        } );

        button3 = (Button)findViewById( R.id.button3 );
        button3.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(HomeScreen5.this,AffirmationScreen9.class);
                startActivity( i );
           }
        } );

        button4 = (Button)findViewById( R.id.button4 );
        button4.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent( HomeScreen5.this,my.class );
                startActivity( i );
            }
        } );

        button5 = (Button)findViewById( R.id.button5 );
        button5.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent( HomeScreen5.this,GratitudeScreen11.class );
                startActivity( i );
            }
        } );

        button6 = (Button)findViewById( R.id.button6 );
        button6.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent( HomeScreen5.this,TaskList.class );
                startActivity( i );
            }
        } );
    }
}
