package com.balkhiz.mrng;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by Balkhiz on 19-Mar-18.
 */
    public class RingtonePlayingservice extends Service {

        MediaPlayer media_song;
        int startId;
        boolean isRunning;


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    public int onStartCommand(Intent intent,int flags,int startId) {

        Log.i( "LocalService", "Recieved start id " + startId + ": " + intent );

        //fetch the extra string values
        String state = intent.getExtras().getString( "extra" );

        Log.e( "Ringtone extra is", state );

        //(notification)
        //set up the notification service
    //    NotificationManager notify_manager = (NotificationManager) getSystemService( NOTIFICATION_SERVICE );
        //set up an intent that goes to the main activity
    //    Intent intent_main_activity = new Intent( this.getApplicationContext(), ReminderScreen10.class );

        //set up a pending intent
    //    PendingIntent pending_intent_main_activity = PendingIntent.getActivity( this, 0, intent_main_activity, 0 );

        //make the notification parameters
    //    Notification notification_popup = new Notification.Builder( this )
    //            .setContentTitle( "An alarm is gong off" )
    //            .setContentText( "click me!" )
    //            .setContentIntent( pending_intent_main_activity )
     //           .setAutoCancel( true )
     //           .build();


    //set up the notification call method
   // notify_manager.notify(0,notification_popup);(notification)

        //this converts the extra strings from the intent
        //to start ids,values 0 or 1
        assert state != null;
        switch (state) {
            case "alarm on":
                startId = 1;
                break;
            case "alarm off":
                startId = 0;
                Log.e("Start Id is",state);
                break;
            default:
                startId = 0;
                break;
        }

        //if else statements

        //if there is no music playing,and the user pressed alarm on
        //music should start playing
        if(!this.isRunning && startId == 1){
            Log.e("there is no music,","and you want start");
            //create an instance of the media player
            media_song=MediaPlayer.create( this,R.raw.muskurane );
            //start the ringtone
            media_song.start();

            this.isRunning = true;
            this.startId = 0;
            }
        //if there is music playing ,and the user pressed alarm off
        //music should stop playing
        else if(this.isRunning && startId == 0){
            Log.e("there is  music,","and you want end");

            //stop the ringtone
            media_song.stop();
            media_song.reset();

            this.isRunning=false;
            this.startId=0;

        }
        //these are if the user presses random buttons
        //just to bug proof the app
        //if there is no music playing ,and the user pressed alarm off
        //do nothing
        else if(!this.isRunning && startId == 0){
            Log.e("there is no music,","and you want end");
            this.isRunning=false;
            this.startId=0;

        }
        //if there is music playing and the user pressed alarm on
        //do nothing
        else if(this.isRunning && startId == 1){
            Log.e("there is  music,","and you want start");
            this.isRunning=true;
            this.startId=1;

            }
        //cant think of anything else,just to catch the odd event
        else {
            Log.e("else","somehow yu reached this");

            }

        return START_NOT_STICKY;
    }

    @Override
    public void onDestroy(){
        //tell the user we stopped
        Log.e("on Destroy called","ta da");

        super.onDestroy();
        this.isRunning=false;

       // Toast.makeText( this,"on Destroy called", Toast.LENGTH_SHORT ).show();
    }
    }
