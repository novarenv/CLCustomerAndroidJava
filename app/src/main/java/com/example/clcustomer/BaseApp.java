package com.example.clcustomer;

import android.app.Application;

import com.example.clcustomer.di.component.ApplicationComponent;
import com.example.clcustomer.di.component.DaggerApplicationComponent;
import com.example.clcustomer.di.module.ApplicationModule;

import org.jetbrains.annotations.NotNull;

import kotlin.jvm.internal.Intrinsics;

public final class BaseApp extends Application {
    @NotNull
    public ApplicationComponent component;
    @NotNull
    private static BaseApp instance;

    @NotNull
    public final ApplicationComponent getComponent() {

        return this.component;
    }

    public final void setComponent(@NotNull ApplicationComponent var1) {
        Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
        this.component = var1;
    }

    public void onCreate() {
        super.onCreate();
        instance = this;
        this.setup();
    }

    public final void setup() {
        ApplicationComponent var10001 = DaggerApplicationComponent.builder().applicationModule(new ApplicationModule(instance)).build();
        Intrinsics.checkExpressionValueIsNotNull(var10001, "DaggerApplicationCompone…tionModule(this)).build()");
        this.component = var10001;
        ApplicationComponent var10000 = this.component;

        var10000.inject(this);
    }

}
