package com.example.clcustomer.ui.profileDetail;

import com.example.clcustomer.models.CustomerPerusahaan;

import org.jetbrains.annotations.NotNull;

public interface ProfileDetailContract {
    interface View extends com.example.clcustomer.ui.base.BaseContract.View {
    }

    interface Presenter extends com.example.clcustomer.ui.base.BaseContract.Presenter {
        void loadData();

        void deleteItem(@NotNull CustomerPerusahaan var1);

        void attach(ProfileDetailContract.View view);
    }
}
