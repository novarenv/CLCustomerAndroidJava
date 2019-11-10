package com.example.clcustomer.di.component;

import com.example.clcustomer.di.module.FragmentModule;
import com.example.clcustomer.ui.dashboard.DashboardFragment;
import com.example.clcustomer.ui.notifications.NotificationsFragment;
import com.example.clcustomer.ui.profile.ProfileFragment;
import com.example.clcustomer.ui.profileDetail.ProfileDetailFragment;
import com.example.clcustomer.ui.progressOrder.ProgressOrderFragment;
import com.example.clcustomer.ui.signIn.SignInFragment;
import com.example.clcustomer.ui.signInUp.SignInUpFragment;

import org.jetbrains.annotations.NotNull;

import dagger.Component;

@Component(
        modules = {FragmentModule.class}
)
public interface FragmentComponent {
    void inject(@NotNull SignInUpFragment signInUpFragment);

    void inject(@NotNull SignInFragment signInFragment);

    void inject(@NotNull ProfileFragment profileFragment);

    void inject(@NotNull ProfileDetailFragment profileDetailFragment);

    void inject(@NotNull DashboardFragment dashboardFragment);

    void inject(@NotNull NotificationsFragment notificationsFragment);

    void inject(@NotNull ProgressOrderFragment progressOrderFragment);
}
