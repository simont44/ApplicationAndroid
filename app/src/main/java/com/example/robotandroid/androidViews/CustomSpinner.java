package com.example.robotandroid.androidViews;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Spinner;

public class CustomSpinner extends androidx.appcompat.widget.AppCompatSpinner {
    OnItemSelectedListener listener;

    public CustomSpinner(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void setSelection(int position) {
        super.setSelection(position);
        if (listener != null)
            listener.onItemSelected(null, null, position, 0);
    }

    @Override
    public void setOnItemSelectedListener(
            OnItemSelectedListener listener) {
        this.listener = listener;
    }
}