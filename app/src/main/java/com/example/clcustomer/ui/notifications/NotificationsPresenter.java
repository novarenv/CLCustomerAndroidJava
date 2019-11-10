package com.example.clcustomer.ui.notifications;

import com.example.clcustomer.api.ApiServiceInterface;
import com.example.clcustomer.api.ApiServiceInterface.Factory;
import com.example.clcustomer.models.CustomerPerusahaan;
import com.example.clcustomer.ui.notifications.NotificationsContract.View;

import org.jetbrains.annotations.NotNull;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import kotlin.NotImplementedError;
import kotlin.jvm.internal.Intrinsics;

public final class NotificationsPresenter implements NotificationsContract.Presenter {
    private final CompositeDisposable subscriptions = new CompositeDisposable();
    private final ApiServiceInterface api;
    private View view;

    public void subscribe() {
        String var1 = "not implemented";
        try {
            throw new NotImplementedError("An operation is not implemented: " + var1);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    public void unsubscribe() {
        String var1 = "not implemented";
        boolean var2 = false;
        try {
            throw new NotImplementedError("An operation is not implemented: " + var1);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    @Override
    public void attach(Object view) {

    }

    @Override
    public void attach(@NotNull View view) {
        Intrinsics.checkParameterIsNotNull(view, "view");
        this.view = view;
    }

    public void loadData() {
        Disposable subscribe = this.api.getCustomerPerusahaan().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe();
        this.subscriptions.add(subscribe);
    }

    public void deleteItem(@NotNull CustomerPerusahaan item) {
        Intrinsics.checkParameterIsNotNull(item, "item");
    }

    public NotificationsPresenter() {
        ApiServiceInterface var10001 = Factory.create();
        Intrinsics.checkExpressionValueIsNotNull(var10001, "ApiServiceInterface.Factory.create()");
        this.api = var10001;
    }
}
