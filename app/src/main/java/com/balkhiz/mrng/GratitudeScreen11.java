package com.balkhiz.mrng;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

public class GratitudeScreen11 extends AppCompatActivity {

    RecyclerView rv;
    String[] info;

    private static final String TABLE_NAME = "dataTable";
    public static final String COLUMN_NAME = "notes";
    private ArrayList<String> list;
    private String notes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        if (Build.VERSION.SDK_INT >= 19) {
            getWindow().addFlags( WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS );
        } else {
            getWindow().clearFlags( WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS );
        }
        setContentView( R.layout.activity_gratitude );

        Typeface myTypeface = Typeface.createFromAsset( getAssets(), "Lato-Regular.ttf" );
        TextView myTextView = (TextView) findViewById( R.id.textView );
        myTextView.setTypeface( myTypeface );

        RecyclerView rv = (RecyclerView) findViewById( R.id.activity_gratitude );
        rv.setLayoutManager( new LinearLayoutManager( this ) );
        String[] info = {"I am grateful for the beautiful new day,new morning and a fresh start.",
                "I am grateful for everything i have in my life.",
                "I always recieve excatly what i ask for and appreciate that.",
                "I am grateful for excellent health,prosperity and true love.",
                "My life is filled with an abundance of goodness.",
                "All challenges are an oppurtunity for growth and I am thankful for the chance to evolve.",
                "I am so grateful for supportive friends and loving family.",
                "I appreciate everything i have in my life and always keep the door open for more blessings.",
                "The universe supports me and all my desires.",
                "I am the co-creator of my reality.",
                "I see the beauty in nature that surrounds me.",
                "I give thanks for the helpful spirits and ancestors that guide me in this life journey.",
                "I am blessed.",
                "I feel gratitude for the all!"
        };

        rv.setAdapter( new Adapter( info, GratitudeScreen11.this ) );


        ImageButton imageButton = (ImageButton) findViewById( R.id.image );
        imageButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent( GratitudeScreen11.this, HomeScreen5.class );
                startActivity( i );
            }
        } );


        ImageButton imageButton2 = (ImageButton) findViewById( R.id.image3 );
        imageButton2.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent( GratitudeScreen11.this, welcomeActivityScreen4.class );
                startActivity( i );
            }
        } );
    }

    public String[] fetchData(){
        final String TABLE_NAME="dataTable";
        String selectQuery="SELECT * FROM " + TABLE_NAME;
        //SQLiteDatabase db=this.getReadableDatabase();
        SQLiteDatabase db = new DatabaseHelper( GratitudeScreen11.this ).getReadableDatabase();
        Cursor cursor=db.rawQuery( selectQuery,null );
        String[] data=new String[]{};
        if(cursor.moveToFirst()){
            do{
                int i=0;
                // int index=cursor.getColumnIndex( DatabaseHelper.notes );
                //String name=cursor.getString( index );
                String name=cursor.getString( cursor.getColumnIndex( notes ) );
                data[i]=name;
                i++;
            }while (cursor.moveToNext());
        }
        cursor.close();
        return data;
    }

    @Override
    public void onResume(){
        super.onResume();
        //String[] data= fetchData();
        //populateRv( data );
    }
}
