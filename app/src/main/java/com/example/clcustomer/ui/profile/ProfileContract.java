package com.example.clcustomer.ui.profile;

import com.example.clcustomer.models.CustomerPerusahaan;
import com.example.clcustomer.ui.base.BaseContract;
import org.jetbrains.annotations.NotNull;

public interface ProfileContract {
    interface View extends BaseContract.View {
        void loadDataSuccess(@NotNull CustomerPerusahaan customerPerusahaan);

        void showErrorMessage(@NotNull String error);

        void showProfileDetail();
    }

    interface Presenter extends BaseContract.Presenter {
        void loadData();

        void deleteItem(@NotNull CustomerPerusahaan item);

        void attach(ProfileContract.View view);

        void onProfileDetailClick();
    }
}
