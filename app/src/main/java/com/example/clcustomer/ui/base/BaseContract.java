package com.example.clcustomer.ui.base;

public interface BaseContract {
    interface Presenter<T> {
        void subscribe();

        void unsubscribe();

        void attach(T view);
    }
    interface View {

    }
}
