package com.balkhiz.mrng;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ReminderScreen10a extends AppCompatActivity {

    int preSelectedIndex = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (Build.VERSION.SDK_INT >= 19) {
            getWindow().addFlags( WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS );
        } else {
            getWindow().clearFlags( WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS );
        }
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_reminder_screen10a );

        ListView listView = (ListView) findViewById(R.id.listview);


        final List<UserModel> users = new ArrayList<>();

        users.add(new UserModel(false, "Track 1"));
        users.add(new UserModel(false, "Track 2"));
        users.add(new UserModel(false, "Track 3"));
        users.add(new UserModel(false, "Track 4"));
        users.add(new UserModel(false, "Track 5"));
        users.add(new UserModel(false, "Track 6"));



        final CustomAdapter adapter = new CustomAdapter(this, users);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override

            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                UserModel model = users.get(i); //changed it to model because viewers will confused about it
                model.setSelected(true);
                users.set(i, model);
                if (preSelectedIndex > -1){
                    UserModel preRecord = users.get(preSelectedIndex);
                    preRecord.setSelected(false);
                    users.set(preSelectedIndex, preRecord);
                }


                preSelectedIndex = i;

                //now update adapter so we are going to make a update method in adapter

                adapter.updateRecords(users);
                //now declare adapter final to access in inner method


            }

        });


    }
}


