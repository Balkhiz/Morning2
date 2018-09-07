package com.balkhiz.mrng;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ReminderScreen10a extends AppCompatActivity {

    int preSelectedIndex = -1;

    SharedPreferences sharedPreferences;
    Context context;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (Build.VERSION.SDK_INT >= 19) {
            getWindow().addFlags( WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS );
        } else {
            getWindow().clearFlags( WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS );
        }
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_reminder_screen10a );

        Typeface myTypeface = Typeface.createFromAsset( getAssets(), "Lato-Regular.ttf" );
        TextView myTextView = (TextView) findViewById( R.id.textView );
        myTextView.setTypeface( myTypeface );

        Typeface myTypeface2 = Typeface.createFromAsset( getAssets(), "Lato-Regular.ttf" );
        TextView myTextView2 = (TextView) findViewById( R.id.textView );
        myTextView2.setTypeface( myTypeface2 );

        ListView listView = (ListView) findViewById( R.id.listview );
        final List <UserModel> users = new ArrayList <>();

        users.add( new UserModel( false, "          Track 1" ) );
        users.add( new UserModel( false, "          Track 2" ) );
        users.add( new UserModel( false, "          Track 3" ) );
        users.add( new UserModel( false, "          Track 4" ) );
        users.add( new UserModel( false, "          Track 5" ) );
        users.add( new UserModel( false, "          Track 6" ) );

        final CustomAdapter adapter = new CustomAdapter( this, users );
        listView.setAdapter( adapter );
        listView.setOnItemClickListener( new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView <?> adapterView, View view, int i, long l) {

                UserModel model = users.get( i ); //changed it to model because viewers will confused about it
                model.setSelected( true );
                users.set( i, model );
                if (preSelectedIndex > -1) {
                    UserModel preRecord = users.get( preSelectedIndex );
                    preRecord.setSelected( false );
                    users.set( preSelectedIndex, preRecord );
                }
                preSelectedIndex = i;
                //now update adapter so we are going to make a update method in adapter
                adapter.updateRecords( users );
                //now declare adapter final to access in inner method
            }
        } );


        ImageButton image = (ImageButton) findViewById( R.id.image );
        image.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                Intent i = new Intent( ReminderScreen10a.this, ReminderScreen10.class );
                startActivity( i );

            }
        } );

        ImageButton image3 = (ImageButton) findViewById( R.id.image3 );
        image3.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                Intent i = new Intent( ReminderScreen10a.this, welcomeActivityScreen4.class );
                startActivity( i );

            }
        } );

    }
}


