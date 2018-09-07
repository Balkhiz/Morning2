package com.balkhiz.mrng;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.widget.ImageView;

public class RateNw2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        if (Build.VERSION.SDK_INT >= 19) {
            getWindow().addFlags( WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS );
        } else {
            getWindow().clearFlags( WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS );
        }
        setContentView( R.layout.activity_rate_nw2 );
    }

    public static void dialogN(final Context context) {
        AlertDialog.Builder a_builder = new AlertDialog.Builder( context );
        ImageView imageView=new ImageView(context );
        imageView.setImageResource( R.drawable.ic_star_white );
       a_builder.setView(imageView );
        a_builder.setTitle( "                  Rate our App" );
        a_builder.setMessage( "If you like this app, please take a few seconds to rate us" )
                .setCancelable( false );
        DialogInterface.OnClickListener dialogClickListener=new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which){
                    case DialogInterface.BUTTON_POSITIVE:
                        break;

                    case DialogInterface.BUTTON_NEGATIVE:
                        break;
                }
            }
        };
       // a_builder.setNegativeButton( "MAYBE LATER", dialogClickListener);
       // a_builder.setPositiveButton( "RATE NOW",dialogClickListener );
        AlertDialog dialog=a_builder.create();
        dialog.show();

    }
}
