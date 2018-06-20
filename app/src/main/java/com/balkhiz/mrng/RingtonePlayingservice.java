package com.balkhiz.mrng;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by Balkhiz on 19-Mar-18.
 */
    public class RingtonePlayingservice extends Service {

        MediaPlayer media_song;
        int startId;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent,int flags,int startId){
        Log.i("LocalService","Recieved start id " + startId + ": " + intent);

        //fetch the extra string values
     //   String state=intent.getExtras().getString( "extra" );

     //   Log.e("Ringtone state:extra is" ,state);
     //   assert state != null;
     //   switch (state) {
     //       case "alarm on":
     //           startId = 1;
     //           break;
     //       case "alarm off":
     //           startId = 0;
     //           break;
     //       default:
     //           startId = 0;
     //           break;
     //   }

        //create an instance of the media player
        media_song=MediaPlayer.create( this ,R.raw.muskurane );
        media_song.start();

        return START_NOT_STICKY;
    }
    @Override
    public void onDestroy(){
        Toast.makeText( this,"on Destroy called", Toast.LENGTH_SHORT ).show();
    }
}
