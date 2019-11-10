package com.example.clcustomer.ui.signIn;

import android.annotation.SuppressLint;
import com.example.clcustomer.api.ApiServiceInterface;
import com.example.clcustomer.api.ApiServiceInterface.Factory;
import com.example.clcustomer.models.LoginPostData;
import com.example.clcustomer.models.LoginResponse;
import com.example.clcustomer.ui.signIn.SignInContract.Presenter;
import com.example.clcustomer.ui.signIn.SignInContract.View;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class SignInPresenter implements Presenter {
    private final CompositeDisposable subscriptions = new CompositeDisposable();
    private final ApiServiceInterface api;
    private View view;

    public void subscribe() {
    }

    public void unsubscribe() {
    }

    public void loadData() {

    }

    @SuppressLint({"CheckResult"})
    public void loginApiCall(@NotNull String userID, @NotNull String userPassword) {
        Intrinsics.checkParameterIsNotNull(userID, "userID");
        Intrinsics.checkParameterIsNotNull(userPassword, "userPassword");
        Disposable subscribe = this.api.doLogin(new LoginPostData(userID, userPassword))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe();
        this.subscriptions.add(subscribe);
    }

    public void onLoginClick() {
        View view = this.view;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("view");
        }

        view.showDashboardFragment();
    }

    public void attach(@NotNull View view) {
        Intrinsics.checkParameterIsNotNull(view, "view");
        this.view = view;
    }

    public void attach(@Nullable Object view) {
    }

    public SignInPresenter() {
        ApiServiceInterface factory = Factory.create();
        Intrinsics.checkExpressionValueIsNotNull(factory, "ApiServiceInterface.Factory.create()");
        this.api = factory;
    }

}
