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

public class NoteTaskList extends AppCompatActivity {

    EditText editText;
    ImageButton image;
    DataBaseHelperT myDbse;

    public static final String COLUMN_NAME ="news";
    private ArrayList<String> list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        if (Build.VERSION.SDK_INT >= 19) {
            getWindow().addFlags( WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS );
        } else {
            getWindow().clearFlags( WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS );
        }
        setContentView( R.layout.activity_note_task_list );
        myDbse = new DataBaseHelperT( this );

        editText = (EditText) findViewById( R.id.editText );
        image = (ImageButton) findViewById( R.id.image2 );
        PlusData();

    }


        public void PlusData(){
        image.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isInserted = myDbse.insertionData( editText.getText().toString() );
                if(isInserted){
                    Toast.makeText( NoteTaskList.this, "Data Inserted", Toast.LENGTH_LONG ).show();
                    finish();
                }
                else
                    Toast.makeText( NoteTaskList.this, "Data not Inserted", Toast.LENGTH_LONG ).show();
            }
        } );



    ImageButton imageButton3 = (ImageButton) findViewById( R.id.image );
        imageButton3.setOnClickListener( new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            finish();
            Intent i = new Intent( NoteTaskList.this, NavDrawerH5.class );
            startActivity( i );

        }
    } );

    ImageButton imageButton = (ImageButton) findViewById( R.id.image3 );
        imageButton.setOnClickListener( new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            finish();
            Intent i = new Intent( NoteTaskList.this, welcomeActivityScreen4.class );
            startActivity( i );

        }
    } );
}
}

