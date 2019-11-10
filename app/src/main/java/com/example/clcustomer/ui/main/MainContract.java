package com.example.clcustomer.ui.main;

public interface MainContract {
    interface View extends com.example.clcustomer.ui.base.BaseContract.View {
        void showSignInUpFragment();
    }

    interface Presenter extends com.example.clcustomer.ui.base.BaseContract.Presenter {
        void attach(MainContract.View view);
    }
}
