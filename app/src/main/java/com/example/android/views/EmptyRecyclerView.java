package com.example.android.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import com.cooltechworks.views.shimmer.ShimmerAdapter;
import com.cooltechworks.views.shimmer.ShimmerRecyclerView;
import com.example.android.R;

public class EmptyRecyclerView extends ShimmerRecyclerView {
    private View mEmptyView;
    private int color = -1;

    public EmptyRecyclerView(Context context) {
        super(context);
        init();
    }

    public EmptyRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public EmptyRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    void init() {
        color = ContextCompat.getColor(getContext(), R.color.shimmerColor);
    }

    private final AdapterDataObserver observer = new AdapterDataObserver() {
        @Override
        public void onChanged() {
            updateEmptyState();
        }

        @Override
        public void onItemRangeInserted(int positionStart, int itemCount) {
            updateEmptyState();
        }

        @Override
        public void onItemRangeRemoved(int positionStart, int itemCount) {
            updateEmptyState();
        }
    };

    public void setEmptyView(View emptyView) {
        this.mEmptyView = emptyView;
    }

    @Override
    public void setAdapter(Adapter adapter) {
        final Adapter oldAdapter = getAdapter();
        super.setAdapter(adapter);

        // Unregister observer only if the current adapter is not shimmeradapter, as
        // shimmer adapter does not depend on the recyclerview's items
        if (oldAdapter != null && !(oldAdapter instanceof ShimmerAdapter)) {
            oldAdapter.unregisterAdapterDataObserver(observer);
        }

        if (adapter != null && adapter instanceof ShimmerAdapter) {
            ((ShimmerAdapter) adapter).setShimmerColor(color);
        }

        // Register observer only if the current adapter is not shimmeradapter, as
        // shimmer adapter does not depend on the recyclerview's items
        if (adapter != null && !(adapter instanceof ShimmerAdapter)) {
            adapter.registerAdapterDataObserver(observer);
        }
    }

    private void updateEmptyState() {
        if (mEmptyView != null) {
            final Adapter adapter = getAdapter();
            if (adapter != null) {
                final boolean shouldShowEmptyState = adapter.getItemCount() == 0;
                // If adapter items count is 0 show empty view
                mEmptyView.setVisibility(shouldShowEmptyState ? View.VISIBLE : View.INVISIBLE);
                // Hide recyclerview
                setVisibility(shouldShowEmptyState ? View.INVISIBLE : View.VISIBLE);

            } else {
                // Show empty state if no adapter is set
                mEmptyView.setVisibility(View.VISIBLE);
                // Hide recyclerview
                setVisibility(View.INVISIBLE);
            }
        } else {
            // Empty view is not set.
            setVisibility(View.VISIBLE);
        }
    }
}
