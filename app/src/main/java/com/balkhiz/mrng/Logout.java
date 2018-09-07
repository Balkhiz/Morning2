package com.balkhiz.mrng;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

public class Logout extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        if (Build.VERSION.SDK_INT >= 19) {
            getWindow().addFlags( WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS );
        } else {
            getWindow().clearFlags( WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS );
        }
        setContentView( R.layout.activity_logout );
    }

//    public static void dialog(final Context context) {
//        AlertDialog.Builder a_builder = new AlertDialog.Builder( context );
//        a_builder.setMessage( "Are you sure you want to logout?" )
//                .setCancelable( false )
//                .setPositiveButton( "Yes", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//
//                        }
//                } )
//                .setNegativeButton( "No", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        dialog.cancel();
//                    }
//                } );
//
//        AlertDialog dialog = a_builder.create();
//        dialog.show();
//    }

    public static void dialog(final Context context) {
        AlertDialog.Builder a_builder = new AlertDialog.Builder( context );
        a_builder.setMessage( "Are you sure you want to logout?" )
                .setCancelable( false );
        DialogInterface.OnClickListener dialogClickListener=new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which){
                    case DialogInterface.BUTTON_POSITIVE:
                        Intent i =new Intent( context,LoginScreen2.class );
                        context.startActivity( i );
                        break;

                    case DialogInterface.BUTTON_NEGATIVE:
                        Intent i2=new Intent(context,NavDrawerH5.class);
                        context.startActivity( i2 );
                        break;
                }
            }
        };
        a_builder.setNegativeButton( "No", dialogClickListener);
        a_builder.setPositiveButton( "Yes",dialogClickListener );
        AlertDialog dialog=a_builder.create();
        dialog.show();
    }
}






