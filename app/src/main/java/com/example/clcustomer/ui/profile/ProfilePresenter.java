package com.example.clcustomer.ui.profile;

import com.example.clcustomer.api.ApiServiceInterface;
import com.example.clcustomer.api.ApiServiceInterface.Factory;
import com.example.clcustomer.models.CustomerPerusahaan;
import com.example.clcustomer.ui.profile.ProfileContract.Presenter;
import com.example.clcustomer.ui.profile.ProfileContract.View;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import kotlin.jvm.internal.Intrinsics;

public final class ProfilePresenter implements Presenter {
    private final CompositeDisposable subscriptions = new CompositeDisposable();
    private final ApiServiceInterface api;
    private View view;
    private CustomerPerusahaan customerPerusahaan;

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

    public void onProfileDetailClick() {
        view.showProfileDetail();
    }

    public void loadData() {
        Disposable subscribe = this.api.getCustomerPerusahaan(10)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        customerPerusahaan -> view.loadDataSuccess(customerPerusahaan),
                        error -> view.showErrorMessage(Objects.requireNonNull(error.getLocalizedMessage())));

        this.subscriptions.add(subscribe);
    }

    public void deleteItem(@NotNull CustomerPerusahaan item) {
        Intrinsics.checkParameterIsNotNull(item, "item");
    }

    public ProfilePresenter() {
        ApiServiceInterface factory = Factory.create();
        Intrinsics.checkExpressionValueIsNotNull(factory, "ApiServiceInterface.Factory.create()");
        this.api = factory;
    }

}
