package com.balkhiz.mrng;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.ToggleButton;

public class NavDrawerH5 extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    ImageButton imageButton;
    TextView textView;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    Button button6;

    ToggleButton toggle;

    Context context;
    String url;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        if (Build.VERSION.SDK_INT >= 19) {
            getWindow().addFlags( WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS );
        } else {
            getWindow().clearFlags( WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS );
        }
        setContentView( R.layout.activity_nav_drawer_h5 );
        Toolbar toolbar = (Toolbar) findViewById( R.id.toolbar );
        setSupportActionBar( toolbar );

        getSupportActionBar().setTitle("             My Morning" );

        imageButton = (ImageButton)findViewById(R.id.image);
        textView = (TextView)findViewById( R.id.textView );
        button2 = (Button)findViewById( R.id.button2 );
        button3 = (Button)findViewById( R.id.button3 );
        button4 = (Button)findViewById( R.id.button4 );
        button5 = (Button)findViewById( R.id.button5 );
        button6 = (Button)findViewById( R.id.button6 );

        button2 = (Button)findViewById( R.id.button2 );
        button2.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent( NavDrawerH5.this,VisionBoardScreen6.class );
                startActivity( i );
            }
        } );

        button3 = (Button)findViewById( R.id.button3 );
        button3.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(NavDrawerH5.this,AffirmationScreen9.class);
                startActivity( i );
            }
        } );

        button4 = (Button)findViewById(R.id.button4);
        button4.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent( NavDrawerH5.this,my.class );
                startActivity( i );
            }
        } );

        button5 = (Button)findViewById( R.id.button5 );
        button5.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent( NavDrawerH5.this,GratitudeScreen11.class );
                startActivity( i );
            }
        } );

        button6 = (Button)findViewById( R.id.button6 );
        button6.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent( NavDrawerH5.this,TaskList.class );
                startActivity( i );
            }
        } );

        DrawerLayout drawer = (DrawerLayout) findViewById( R.id.drawer_layout );
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close );
        drawer.addDrawerListener( toggle );
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById( R.id.nav_view );
        navigationView.setNavigationItemSelectedListener( this );
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById( R.id.drawer_layout );
        if (drawer.isDrawerOpen( GravityCompat.START )) {
            drawer.closeDrawer( GravityCompat.START );
        } else {
            super.onBackPressed();
           // drawer.closeDrawers();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate( R.menu.nav_drawer_h5, menu );
        return false;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected( item );
    }

//    public static void shareVia(Context context, String url) {
//        Intent sharingIntent = new Intent( Intent.ACTION_SEND );
//        sharingIntent.setType( "text/plain" );
//        String shareBody = " your ad text " + url;
//        sharingIntent.putExtra( Intent.EXTRA_SUBJECT, "subject" );
//        sharingIntent.putExtra( Intent.EXTRA_TEXT, shareBody );
//        context.startActivity( Intent.createChooser( sharingIntent, "Share via" ) );
//    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean  onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_settings) {
            Intent i = new Intent( NavDrawerH5.this, Settings.class );
            startActivity( i );
        } else if (id == R.id.nav_AppGuide) {

        } else if (id == R.id.nav_share) {
            Intent i = new Intent( NavDrawerH5.this, Share.class );
            Share.shareVia(NavDrawerH5.this,url );

        } else if (id == R.id.nav_rateus) {
            Intent i = new Intent( NavDrawerH5.this, RateNw.class );
            RateNw.dialog( NavDrawerH5.this );


        } else if (id == R.id.nav_Help) {

        } else if (id == R.id.nav_about) {

        } else if (id == R.id.nav_Logout) {
            Intent i = new Intent( NavDrawerH5.this, Logout.class );
            Logout.dialog(NavDrawerH5.this);
            }

            DrawerLayout drawer = (DrawerLayout) findViewById( R.id.drawer_layout );
            drawer.closeDrawer( GravityCompat.START );
            return true;
    }
}
