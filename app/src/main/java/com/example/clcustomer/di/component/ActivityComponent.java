package com.example.clcustomer.di.component;

import com.example.clcustomer.di.module.ActivityModule;
import com.example.clcustomer.ui.main.MainActivity;

import org.jetbrains.annotations.NotNull;

import dagger.Component;

@Component(
        modules = {ActivityModule.class}
)
public interface ActivityComponent {
    void inject(@NotNull MainActivity mainActivity);
}
