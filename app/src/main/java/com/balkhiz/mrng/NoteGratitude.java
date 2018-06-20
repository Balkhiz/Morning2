package com.balkhiz.mrng;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;

public class NoteGratitude extends AppCompatActivity {

    EditText editText;
    ImageButton image2;
    DatabaseHelper myDb;

    public static final String COLUMN_NAME = "notes";
    private ArrayList<String> list;
    private String notes;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        if (Build.VERSION.SDK_INT >= 19) {
            getWindow().addFlags( WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS );
        } else {
            getWindow().clearFlags( WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS );
        }
        setContentView( R.layout.activity_note_gratitude );
        myDb = new DatabaseHelper( this );

        editText = (EditText) findViewById( R.id.editText );
        image2 = (ImageButton) findViewById( R.id.image2 );
        AddData();

       // Typeface myTypeface = Typeface.createFromAsset( getAssets(), "Lato-Regular.ttf" );
        //TextView myTextView = (TextView) findViewById( R.id.textView );
        //myTextView.setTypeface( myTypeface );

    }

    public void AddData() {
        image2.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isInserted = myDb.insertData( editText.getText().toString() );
                if (isInserted = true)
                    Toast.makeText( NoteGratitude.this, "Data Inserted", Toast.LENGTH_LONG ).show();
                else
                    Toast.makeText( NoteGratitude.this, "Data not Inserted", Toast.LENGTH_LONG ).show();
            }
        } );

        ImageButton imageButton = (ImageButton) findViewById( R.id.imageButton );
        imageButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent( NoteGratitude.this, GratitudeScreen11.class );
                startActivity( i );
            }
        } );

        ImageButton imageButton3=(ImageButton)findViewById( R.id.imageButton3 );
        imageButton3.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent( NoteGratitude.this,welcomeActivityScreen4.class );
                startActivity( i );
            }
        } );
    }
}