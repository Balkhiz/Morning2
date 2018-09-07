package com.balkhiz.mrng;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;

public class RateUs extends AppCompatActivity {

   static Dialog dialog;
    static int rating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        if (Build.VERSION.SDK_INT >= 19) {
            getWindow().addFlags( WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS );
        } else {
            getWindow().clearFlags( WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS );
        }
        setContentView( R.layout.activity_rate_us );
        }

                public static Dialog getRatingDialog(final Activity activity){
                final AlertDialog.Builder builder = new AlertDialog.Builder( activity );
                rating = -1;
                LayoutInflater inflater = activity.getLayoutInflater();
                View view = inflater.inflate( R.layout.activity_rate_us, null );
                builder.setView( view );
                final TextView text_seekbar = (TextView) view.findViewById( R.id.progress_text );
                final RelativeLayout holder = (RelativeLayout) view.findViewById( R.id.txt_holder );
                final LinearLayout ratingHolder = view.findViewById( R.id.rating_holder );
                final LinearLayout feedBackHolder = view.findViewById( R.id.feedback_holder );
                TextView submitRating = (TextView) view.findViewById( R.id.submit_rating );
                TextView cancelRating = (TextView) view.findViewById( R.id.cancel_rating );
                final TextView submitFeedback = (TextView) view.findViewById( R.id.submit_feedback );
                TextView cancelFeedback = (TextView) view.findViewById( R.id.cancel_feedback );
//                final EditText feedEdit = view.findViewById( R.id.feedback_edit );
               dialog.show();

                submitRating.setOnClickListener( new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
//                        if (rating == -1) {
//                            //Utils.showToast(activity, "Please set rating");
//                        } else {
//                            ratingHolder.setVisibility( View.GONE );
//                            feedBackHolder.setVisibility( View.VISIBLE );
//                        }
                    }
                } );
                cancelRating.setOnClickListener( new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.cancel();
                    }
                } );

                submitFeedback.setOnClickListener( new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
//                        if (checkEditInput( activity, feedEdit )) {
//                            feedEdit.getText().toString();
//                            submitUserRating();
//                            dialog.cancel();
//                        }
                    }
                } );

                cancelFeedback.setOnClickListener( new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.cancel();
                        submitUserRating();
                    }
                } );

                SeekBar seekBar = view.findViewById( R.id.rate_seekbar );
                seekBar.setOnSeekBarChangeListener( new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        rating = progress;
                        text_seekbar.setText( "" + progress );
                        holder.setX( getSeekBarThumbPosX( seekBar ) );
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {
                        holder.setVisibility( View.VISIBLE );
                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {
                    }
                } );
                dialog = builder.create();
                return dialog;
                }


    private static void submitUserRating() {
    }

    public static float getSeekBarThumbPosX(SeekBar seekBar) {
            float posX;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                posX = seekBar.getThumb().getBounds().exactCenterX();
            } else {
                int left = seekBar.getLeft() + seekBar.getPaddingLeft();
                int right = seekBar.getRight() - seekBar.getPaddingRight();
                float width = (float) (seekBar.getProgress() * (right - left)) / seekBar.getMax();
                posX = width + seekBar.getThumbOffset();
            }
            return posX;
        }
        }



