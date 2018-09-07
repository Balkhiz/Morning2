package com.balkhiz.mrng;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

public class RateNw extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        if (Build.VERSION.SDK_INT >= 19) {
            getWindow().addFlags( WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS );
        } else {
            getWindow().clearFlags( WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS );
        }
        setContentView( R.layout.activity_rate_nw );
    }

//    public static void dialog(final Context context) {
//        AlertDialog.Builder a_builder = new AlertDialog.Builder( context );
//        a_builder.setTitle( "                  Rate our App" );
//        a_builder.setMessage( "Would you like to rate us on Google play store?" )
//                .setCancelable( false )
//                .setPositiveButton( "MAYBE LATER", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        dialog.cancel();
//                    }
//                } )
//                .setNegativeButton( "RATE NOW", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//
//                    }
//                } );
//
//        AlertDialog dialog = a_builder.create();
//        dialog.show();
//    }

    public static void dialog(final Context context) {
        AlertDialog.Builder a_builder = new AlertDialog.Builder( context );
        a_builder.setTitle( "                  Rate our App" );
        a_builder.setMessage( "Would you like to rate us on Google play store?" )
                 .setCancelable( false );
        DialogInterface.OnClickListener dialogClickListener=new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which){
                    case DialogInterface.BUTTON_POSITIVE:
                        Intent i =new Intent( context,RateNw2.class );
                        RateNw2.dialogN( context );
                        break;

                        case DialogInterface.BUTTON_NEGATIVE:
                            break;
                }
            }
            };
        a_builder.setNegativeButton( "MAYBE LATER", dialogClickListener);
        a_builder.setPositiveButton( "RATE NOW",dialogClickListener );
        AlertDialog dialog=a_builder.create();
        dialog.show();
        }
}
