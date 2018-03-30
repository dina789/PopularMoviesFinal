package com.example.dodo.popularmoviesfinal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;

public class MainActivity extends AppCompatActivity {


    private RecyclerView recyclerView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
 /*
     * Using findViewById, we get a reference to our RecyclerView from xml. This allows us to
         * do things like set the adapter of the RecyclerView and toggle the visibility.
         */

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);




        recyclerView.setHasFixedSize(true);


    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.setting_menu, menu);
        //set menu item title based on sort key





 return super.onCreateOptionsMenu(menu);


}}


/*
https://stackoverflow.com/questions/309424/read-convert-an-inputstream-to-a-string
for setting and menu:
https://google-developer-training.gitbooks.io/android-developer-fundamentals-course-practicals/content/en/Unit%204/92_p_adding_settings_to_an_app.html
https://google-developer-training.gitbooks.io/android-developer-fundamentals-course-practicals/content/en/Unit%202/42_p_use_an_options_menu_and_radio_buttons.htmlhttps://developer.android.com/guide/topics/ui/menus.html#groups
https://material.io/guidelines/patterns/settings.html#settings-usage







*/