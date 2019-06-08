package com.example.udefine;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class NewNote extends AppCompatActivity {

    private Spinner mSpinner;
    private String mDate, mTime;
    private Button mDateButton, mTimeButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_note);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mDateButton = findViewById(R.id.dateButton);
        mTimeButton = findViewById(R.id.timeButton);

        // tag spinner settings
        final String[] tag_colors = {
                "Select Tag", "#00ff00", "#ffff00", "#ff751a", "#ff0000",
                "#993399", "#6666ff"};
        mSpinner = findViewById(R.id.tag_spinner);

        ArrayList<tagItemStateVO> listVOs = new ArrayList<>();

        for (int i = 0; i < tag_colors.length; i++) {
            tagItemStateVO stateVO = new tagItemStateVO();
            stateVO.setTitle(tag_colors[i]);
            stateVO.setSelected(false);
            listVOs.add(stateVO);
        }
        tagListAdapter myAdapter = new tagListAdapter(NewNote.this, 0,
                listVOs);
        mSpinner.setAdapter(myAdapter);

        /*
         *  1. load selected layout
         *     - load default layout
         *     - TextView - title
         *     - Widget
         *  2. buttons
         *     - save
         *     - cancel
         */

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_new_note, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = new Intent(NewNote.this, LayoutSelection.class);
        startActivity(intent);

        return super.onOptionsItemSelected(item);
    }

    public void processDatePickerResult(int year, int month, int day) {
        String month_string = Integer.toString(month+1);
        String day_string = Integer.toString(day);
        String year_string = Integer.toString(year);
        mDate = month_string +
                "/" + day_string + "/" + year_string;
        mDateButton.setText(mDate);
    }

    public void processTimePickerResult(int hour, int minute) {
        String hour_string = Integer.toString(hour);
        String minute_string = Integer.toString(minute);
        mTime = hour_string + ":" + minute_string;
        mTimeButton.setText(mTime);
    }

    public void datePicker(View view) {
        DialogFragment newFragment = new DatePickerFragment(mDate);
        newFragment.show(getSupportFragmentManager(),"datePicker");
    }

    public void timePicker(View view) {
        DialogFragment newFragment = new TimePickerFragment(mTime);
        newFragment.show(getSupportFragmentManager(),"timePicker");
    }


}
