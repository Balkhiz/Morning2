package com.balkhiz.mrng;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class TaskListScreen12 extends AppCompatActivity {

    private ImageButton button;
    private ListView listView;
    private ArrayList<String> stringArrayList;
    private ArrayAdapter<String> stringArrayAdapter;
    private String a[]={"1.  I am feeling healthy and strong today.","2.  I have all that I need to make this a great day of my life.","3.  I have all the information I need to solve any challenges that come up today.","4.  I have the knowledge to make smart decisions for myself today.","5.  I make the right choices all day using my inner wisdom.","6.  I am happy and content with my life."};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_task_list );

        Typeface myTypeface=Typeface.createFromAsset( getAssets(),"Lato-Regular.ttf" );
        TextView myTextView =(TextView) findViewById( R.id.textView );
        myTextView.setTypeface( myTypeface );

        Typeface myTypeface2=Typeface.createFromAsset( getAssets(),"Lato-Regular.ttf" );
        TextView myTextView2 =(TextView) findViewById( R.id.textView );
        myTextView2.setTypeface( myTypeface2 );

        Typeface myTypeface3=Typeface.createFromAsset( getAssets(),"Lato-Regular.ttf" );
        TextView myTextView3 =(TextView) findViewById( R.id.textView3);
        myTextView3.setTypeface( myTypeface );

        Typeface myTypeface4=Typeface.createFromAsset( getAssets(),"Lato-Regular.ttf" );
        TextView myTextView4 =(TextView) findViewById( R.id.textView );
        myTextView4.setTypeface( myTypeface4 );

        button=(ImageButton) findViewById(R.id.image );
        listView= findViewById(R.id.listview);

        stringArrayList= new ArrayList<String>();
        stringArrayAdapter =new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1,stringArrayList);
        listView.setAdapter(stringArrayAdapter);
        for(int i=0;i<6;i++) {
            stringArrayList.add(a[i]);
        }


    ImageButton imageButton = (ImageButton)findViewById( R.id.image );
    imageButton.setOnClickListener( new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {

                                            Intent i = new Intent( TaskListScreen12.this, HomeScreen5.class );
                                            startActivity( i );

                                        }
                                    });


            ImageButton imageButton2 = (ImageButton)findViewById( R.id.image3 );
        imageButton2.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent( TaskListScreen12.this, welcomeActivityScreen4.class );
                startActivity( i );
            }
        });
    }
}


