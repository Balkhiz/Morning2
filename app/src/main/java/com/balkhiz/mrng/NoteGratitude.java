package com.balkhiz.mrng;

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
    DataBaseHelper2G myDb;

    public static final String COLUMN_NAME = "grate";
    private ArrayList<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        if (Build.VERSION.SDK_INT >= 19) {
            getWindow().addFlags( WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS );
        } else {
            getWindow().clearFlags( WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS );
        }
        setContentView( R.layout.activity_note_gratitude );
        myDb = new DataBaseHelper2G( this );

        editText = (EditText) findViewById( R.id.editText );
        image2 = (ImageButton) findViewById( R.id.image2 );
        AddData();


    }

    public void AddData() {
        image2.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isInserted = myDb.insertData( editText.getText().toString() );
                if (isInserted ) {
                    Toast.makeText( NoteGratitude.this, "Data Inserted", Toast.LENGTH_LONG ).show();
                    finish();
                }
                    else
                        Toast.makeText( NoteGratitude.this, "Data not Inserted", Toast.LENGTH_LONG ).show();
            }
        } );

        ImageButton imageButton = (ImageButton) findViewById( R.id.image );
        imageButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Intent i = new Intent( NoteGratitude.this, GratitudeScreen11.class );
                startActivity( i );
            }
        } );

        ImageButton imageButton3=(ImageButton)findViewById( R.id.image3 );
        imageButton3.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Intent i =new Intent( NoteGratitude.this,welcomeActivityScreen4.class );
                startActivity( i );
            }
        } );
    }
}