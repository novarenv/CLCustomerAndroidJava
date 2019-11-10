package com.example.clcustomer.di.module;

import android.app.Application;

import com.example.clcustomer.BaseApp;
import com.example.clcustomer.di.scope.PerApplication;

import org.jetbrains.annotations.NotNull;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import kotlin.jvm.internal.Intrinsics;

@Module
public final class ApplicationModule {
    private final BaseApp baseApp;

    @Provides
    @Singleton
    @PerApplication
    @NotNull
    final Application provideApplication() {
        return this.baseApp;
    }

    public ApplicationModule(@NotNull BaseApp baseApp) {
        Intrinsics.checkParameterIsNotNull(baseApp, "baseApp");
        this.baseApp = baseApp;
    }
}
