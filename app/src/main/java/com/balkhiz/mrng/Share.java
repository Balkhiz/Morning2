package com.balkhiz.mrng;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

public class Share extends AppCompatActivity {

    public static void shareVia(Context context, String url) {
        Intent sharingIntent = new Intent( Intent.ACTION_SEND );
        sharingIntent.setType( "text/plain" );
        String shareBody = " your ad text " + url;
        sharingIntent.putExtra( Intent.EXTRA_SUBJECT, "subject" );
        sharingIntent.putExtra( Intent.EXTRA_TEXT, shareBody );
        context.startActivity( Intent.createChooser( sharingIntent, "Share via" ) );
    }
}


