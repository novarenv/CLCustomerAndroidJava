package com.example.clcustomer.ui.signInUp;

import com.example.clcustomer.ui.base.BaseContract;

import org.jetbrains.annotations.NotNull;

public interface SignInUpContract {
    interface View extends BaseContract.View {
        void showErrorMessage(@NotNull String var1);

        void showSignInFragment();
    }

    interface Presenter extends BaseContract.Presenter {
        void onLoginClick();

        void attach(SignInUpContract.View view);
    }
}
