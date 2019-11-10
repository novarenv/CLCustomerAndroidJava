package com.example.clcustomer.ui.signIn;

import com.example.clcustomer.models.CustomerPerusahaan;
import com.example.clcustomer.ui.base.BaseContract;

import dagger.BindsOptionalOf;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

public interface SignInContract {
    interface View extends BaseContract.View {
        void loadDataSuccess(@NotNull CustomerPerusahaan customerPerusahaan);

        void showErrorMessage(@NotNull String error);

        void showDashboardFragment();
    }

    interface Presenter extends BaseContract.Presenter {
        void loadData();

        void loginApiCall(@NotNull String userId, @NotNull String userPassword);

        void onLoginClick();

        void attach(@NotNull SignInContract.View view);
    }
}
