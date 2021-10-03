package com.devillas.mdmdowlaodmanager.ui.customview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.util.zip.GZIPInputStream;

public class EmptyRecyclerView extends RecyclerView {

    private View emptyView;
    final private AdapterDataObserver observer = new AdapterDataObserver() {
        @Override
        public void onChanged() {
            checkEmpty();
        }

        @Override
        public void onItemRangeInserted(int positionStart, int itemCount) {
     checkEmpty();
        }

        @Override
        public void onItemRangeRemoved(int positionStart, int itemCount) {
         checkEmpty();
        }

    };

    public EmptyRecyclerView(@NonNull Context context) {
        super(context);
    }

    public EmptyRecyclerView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public EmptyRecyclerView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    void checkEmpty() {
        if (emptyView != null && getAdapter() != null) {
            boolean isEmptyViewVisible = getAdapter().getItemCount() == 0;
            emptyView.setVisibility((isEmptyViewVisible ?VISIBLE:GONE));
            setVisibility((isEmptyViewVisible ? GONE:VISIBLE));
        }

    }

    @Override
    public void setAdapter(@Nullable Adapter adapter) {
        Adapter oldAdapter= getAdapter();
        if (oldAdapter != null)
            oldAdapter.unregisterAdapterDataObserver(observer);
        super.setAdapter(adapter);

        if (adapter != null)
            adapter.registerAdapterDataObserver(observer);

        checkEmpty();
    }
        public void setEmptyView(View emptyView){
        this.emptyView = emptyView;
        checkEmpty();
        }
}
