package com.example.clcustomer.ui.progressOrder;

import com.example.clcustomer.api.ApiServiceInterface;
import com.example.clcustomer.api.ApiServiceInterface.Factory;
import com.example.clcustomer.ui.progressOrder.ProgressOrderContract.Presenter;
import com.example.clcustomer.ui.progressOrder.ProgressOrderContract.View;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ProgressOrderPresenter implements Presenter {
    private final CompositeDisposable subscriptions = new CompositeDisposable();
    private final ApiServiceInterface api;
    private View view;

    public void loadData() {
    }

    public void loadDataAll() {
    }

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

    public ProgressOrderPresenter() {
        ApiServiceInterface apiServiceInterface = Factory.create();
        Intrinsics.checkExpressionValueIsNotNull(apiServiceInterface, "ApiServiceInterface.Factory.create()");
        this.api = apiServiceInterface;
    }
}
