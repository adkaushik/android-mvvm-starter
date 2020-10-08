package com.example.android.listeners;

public interface ClickActionListener {
    int EMPTY_VIEW_CLICK = 1;

    void handleClickAction(int position, int type, Object data);
}
