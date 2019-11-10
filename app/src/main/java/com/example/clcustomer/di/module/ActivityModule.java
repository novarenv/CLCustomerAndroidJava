package com.example.clcustomer.di.module;

import android.app.Activity;

import com.example.clcustomer.ui.main.MainContract.Presenter;
import com.example.clcustomer.ui.main.MainPresenter;

import org.jetbrains.annotations.NotNull;

import dagger.Module;
import dagger.Provides;
import kotlin.jvm.internal.Intrinsics;

@Module
public final class ActivityModule {
    private Activity activity;

    @Provides
    @NotNull
    final Activity provideActivity() {
        return this.activity;
    }

    @Provides
    @NotNull
    final Presenter providePresenter() {
        return new MainPresenter();
    }

    public ActivityModule(@NotNull Activity activity) {
        Intrinsics.checkParameterIsNotNull(activity, "activity");
        this.activity = activity;
    }
}
