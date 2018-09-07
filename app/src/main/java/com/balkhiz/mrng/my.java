package com.balkhiz.mrng;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.ToggleButton;

import java.util.Calendar;

public class my extends Activity {

    AlarmManager alarmManager;
    private PendingIntent pendingIntent;
    private TimePicker alarmTimePicker;
    private static my inst;
    private TextView alarmTextView;

    MediaPlayer mediaPlayer;

    public static my instance() {
        return inst;
    }

    @Override
    public void onStart() {
        super.onStart();
        inst = this;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        if (Build.VERSION.SDK_INT >= 19) {
            getWindow().addFlags( WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS );
        } else {
            getWindow().clearFlags( WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS );
        }
        setContentView( R.layout.activity_my );

        Typeface myTypeface = Typeface.createFromAsset( getAssets(), "Lato-Regular.ttf" );
        TextView myTextView = (TextView) findViewById( R.id.textView );
        myTextView.setTypeface( myTypeface );

        ImageButton imageButton= (ImageButton)findViewById( R.id.image );
        imageButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                Intent i = new Intent( my.this, NavDrawerH5.class );
                startActivity( i );
            }
        } );

        ImageButton imageButton2= (ImageButton)findViewById( R.id.image3 );
        imageButton2.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                Intent i = new Intent(my.this,welcomeActivityScreen4.class );
                startActivity( i );
            }
        } );

        TextView textView = (TextView) findViewById( R.id.textView2 );
        textView.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Intent i = new Intent( my.this, ReminderScreen10a.class );
                startActivity( i );
            }
        } );


        alarmTimePicker = (TimePicker) findViewById( R.id.alarmTimePicker );
        alarmTextView = (TextView) findViewById( R.id.alarmText );
        ToggleButton alarmToggle = (ToggleButton) findViewById( R.id.alarmToggle );
        alarmManager = (AlarmManager) getSystemService( ALARM_SERVICE );
    }

    public void onToggleClicked(View view) {
        if (((ToggleButton) view).isChecked()) {
            Log.d( "MyActivity", "Alarm On" );
            Calendar calendar = Calendar.getInstance();
            calendar.set( Calendar.HOUR_OF_DAY, alarmTimePicker.getCurrentHour() );
            calendar.set( Calendar.MINUTE, alarmTimePicker.getCurrentMinute() );
            Intent myIntent = new Intent( my.this, AlarmReceiver.class );
            pendingIntent = PendingIntent.getBroadcast( my.this, 0, myIntent, 0 );
            alarmManager.set( AlarmManager.RTC, calendar.getTimeInMillis(), pendingIntent );
        } else {
            alarmManager.cancel( pendingIntent );
            setAlarmText( "" );
            Log.d( "MyActivity", "Alarm Off" );
        }
    }

//    public int onStartCommand(Intent intent,int flags,int startid){
//
//        Log.e("Local Service","Received start id"+startid+":"+intent);
//        Toast.makeText(my.this.getApplicationContext(), "hello", Toast.LENGTH_SHORT).show();
//
//        //create an instance of the media player
//        mediaPlayer = MediaPlayer.create(this, Settings.System.DEFAULT_ALARM_ALERT_URI);
//        mediaPlayer.setAudioStreamType( AudioManager.STREAM_MUSIC);
//        mediaPlayer.start();
//        return START_STICKY;
//    }

    public void setAlarmText(String alarmText) {
        alarmTextView.setText( alarmText );
    }
}