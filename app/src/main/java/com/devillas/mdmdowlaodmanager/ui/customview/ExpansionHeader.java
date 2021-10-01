package com.devillas.mdmdowlaodmanager.ui.customview;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class ExpansionHeader extends FrameLayout {

    private static final String TAG_SUPER = "super";
    private static final String TAG_EXPANDED = "expanded";

    private static final float rotationExpanded = 180f;
    private static final float rotationCollapsed = 0;
    private static final int animationDuration = 300; /* ms */

    private boolean expanded = false;
    private ImageView arrow;
    private TextView textView;


    public ExpansionHeader(@NonNull Context context) {
        super(context);
    }

    public ExpansionHeader(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ExpansionHeader(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void toggleExpand() {
        setExpanded(!expanded, true);
    }

    private void setExpanded(boolean expanded) {
        setExpanded(expanded, true);
    }

    private void setText(CharSequence charSequence){
        textView.setText(charSequence);
    }


    public void setExpanded(boolean expanded, boolean animation) {
        this.expanded = expanded;
        if (arrow == null)
            return;
        if (expanded) {
            if (animation)
                createRotateAnimator(arrow, rotationCollapsed, rotationExpanded).start();
            else
                arrow.setRotation(rotationCollapsed);
        } else {
            if (animation)
                createRotateAnimator(arrow, rotationCollapsed, rotationExpanded).start();
            else
                arrow.setRotation(rotationCollapsed);
        }
    }

    private ObjectAnimator createRotateAnimator(View target, float from, float to) {
        ObjectAnimator animator = ObjectAnimator.ofFloat(target, "rotation", from, to);
        animator.setDuration(animationDuration);
        animator.setInterpolator(new LinearInterpolator());
        return animator;
    }

}
