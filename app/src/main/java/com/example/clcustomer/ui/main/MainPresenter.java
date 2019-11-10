package com.example.clcustomer.ui.main;

import com.example.clcustomer.ui.main.MainContract.Presenter;
import com.example.clcustomer.ui.main.MainContract.View;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import io.reactivex.disposables.CompositeDisposable;
import kotlin.jvm.internal.Intrinsics;

public final class MainPresenter implements Presenter {
    private final CompositeDisposable subscriptions = new CompositeDisposable();
    private View view;

    public void subscribe() {
    }

    public void unsubscribe() {
        this.subscriptions.clear();
    }

    public void attach(@NotNull View view) {
        Intrinsics.checkParameterIsNotNull(view, "view");
        this.view = view;
        view.showSignInUpFragment();
    }

    public void attach(@Nullable Object view) {

    }
}
