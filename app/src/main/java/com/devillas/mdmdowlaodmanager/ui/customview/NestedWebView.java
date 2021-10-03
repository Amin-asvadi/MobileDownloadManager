package com.devillas.mdmdowlaodmanager.ui.customview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.webkit.WebView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.NestedScrollingChild2;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.ViewCompat;

public class NestedWebView extends WebView implements NestedScrollingChild2 {
    // The nested scrolling child helper is used throughout the class.
    private NestedScrollingChildHelper nestedScrollingChildHelper;

    // The previous Y position needs to be tracked between motion events.
    private int previousYPosition;

    // The basic constructor.
    public NestedWebView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, android.R.attr.webViewStyle);
    }

    // The intermediate constructor.
    public NestedWebView(@NonNull Context context) {
        this(context, null);
    }

    // The full constructor.
    public NestedWebView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        // Initialize the nested scrolling child helper.
        nestedScrollingChildHelper = new NestedScrollingChildHelper(this);
        // Enable nested scrolling by default.
        nestedScrollingChildHelper.setNestedScrollingEnabled(true);

    }

    @Override
    public boolean onTouchEvent(MotionEvent motionEvent) {
        // Initialize a tracker to return if this motion event is handled.
        boolean motionEventHandled;

        // Run the commands for the given motion event action.

        switch (motionEvent.getAction()) {
            case MotionEvent.ACTION_DOWN:
                //Start nested Scrolling along the vertical axis.
                startNestedScroll(ViewCompat.SCROLL_AXIS_VERTICAL);

                // Save the current Y position.  Action down will not be called again until a new motion starts.
                previousYPosition = (int) motionEvent.getY();

                // Run the default commands.

                motionEventHandled = super.onTouchEvent(motionEvent);
                break;

            case MotionEvent.ACTION_MOVE:
                // Get the current Y position.
                int currentYMotionPosition = (int) motionEvent.getY();

                // Calculate the pre-scroll delta Y.
                int preScrollDeltaY = previousYPosition - currentYMotionPosition;

                // Initialize a variable to track how much of the scroll is consumed.
                int[] consumedScroll = new int[2];

                //Initialize a variable to track the offset in the window.
                int[] offsetInWindow = new int[2];

                //Get the Window Y Position
                int webViewYPosition = getScrollY();

                // Set the scroll delta Y to initially be the same as the pre-scroll delta Y.
                int scrollDeltaY = preScrollDeltaY;
                // Dispatch the nested pre-school.  This scrolls the app bar if it needs it.  `offsetInWindow` will be returned with an updated value.
                if (dispatchNestedPreScroll(0, preScrollDeltaY, consumedScroll, offsetInWindow)) {
                    scrollDeltaY = preScrollDeltaY - consumedScroll[1];
                }

                // Check to see if the WebView is at the top and and the scroll action is downward.
                if ((webViewYPosition == 0) && (scrollDeltaY < 5)) {
                    //Stop nested Scroll
                    stopNestedScroll();
                } else {
                    //Start the nested scroll so that the app bar can scroll off the screen.
                    startNestedScroll(ViewCompat.SCROLL_AXIS_VERTICAL);
                    // Dispatch the nested scroll.  This scrolls the WebView.  The delta Y unconsumed normally controls the swipe refresh layout, but that is handled with the `if` statement above.

                    dispatchNestedScroll(0, scrollDeltaY, 0, 0, offsetInWindow);
                    // Store the current Y position for use in the next action move.
                    previousYPosition = previousYPosition - scrollDeltaY;

                }
                //Run the Default Commands
                stopNestedScroll();

                //Run the Default commands

                motionEventHandled = super.onTouchEvent(motionEvent);
                break;
            default:
                //Stop nested Scroll
                stopNestedScroll();
                //Run the default Command
                motionEventHandled = super.onTouchEvent(motionEvent);
        }

        // Perform a click.  This is required by the Android accessibility guidelines.

        // Return the status of the motion event.
        performClick();

        return motionEventHandled;
    }

    // The Android accessibility guidelines require overriding `performClick()` and calling it from `onTouchEvent()`.
    @Override
    public boolean performClick() {
        return super.performClick();
    }

    // Method from NestedScrollingChild.
    @Override
    public void setNestedScrollingEnabled(boolean status) {
        nestedScrollingChildHelper.setNestedScrollingEnabled(status);
    }

    // Method from NestedScrollingChild.
    @Override
    public boolean isNestedScrollingEnabled() {
        return nestedScrollingChildHelper.isNestedScrollingEnabled();
    }

    // Method from NestedScrollingChild.
    @Override
    public boolean startNestedScroll(int axes) {
        return nestedScrollingChildHelper.startNestedScroll(axes);
    }

    // Method from NestedScrollingChild.
    @Override
    public boolean startNestedScroll(int axes, int type) {
        return nestedScrollingChildHelper.startNestedScroll(axes, type);
    }

    // Method from NestedScrollingChild.
    @Override
    public void stopNestedScroll(int type) {

        nestedScrollingChildHelper.stopNestedScroll(type);
    }
    // Method from NestedScrollingChild.

    @Override
    public boolean hasNestedScrollingParent() {
        return nestedScrollingChildHelper.hasNestedScrollingParent();
    }

    // Method from NestedScrollingChild.
    @Override
    public boolean hasNestedScrollingParent(int type) {
        return nestedScrollingChildHelper.hasNestedScrollingParent(type);
    }

    // Method from NestedScrollingChild.
    @Override
    public boolean dispatchNestedPreScroll(int deltaX, int deltaY, int[] consumed, int[] offsetInWindow) {
        // Dispatch a nested pre-scroll with the specified deltas, which lets a parent to consume some of the scroll if desired.
        return nestedScrollingChildHelper.dispatchNestedPreScroll(deltaX, deltaY, consumed, offsetInWindow);
    }

    // Method from NestedScrollingChild2.
    @Override
    public boolean dispatchNestedPreScroll(int deltaX, int deltaY, int[] consumed, int[] offsetInWindow, int type) {
        // Dispatch a nested pre-scroll with the specified deltas for the given type of input which caused the scroll event, which lets a parent to consume some of the scroll if desired.
        return nestedScrollingChildHelper.dispatchNestedPreScroll(deltaX, deltaY, consumed, offsetInWindow, type);
    }


    // Method from NestedScrollingChild.
    @Override
    public boolean dispatchNestedScroll(int deltaXConsumed, int deltaYConsumed, int deltaXUnconsumed, int deltaYUnconsumed, int[] offsetInWindow) {
        // Dispatch a nested scroll with the specified deltas.
        return nestedScrollingChildHelper.dispatchNestedScroll(deltaXConsumed, deltaYConsumed, deltaXUnconsumed, deltaYUnconsumed, offsetInWindow);
    }

    // Method from NestedScrollingChild2.
    @Override
    public boolean dispatchNestedScroll(int deltaXConsumed, int deltaYConsumed, int deltaXUnconsumed, int deltaYUnconsumed, int[] offsetInWindow, int type) {
        // Dispatch a nested scroll with the specified deltas for the given type of input which caused the scroll event.
        return nestedScrollingChildHelper.dispatchNestedScroll(deltaXConsumed, deltaYConsumed, deltaXUnconsumed, deltaYUnconsumed, offsetInWindow, type);
    }

    // Method from NestedScrollingChild.
    @Override
    public boolean dispatchNestedPreFling(float velocityX, float velocityY) {
        // Dispatch a nested pre-fling with the specified velocity, which lets a parent consume the fling if desired.
        return nestedScrollingChildHelper.dispatchNestedPreFling(velocityX, velocityY);
    }

    // Method from NestedScrollingChild.
    @Override
    public boolean dispatchNestedFling(float velocityX, float velocityY, boolean consumed) {
        // Dispatch a nested fling with the specified velocity.
        return nestedScrollingChildHelper.dispatchNestedFling(velocityX, velocityY, consumed);
    }

}
