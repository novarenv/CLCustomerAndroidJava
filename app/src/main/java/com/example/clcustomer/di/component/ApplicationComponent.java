package com.example.clcustomer.di.component;

import com.example.clcustomer.BaseApp;
import com.example.clcustomer.di.module.ApplicationModule;

import org.jetbrains.annotations.NotNull;

import dagger.Component;

@Component(
        modules = {ApplicationModule.class}
)
public interface ApplicationComponent {
    void inject(@NotNull BaseApp application);
}
