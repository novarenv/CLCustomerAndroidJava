package com.example.clcustomer.ui.dashboard;

import com.example.clcustomer.api.ApiServiceInterface;
import com.example.clcustomer.api.ApiServiceInterface.Factory;
import com.example.clcustomer.models.CustomerPerusahaan;
import com.example.clcustomer.ui.dashboard.DashboardContract.Presenter;
import com.example.clcustomer.ui.dashboard.DashboardContract.View;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import kotlin.jvm.internal.Intrinsics;

public final class DashboardPresenter implements Presenter {
    private final CompositeDisposable subscriptions = new CompositeDisposable();
    private final ApiServiceInterface api;
    private View view;
    private CustomerPerusahaan list;
    private List<CustomerPerusahaan> customerPerusahaanList;

    public void subscribe() {
    }

    public void unsubscribe() {
        this.subscriptions.clear();
    }

    public void attach(@NotNull View view) {
        Intrinsics.checkParameterIsNotNull(view, "view");
        this.view = view;
    }

    public void attach(@Nullable Object view) {
    }

    public void loadData() {
        Disposable subscribe = this.api.getCustomerPerusahaan(10)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(list ->
                                view.loadDataSuccess(list),
                        error ->
                                view.showErrorMessage("Tunggu data plz")
                );
        this.subscriptions.add(subscribe);
    }

    public void loadDataAll() {
        Disposable subscribe = this.api.getCustomerPerusahaan()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(customerPerusahaanList ->
                                view.loadDataAllSuccess(customerPerusahaanList)
                        , error ->
                                view.showErrorMessage("Tunggu data plz")
                );
        this.subscriptions.add(subscribe);
    }

    public void onNotificationsClick() {
        View view = this.view;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("view");
        }

        view.showNotificationsFragment();
    }

    public void onProfileClick() {
        View view = this.view;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("view");
        }

        view.showProfileFragment();
    }

    public DashboardPresenter() {
        ApiServiceInterface apiServiceInterface = Factory.create();
        Intrinsics.checkExpressionValueIsNotNull(apiServiceInterface, "ApiServiceInterface.Factory.create()");
        this.api = apiServiceInterface;
    }
}
