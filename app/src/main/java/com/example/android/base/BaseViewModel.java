package com.example.android.base;

import androidx.databinding.Observable;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableList;
import androidx.lifecycle.ViewModel;

public abstract class BaseViewModel<T> extends ViewModel {
    public ObservableList<T> items =  new ObservableArrayList<>();

    protected final ObservableBoolean loading = new ObservableBoolean(false);
    protected final ObservableBoolean isEmpty = new ObservableBoolean(false);

    public ObservableList<T> getItems() {
        return items;
    }

}
