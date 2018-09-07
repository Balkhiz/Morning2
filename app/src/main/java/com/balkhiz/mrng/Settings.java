package com.balkhiz.mrng;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class Settings extends AppCompatActivity {

    TextView title;
    Spinner fonts;
    SharedPreferences sharedPreferences;
    public static final String default_value = "12";
    String ret;
    String fonts_array[] = {"12", "14", "16", "18", "20"};
    String temp = "";
    int n = fonts_array.length, pos = 0;

    ImageButton image;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        if (Build.VERSION.SDK_INT >= 19) {
            getWindow().addFlags( WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS );
        } else {
            getWindow().clearFlags( WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS );
        }
        setContentView( R.layout.activity_settings );

        Spinner spinner=(Spinner)findViewById( R.id.spinner );
       final ArrayList<String> list=new ArrayList <>(  );
        list.add("12");
        list.add("14");
        list.add("16");
        list.add("18");
        list.add("20");
        ArrayAdapter<String> adapter=new ArrayAdapter <String>(this,android.R.layout.simple_spinner_dropdown_item,list  );
        spinner.setAdapter( adapter );

        spinner.setOnItemSelectedListener( new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView <?> parent, View view, int position, long id) {

                }

            @Override
            public void onNothingSelected(AdapterView <?> adapterView) {


            }
        });

        image = (ImageButton)findViewById( R.id.image );
        image.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Intent i = new Intent( Settings.this, NavDrawerH5.class );
                startActivity( i );
                }
        } );
        }

    }

