package com.example.clcustomer.ui.dashboard;

import com.example.clcustomer.models.CustomerPerusahaan;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface DashboardContract {
    interface View extends com.example.clcustomer.ui.base.BaseContract.View {
        void loadDataSuccess(@NotNull CustomerPerusahaan customerPerusahaan);

        void loadDataAllSuccess(@NotNull List list);

        void showErrorMessage(@NotNull String error);

        void showNotificationsFragment();

        void showProfileFragment();
    }

    interface Presenter extends com.example.clcustomer.ui.base.BaseContract.Presenter {
        void loadData();

        void loadDataAll();

        void onNotificationsClick();

        void onProfileClick();

        void attach(DashboardContract.View view);
    }
}
