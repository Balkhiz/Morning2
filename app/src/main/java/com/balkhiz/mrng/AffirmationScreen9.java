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
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class AffirmationScreen9 extends AppCompatActivity {

    RecyclerView rv;

    private static final String TABLE_NAME = "data_table";
    public static final String COLUMN_NAME = "notes";
    private ArrayList <String> list;


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
       // rv.setLayoutManager( new LinearLayoutManager( this ) );

        List<String> list = new ArrayList( );

        list.add("I am feeling healthy and strong today.");
        list.add("I have all that i need to make this a great day of my life.");
        list.add("I have all the information i need to solve any challenges that come up today.");
        list.add("I have the knowledge to make smart decisions for myself today.");
        list.add("I make the right choices all day using my inner wisdom.");
        list.add("I am happy and content with my life.");
        list.add( "I am patient and calm and greet the day with ease.");
        list.add("I am filled with gratitude and kindness for another day on this earth.");
        insert( list );
       // printTable( TABLE_NAME  );

       //rv.setAdapter( new MyAdapter( list, AffirmationScreen9.this ) );

        ImageButton imageButton = (ImageButton) findViewById( R.id.image );
        imageButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                Intent i = new Intent( AffirmationScreen9.this, NavDrawerH5.class );
                startActivity( i );
                }
        } );


        ImageButton imageButton2 = (ImageButton) findViewById( R.id.image3 );
        imageButton2.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                Intent i = new Intent( AffirmationScreen9.this, welcomeActivityScreen4.class );
                startActivity( i );
            }
        } );
    }

    public List<String> fetchData(){
        final String TABLE_NAME="data_table";
        String selectQuery="SELECT * FROM " + TABLE_NAME;
        //SQLiteDatabase db=this.getReadableDatabase();
        SQLiteDatabase db = new DatabaseHelper( AffirmationScreen9.this ).getReadableDatabase();
        Cursor cursor=db.rawQuery( selectQuery,null );
       // String[] data=new String[]{};
        List<String> list=new ArrayList <>(  );
        if(cursor.moveToFirst()){
            do{
                int i=0;
               // int index=cursor.getColumnIndex( DatabaseHelper.notes );
                //String name=cursor.getString( index );
                String name=cursor.getString( cursor.getColumnIndex( COLUMN_NAME ) );
                list.add(name);
                i++;
            }while (cursor.moveToNext());
        }
        cursor.close();
        return list;
    }


    public void insert(List<String> list){
        SQLiteDatabase db = new DatabaseHelper( AffirmationScreen9.this ).getWritableDatabase();
        for(String val:list){
            ContentValues values=new ContentValues();
            values.put(COLUMN_NAME,val);
            db.insert(TABLE_NAME,null,values);
        }
    }

    public String printTable(String TABLE_NAME) {
        String tableString = String.format("Table %s:\n", TABLE_NAME);
        try {
            SQLiteDatabase db = new DatabaseHelper(AffirmationScreen9.this).getReadableDatabase();
            Cursor allRows = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
            tableString += "\n";
            if (allRows.moveToFirst()) {
                String[] columnNames = allRows.getColumnNames();
                do {
                    for (String name : columnNames) {
                        tableString += String.format("%s : %s\t\t\t", name, allRows.getString(allRows.getColumnIndex(name)));
                    }
                    tableString += "\n";
                    Log.d("ROW:" + "MYLOG", tableString);
                    tableString = "";
                } while (allRows.moveToNext());
            }
            if (allRows != null) {
                allRows.close();
            }
        } catch (Exception e) {
           // Util.handleException(e);
        }

        return tableString;
    }

    public void populateRv(List<String> list) {
        rv.setLayoutManager( new LinearLayoutManager( this ) );
        rv.setAdapter( new MyAdapter( list, AffirmationScreen9.this ) );
        }

    @Override
    public void onResume(){
        super.onResume();
        List<String> list= fetchData();
        populateRv( list );

    }
}

