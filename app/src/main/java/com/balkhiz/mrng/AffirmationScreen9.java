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


public class AffirmationScreen9 extends AppCompatActivity {

    RecyclerView rv;
    String[] info;

    private static final String TABLE_NAME = "data_table";
    public static final String COLUMN_NAME = "notes";
    private ArrayList <String> list;
    private String notes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        if (Build.VERSION.SDK_INT >= 19) {
            getWindow().addFlags( WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS );
        } else {
            getWindow().clearFlags( WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS );
        }
        setContentView( R.layout.activity_affirmation );

        Typeface myTypeface = Typeface.createFromAsset( getAssets(), "Lato-Regular.ttf" );
        TextView myTextView = (TextView) findViewById( R.id.textView );
        myTextView.setTypeface( myTypeface );

        rv = (RecyclerView) findViewById( R.id.activity_affirmation );
        rv.setLayoutManager( new LinearLayoutManager( this ) );
        String[] info = {"I am feeling healthy and strong today.",
                "I have all that i need to make this a great day of my life.",
                "I have all the information i need to solve any challenges that come up today.",
                "I have the knowledge to make smart decisions for myself today.",
                "I make the right choices all day using my inner wisdom.",
                "I am happy and content with my life.",
                "I am patient and calm and greet the day with ease.",
                "I am filled with gratitude and kindness for another day on this earth."};

       rv.setAdapter( new MyAdapter( info, AffirmationScreen9.this ) );

        ImageButton imageButton = (ImageButton) findViewById( R.id.image );
        imageButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent( AffirmationScreen9.this, HomeScreen5.class );
                startActivity( i );

            }
        } );


        ImageButton imageButton2 = (ImageButton) findViewById( R.id.image3 );
        imageButton2.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent( AffirmationScreen9.this, welcomeActivityScreen4.class );
                startActivity( i );
            }
        } );
    }

    public String[] fetchData(){
        final String TABLE_NAME="data_table";
        String selectQuery="SELECT * FROM " + TABLE_NAME;
        //SQLiteDatabase db=this.getReadableDatabase();
        SQLiteDatabase db = new DatabaseHelper( AffirmationScreen9.this ).getReadableDatabase();
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

  //  public void populateRv(String[] info) {
    //    rv.setLayoutManager( new LinearLayoutManager( this ) );
      //  rv.setAdapter( new MyAdapter( info, AffirmationScreen9.this ) );
       // }

    @Override
    public void onResume(){
        super.onResume();
        //String[] data= fetchData();
        //populateRv( data );
    }
}

