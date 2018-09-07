package com.balkhiz.mrng;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.TextView;

public class VisionBoardScreen6 extends AppCompatActivity {

    ImageButton imageButton;
    ImageButton imageButton2;
    ImageButton imageButton3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        if (Build.VERSION.SDK_INT >= 19) {
            getWindow().addFlags( WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS );
        } else {
            getWindow().clearFlags( WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS );
        }
        setContentView( R.layout.activity_vision_board );

        Typeface myTypeface=Typeface.createFromAsset( getAssets(),"Lato-Regular.ttf" );
        TextView myTextView =(TextView) findViewById( R.id.textView );
        myTextView.setTypeface( myTypeface );

        Typeface myTypeface2=Typeface.createFromAsset( getAssets(),"Lato-Light.ttf" );
        TextView myTextView2 =(TextView) findViewById( R.id.textView2 );
        myTextView2.setTypeface( myTypeface2 );

        Typeface myTypeface3=Typeface.createFromAsset( getAssets(),"Lato-Light.ttf" );
        TextView myTextView3 =(TextView) findViewById( R.id.textView18 );
        myTextView3.setTypeface( myTypeface3 );

        imageButton = (ImageButton)findViewById( R.id.image );
        imageButton2= (ImageButton)findViewById( R.id.image3 );
        imageButton3 = (ImageButton)findViewById( R.id.imageButton3 );

        imageButton= (ImageButton)findViewById( R.id.image );
        imageButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                Intent i = new Intent( VisionBoardScreen6.this, NavDrawerH5.class );
                startActivity( i );
            }
        } );

        imageButton2= (ImageButton)findViewById( R.id.image3 );
        imageButton2.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                Intent i = new Intent( VisionBoardScreen6.this,welcomeActivityScreen4.class );
                startActivity( i );
            }
        } );

        imageButton3 = (ImageButton)findViewById( R.id.imageButton3 );
        imageButton3.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                Intent i = new Intent (VisionBoardScreen6.this, visionBoardScreen7.class);
                startActivity( i );
            }
        } );
        }
}
