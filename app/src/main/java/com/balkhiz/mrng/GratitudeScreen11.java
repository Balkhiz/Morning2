package com.balkhiz.mrng;

import android.content.ContentValues;
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
import java.util.List;

public class GratitudeScreen11 extends AppCompatActivity {

    RecyclerView rv;

    private static final String TABLE_NAME = "table_gratitude";
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
        setContentView( R.layout.activity_gratitude );

        Typeface myTypeface = Typeface.createFromAsset( getAssets(), "Lato-Regular.ttf" );
        TextView myTextView = (TextView) findViewById( R.id.textView );
        myTextView.setTypeface( myTypeface );

         rv = (RecyclerView) findViewById( R.id.activity_gratitude );
       // rv.setLayoutManager( new LinearLayoutManager( this ) );

        List<String> list = new ArrayList( );

        list.add("I am grateful for the beautiful new day,new morning and a fresh start.");
        list.add("I am grateful for everything i have in my life.");
        list.add("I always recieve excatly what i ask for and appreciate that.");
        list.add("I am grateful for excellent health,prosperity and true love.");
        list.add("My life is filled with an abundance of goodness.");
        list.add("All challenges are an oppurtunity for growth and I am thankful for the chance to evolve.");
        list.add("I am so grateful for supportive friends and loving family.");
        list.add("I appreciate everything i have in my life and always keep the door open for more blessings.");
        list.add("The universe supports me and all my desires.");
        list.add("I am the co-creator of my reality.");
        list.add ("I see the beauty in nature that surrounds me.");
        list.add("I give thanks for the helpful spirits and ancestors that guide me in this life journey.");;
        list.add("I am blessed.");
        list.add("I feel gratitude for the all!");
        insert( list );


      //  rv.setAdapter( new Adapter( info, GratitudeScreen11.this ) );


        ImageButton imageButton = (ImageButton) findViewById( R.id.image );
        imageButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                Intent i = new Intent( GratitudeScreen11.this, NavDrawerH5.class );
                startActivity( i );
            }
        } );


        ImageButton imageButton2 = (ImageButton) findViewById( R.id.image3 );
        imageButton2.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                Intent i = new Intent( GratitudeScreen11.this, welcomeActivityScreen4.class );
                startActivity( i );
            }
        } );
    }

    public void insert(List<String> list){
        SQLiteDatabase db = new DataBaseHelper2G( GratitudeScreen11.this ).getWritableDatabase();
        for(String val:list){
            ContentValues values=new ContentValues();
            values.put(COLUMN_NAME,val);
            db.insert(TABLE_NAME,null,values);
        }
    }

    public List<String> fetchData(){
        final String TABLE_NAME="table_gratitude";
        String selectQuery="SELECT * FROM " + TABLE_NAME;
        //SQLiteDatabase db=this.getReadableDatabase();
        SQLiteDatabase db = new DataBaseHelper2G( GratitudeScreen11.this ).getWritableDatabase();
        Cursor cursor=db.rawQuery( selectQuery,null );
       // String[] data=new String[]{};
        List<String> list=new ArrayList <>(  );
        if(cursor.moveToFirst()){
            do{
                int i=0;
                // int index=cursor.getColumnIndex( DatabaseHelper.notes );
                //String name=cursor.getString( index );
                String name=cursor.getString( cursor.getColumnIndex( COLUMN_NAME) );
               list.add(name);
                i++;
            }while (cursor.moveToNext());
        }
        cursor.close();
        return list;
    }

    public void populateRv(List<String> list) {
        rv.setLayoutManager( new LinearLayoutManager( this ) );
        rv.setAdapter( new Adapter( list, GratitudeScreen11.this ) );
        }

    @Override
    public void onResume(){
        super.onResume();
        List<String> list= fetchData();
        populateRv( list );
    }
}
