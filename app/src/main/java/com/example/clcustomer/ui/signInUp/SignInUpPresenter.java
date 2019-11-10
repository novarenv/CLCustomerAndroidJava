package com.example.clcustomer.ui.signInUp;

import com.example.clcustomer.api.ApiServiceInterface;
import com.example.clcustomer.api.ApiServiceInterface.Factory;
import com.example.clcustomer.ui.signInUp.SignInUpContract.Presenter;
import com.example.clcustomer.ui.signInUp.SignInUpContract.View;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import io.reactivex.disposables.CompositeDisposable;
import kotlin.jvm.internal.Intrinsics;

public final class SignInUpPresenter implements Presenter {
    private final CompositeDisposable subscriptions = new CompositeDisposable();
    private final ApiServiceInterface api;
    private View view;

    public void subscribe() {
    }

    public void unsubscribe() {
    }

    public void onLoginClick() {
        View view = this.view;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("view");
        }

        view.showSignInFragment();
    }

    public void attach(@NotNull View view) {
        Intrinsics.checkParameterIsNotNull(view, "view");
        this.view = view;
    }

    public void attach(@Nullable Object view) {

    }

    public SignInUpPresenter() {
        ApiServiceInterface apiServiceInterface = Factory.create();
        Intrinsics.checkExpressionValueIsNotNull(apiServiceInterface, "ApiServiceInterface.Factory.create()");
        this.api = apiServiceInterface;
    }
}
