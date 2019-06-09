package com.example.udefine;


import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;

/**
 * A simple {@link Fragment} subclass.
 */
@SuppressLint("ValidFragment")
public class DatePickerFragment extends DialogFragment
        implements DatePickerDialog.OnDateSetListener {

    private int year, month, day;
    private boolean set = false;
    private Button mButton;

    @SuppressLint("ValidFragment")
    public DatePickerFragment (View view) {
        mButton = (Button) view;
        String dateString = mButton.getText().toString();
        if (!dateString.equals("Date")) {
            String spl[]=dateString.split("/");
            month = Integer.parseInt(spl[0]) - 1;
            day = Integer.parseInt(spl[1]);
            year = Integer.parseInt(spl[2]);
            set = true;
        }
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the current date as the default date in the picker.
        // TODO: memorize the previous date

        if (set == false) {
            final Calendar c = Calendar.getInstance();
            year = c.get(Calendar.YEAR);
            month = c.get(Calendar.MONTH);
            day = c.get(Calendar.DAY_OF_MONTH);
        }

        // Create a new instance of DatePickerDialog and return it.
        return new DatePickerDialog(getActivity(), this, year, month, day);
    }

    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
        String month_string = Integer.toString(month+1);
        String day_string = Integer.toString(day);
        String year_string = Integer.toString(year);
        String mDate = month_string +
                "/" + day_string + "/" + year_string;
        mButton.setText(mDate);
    }
}
