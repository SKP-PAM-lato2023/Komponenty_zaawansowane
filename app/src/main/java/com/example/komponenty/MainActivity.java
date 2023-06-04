package com.example.komponenty;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import android.support.v4.app.*;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TimePicker timePicker = findViewById(R.id.timePicker);
        timePicker.setIs24HourView(true);

        Button buttonTime = findViewById(R.id.buttonTime);
        buttonTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int godzina = timePicker.getHour();
                int minuta = timePicker.getMinute();
                TextView textTime = findViewById(R.id.textTime);
                textTime.setText(String.format("Wybrano czas %d:%d", godzina, minuta));
            }
        });

        DatePicker datePicker = findViewById(R.id.calendar);
        Button buttonDate = findViewById(R.id.buttonDate);
        buttonDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int dzien = datePicker.getDayOfMonth();
                int miesiac = datePicker.getMonth();
                int rok = datePicker.getYear();

                Calendar calendar = Calendar.getInstance();
                calendar.set(dzien, miesiac, rok);
                int dt = calendar.get(Calendar.DAY_OF_WEEK);
                String[] dniTygodnia = { "pn", "wt", "śr", "cz", "pt", "so", "nd"};

                String date = String.format("Wybrano datę %s %s.%s.%s", dniTygodnia[dt-1],dzien,miesiac+1,rok );
                TextView textView = findViewById(R.id.textDate);
                textView.setText(date);
            }
        });

        Button buttonFragment = findViewById(R.id.buttonTime2);
        buttonFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment dialogFragment = new TimePickerFragment();
                dialogFragment.show(getSupportFragmentManager(), "timePicker");
            }
        });
    }
}