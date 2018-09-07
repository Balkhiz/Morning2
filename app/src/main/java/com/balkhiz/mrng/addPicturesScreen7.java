package com.balkhiz.mrng;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Gallery;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.util.List;

public class addPicturesScreen7 extends AppCompatActivity {

    private int REQUEST_CODE = 1;

    int PICK_IMAGE_MULTIPLE = 1;
    String imageEncoded;
    List <String> imagesEncodedList;

    ImageView imageView;
    Gallery galleryPhoto;

    final int GALLERY_REQUEST=22131;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        if (Build.VERSION.SDK_INT >= 19) {
            getWindow().addFlags( WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS );
        } else {
            getWindow().clearFlags( WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS );
        }
        setContentView( R.layout.activity_add_pictures );

        Typeface myTypeface = Typeface.createFromAsset( getAssets(), "Lato-Regular.ttf" );
        TextView myTextView = (TextView) findViewById( R.id.textView );
        myTextView.setTypeface( myTypeface );

        Typeface myTypeface2 = Typeface.createFromAsset( getAssets(), "Lato-Light.ttf" );
        TextView myTextView2 = (TextView) findViewById( R.id.textView2 );
        myTextView2.setTypeface( myTypeface2 );

        Typeface myTypeface3 = Typeface.createFromAsset( getAssets(), "Lato-Light.ttf" );
        TextView myTextView3 = (TextView) findViewById( R.id.textView3 );
        myTextView3.setTypeface( myTypeface3 );

        //  ImageView imageView = (ImageView)findViewById( R.id.imageView );

        ImageButton imageButton = (ImageButton) findViewById( R.id.image );
        imageButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                Intent i = new Intent( addPicturesScreen7.this, VisionBoardScreen6.class );
                startActivity( i );

            }
        } );

        ImageButton im=(ImageButton)findViewById( R.id.image3 );
        im.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent( addPicturesScreen7.this,VisionBoardScreen8.class );
                startActivity(i);
            }
        } );


        ImageButton imageButton3 = (ImageButton) findViewById( R.id.imageButton3 );
        imageButton3.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent();
                intent.setType( "image/*" );
                intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
                intent.setAction( Intent.ACTION_GET_CONTENT );
                startActivityForResult( Intent.createChooser( intent, "Select Picture" ), REQUEST_CODE );
                }
        } );
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult( requestCode, resultCode, data );
        if (requestCode == REQUEST_CODE && requestCode == RESULT_OK && data != null && data.getData() != null) {
            Uri uri = data.getData();
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap( getContentResolver(), uri );
                // imageView.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
