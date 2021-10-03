package com.devillas.mdmdowlaodmanager.ui.customview;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.textfield.TextInputEditText;

public class FixHintInputEditText extends TextInputEditText {
    public FixHintInputEditText(@NonNull Context context) {
        super(context);
    }

    public FixHintInputEditText(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public FixHintInputEditText(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public int getAutofillType() {
        if (Build.VERSION.SDK_INT == Build.VERSION_CODES.O)
            return AUTOFILL_TYPE_NONE;
        else
            return super.getAutofillType();
    }


}
