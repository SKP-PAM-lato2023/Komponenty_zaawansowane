package com.example.komponenty;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import java.util.Calendar;

public class TimePickerFragment extends DialogFragment {

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        final Calendar c = Calendar.getInstance();
        int godzina = c.get(Calendar.HOUR_OF_DAY);
        int minuta = c.get(Calendar.MINUTE);

        return new TimePickerDialog(getActivity(), this::onTimeSet, godzina, minuta, true);
    }

    public void onTimeSet(TimePicker view, int hourOfDay, int minute){
        Toast.makeText(getActivity(), hourOfDay +":"+minute, Toast.LENGTH_SHORT).show();
    }
}
