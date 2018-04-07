package com.example.dodo.popularmoviesfinal.Settings;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.example.dodo.popularmoviesfinal.R;


public class Settings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        /*
         * Normally, calling setDisplayHomeAsUpEnabled(true) (we do so in onCreate here) as well as
         * declaring the parent activity in the AndroidManifest is all that is required to get the
         * up button working properly. However, in this case, we want to navigate to the previous
         * screen the user came from when the up button was clicked, rather than a single
         * designated Activity in the Manifest.
         *
         * We use the up button's ID (android.R.id.home) to listen for when the up button is
         * clicked and then call onBackPressed to navigate to the previous Activity when this
         * happens.
         */
        int id = item.getItemId();
        if (id == android.R.id.home) {
            onBackPressed();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}





//Using this way will default the preference file to be stored as /data/data/com.package.name/shared_prefs/com.package.name_preferences.xml.
//  SharedPreferences.Editor editor = mSettings.edit();
//  editor.apply();

//https://developer.android.com/guide/topics/resources/menu-resource.html
//https://classroom.udacity.com/courses/ud851-emea/lessons/1392b674-18b6-4636-b36b-da7d37a319e3/concepts/b3cbbd1c-7377-40a6-9a00-a7c5a9e0c004
//    https://classroom.udacity.com/nanodegrees/nd801/parts/9bb83157-0407-47dc-b0c4-c3d4d7dc66df/modules/47a044f4-4324-4e51-8960-151737705a06/lessons/e5d74e43-743c-455e-9a70-7545a2da9783/concepts/b14b510c-1fa4-415f-825e-445aed179c2b