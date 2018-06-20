package com.balkhiz.mrng;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class ReminderScreen10 extends Activity {
    //to make our alarm manager
    AlarmManager alarm_manager;
    TimePicker alarm_timepicker;
    TextView update_text;
    Context context;
    PendingIntent pending_Intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        if (Build.VERSION.SDK_INT >= 19) {
            getWindow().addFlags( WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS );
        } else {
            getWindow().clearFlags( WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS );
        }
        setContentView( R.layout.activity_reminder );
        this.context = this;

        //initialize our alarm manager
        alarm_manager = (AlarmManager) getSystemService( ALARM_SERVICE );

        //initialize our timepicker
        alarm_timepicker = (TimePicker) findViewById( R.id.timePicker );

        //intialize our update box
        update_text = (TextView) findViewById( R.id.update_text );

        //create ou instance of a calender
        final Calendar calendar = Calendar.getInstance();

        //initialize start button
        Button alarm_on = (Button) findViewById( R.id.alarm1 );
        //create an onClick listener to start the alarm

        //create an intent to the Alarm Reciever class
        final Intent my_intent = new Intent( this.context, Alarm_Reciever.class );

        //create an onclick listener to create the class
        alarm_on.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //setting calender instance with the hour and minute that we picked
                calendar.set( Calendar.HOUR_OF_DAY, alarm_timepicker.getHour() );
                calendar.set( Calendar.MINUTE, alarm_timepicker.getMinute() );

                //get the string values of the hour and minute
                int hour = alarm_timepicker.getHour();
                int minute = alarm_timepicker.getMinute();

                //convert the int values to strings
                String hour_string = String.valueOf( hour );
                String minute_string = String.valueOf( minute );

                //converts 24 hour time to 12 hour
                if (hour > 12) {
                    hour_string = String.valueOf( hour - 12 );
                }

                if (hour < 10) {
                    //10:7 -->10:07
                    minute_string = "0" + String.valueOf( minute );
                }

                //method that changes the update text Textbox
                set_alarm_text( "Alarm set to: " + hour_string + ":" + minute_string );

                //put it extra string into my_intent
                //tells the clock that yu pressed the alarm on button

                my_intent.putExtra( "extra","alarm on" );
            }
            private void set_alarm_text(String s) {
                update_text.setText( s );
            }

        } );


        //create a pending intent that delays the intent
        //until the specified calender time
        pending_Intent=PendingIntent.getBroadcast(ReminderScreen10.this,0,my_intent,PendingIntent.FLAG_UPDATE_CURRENT);

        //set the alarm manager
        alarm_manager.set(AlarmManager.RTC_WAKEUP,calendar.getTimeInMillis(),pending_Intent);



        //initialize stop button
        Button alarm_off=(Button)findViewById( R.id.alarm2 );
        //create an onClick listener to stop the alarm or undo an alarm set

        alarm_off.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                set_alarm_text("Alarm off!");

                //cancel the alarm
                alarm_manager.cancel( pending_Intent );

                //put extra string into my_intent
                //tells the clock that you pressed the alarm off button
                my_intent.putExtra( "extra","alarm off");

                //stop the alarm
                sendBroadcast( my_intent );
            }

            private void set_alarm_text(String s) {
                update_text.setText( s );
            }
        } );

      ImageButton  imageButton= (ImageButton)findViewById( R.id.image );
        imageButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent( ReminderScreen10.this, HomeScreen5.class );
                startActivity( i );
            }
        } );

        ImageButton imageButton2= (ImageButton)findViewById( R.id.image3 );
        imageButton2.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ReminderScreen10.this,welcomeActivityScreen4.class );
                startActivity( i );
            }
        } );


    }

}

