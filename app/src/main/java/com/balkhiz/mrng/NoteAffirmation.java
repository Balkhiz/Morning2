package com.balkhiz.mrng;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class NoteAffirmation extends AppCompatActivity {
    EditText editText;
    ImageButton image2;
    DatabaseHelper myDb;
   public SQLiteDatabase db;

    public static final String COLUMN_NAME = "notes";
    private ArrayList <String> list;
    private Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        if (Build.VERSION.SDK_INT >= 19) {
            getWindow().addFlags( WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS );
        } else {
            getWindow().clearFlags( WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS );
        }
        setContentView( R.layout.activity_note_affirmation );
        myDb = new DatabaseHelper( this );//call the constructor of this db helper class

        editText = (EditText) findViewById( R.id.editText );
        image2 = (ImageButton) findViewById( R.id.image2 );
        AddData();

        Typeface myTypeface = Typeface.createFromAsset( getAssets(), "Lato-Regular.ttf" );
        TextView myTextView = (TextView) findViewById( R.id.textView );
        myTextView.setTypeface( myTypeface );
    }

    public void AddData() {
        image2.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean Inserted = myDb.insertData( editText.getText().toString() );

                if (Inserted)
                {
                    Toast.makeText( NoteAffirmation.this, "Data Inserted", Toast.LENGTH_LONG ).show();
                    finish();
                }
                else
                Toast.makeText( NoteAffirmation.this, "Data not Inserted", Toast.LENGTH_LONG ).show();
            }
        } );


        ImageButton image = (ImageButton) findViewById( R.id.image );
        image.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                Intent i = new Intent( NoteAffirmation.this, AffirmationScreen9.class );
                startActivity( i );

            }
        } );

        ImageButton image3 = (ImageButton) findViewById( R.id.image3 );
        image3.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                Intent i = new Intent( NoteAffirmation.this, welcomeActivityScreen4.class );
                startActivity( i );

            }
        } );
    }

}