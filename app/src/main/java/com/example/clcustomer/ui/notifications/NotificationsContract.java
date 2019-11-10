package com.example.clcustomer.ui.notifications;

import com.example.clcustomer.models.CustomerPerusahaan;
import com.example.clcustomer.ui.base.BaseContract;

import org.jetbrains.annotations.NotNull;

public interface NotificationsContract {
    interface View extends BaseContract.View {

    }

    interface Presenter extends BaseContract.Presenter {
        void loadData();

        void deleteItem(@NotNull CustomerPerusahaan var1);

        void attach(NotificationsContract.View view);
    }
}
