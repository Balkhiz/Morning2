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

public class TaskList extends AppCompatActivity {

        RecyclerView rv;

    public static final String TABLE_NAME = "table_data";
    public static final String COLUMN_NAME = "news";

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate( savedInstanceState );
            if (Build.VERSION.SDK_INT >= 19) {
                getWindow().addFlags( WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS );
            } else {
                getWindow().clearFlags( WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS );
            }
            setContentView( R.layout.activity_task_list2 );
            Typeface myTypeface = Typeface.createFromAsset( getAssets(), "Lato-Regular.ttf" );
            TextView myTextView = (TextView) findViewById( R.id.textView );
            myTextView.setTypeface( myTypeface );

            rv = (RecyclerView) findViewById( R.id.activity_tasklist);
           // rv.setLayoutManager( new LinearLayoutManager( this ) );

            List<String> mlist = new ArrayList( );

            mlist.add("I am feeling healthy and strong today.");
            mlist.add("I have all that i need to make this is a great day of my life.");
            mlist.add("I have all the information i need to solve any challenges that come up today");
            mlist.add("I have the knowledge to make smart decicions for myself today");
            mlist.add("I make the right choices all day using my inner wisdom.");
            mlist.add("I am happy and content with my life.");
            insert( mlist );

           // rv.setAdapter( new MyAdapterT( mlist, TaskList.this ) );

            ImageButton imageButton = (ImageButton) findViewById( R.id.image );
            imageButton.setOnClickListener( new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    finish();
                    Intent i = new Intent( TaskList.this, NavDrawerH5.class );
                    startActivity( i );

                }
            } );

            ImageButton image3 = (ImageButton) findViewById( R.id.image3 );
            image3.setOnClickListener( new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    finish();
                    Intent i = new Intent( TaskList.this, welcomeActivityScreen4.class );
                    startActivity( i );

                }
            } );
        }

        public List<String> fData(){
            final String TABLE_NAME="table_data";
            String selectQuery="SELECT * FROM " + TABLE_NAME;
            SQLiteDatabase db=new DataBaseHelperT( TaskList.this ).getWritableDatabase();
            Cursor cursor =db.rawQuery( selectQuery,null );
            List<String> mlist = new ArrayList <>(  );
            if(cursor.moveToFirst()){
                do{
                    int i=0;
                    String name= cursor.getString( cursor.getColumnIndex( COLUMN_NAME ) );
                    mlist.add(name);
                    i++;
                    }while(cursor.moveToNext());
                }
                cursor.close();
            return mlist;
            }

            public void insert(List<String> mlist){
            SQLiteDatabase db=new DataBaseHelperT( TaskList.this ).getWritableDatabase();
            for(String val:mlist){
                ContentValues contentValues=new ContentValues(  );
                contentValues.put(COLUMN_NAME,val);
                db.insert( TABLE_NAME,null,contentValues );
            }
            }

            public void popRecycle(List<String> mlist){
                rv.setLayoutManager( new LinearLayoutManager( this ) );
                rv.setAdapter( new MyAdapterT( mlist, TaskList.this ) );
            }

            @Override
            public void onResume(){
            super.onResume();
            List<String> mlist=fData();
            popRecycle( mlist );
            }
    }