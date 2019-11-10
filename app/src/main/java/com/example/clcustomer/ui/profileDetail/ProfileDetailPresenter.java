package com.example.clcustomer.ui.profileDetail;

import com.example.clcustomer.api.ApiServiceInterface;
import com.example.clcustomer.api.ApiServiceInterface.Factory;
import com.example.clcustomer.models.CustomerPerusahaan;
import com.example.clcustomer.ui.profileDetail.ProfileDetailContract.Presenter;
import com.example.clcustomer.ui.profileDetail.ProfileDetailContract.View;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import kotlin.jvm.internal.Intrinsics;

public final class ProfileDetailPresenter implements Presenter {
    private final CompositeDisposable subscriptions = new CompositeDisposable();
    private final ApiServiceInterface api;
    private View view;

    public void subscribe() {
    }

    public void unsubscribe() {
    }

    public void attach(@NotNull View view) {
        Intrinsics.checkParameterIsNotNull(view, "view");
        this.view = view;
    }

    public void attach(@Nullable Object view) {
    }

    public void loadData() {
        Disposable subscribe = this.api.getCustomerPerusahaan()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe();
        this.subscriptions.add(subscribe);
    }

    public void deleteItem(@NotNull CustomerPerusahaan item) {
        Intrinsics.checkParameterIsNotNull(item, "item");
    }

    public ProfileDetailPresenter() {
        ApiServiceInterface apiServiceInterface = Factory.create();
        Intrinsics.checkExpressionValueIsNotNull(apiServiceInterface, "ApiServiceInterface.Factory.create()");
        this.api = apiServiceInterface;
    }
}
