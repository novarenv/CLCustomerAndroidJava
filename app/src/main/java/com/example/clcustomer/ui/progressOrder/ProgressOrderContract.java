package com.example.clcustomer.ui.progressOrder;

import com.example.clcustomer.models.CustomerPerusahaan;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface ProgressOrderContract {
    interface View extends com.example.clcustomer.ui.base.BaseContract.View {
        void loadDataSuccess(@NotNull CustomerPerusahaan var1);

        void loadDataAllSuccess(@NotNull List var1);

        void showErrorMessage(@NotNull String var1);
    }

    interface Presenter extends com.example.clcustomer.ui.base.BaseContract.Presenter {
        void loadData();

        void loadDataAll();

        void attach(ProgressOrderContract.View view);
    }
}
