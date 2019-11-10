package com.example.clcustomer.di.module;

import com.example.clcustomer.api.ApiServiceInterface;
import com.example.clcustomer.api.ApiServiceInterface.Factory;
import com.example.clcustomer.ui.dashboard.DashboardContract.Presenter;
import com.example.clcustomer.ui.dashboard.DashboardPresenter;
import com.example.clcustomer.ui.notifications.NotificationsContract;
import com.example.clcustomer.ui.notifications.NotificationsPresenter;
import com.example.clcustomer.ui.profile.ProfileContract;
import com.example.clcustomer.ui.profile.ProfilePresenter;
import com.example.clcustomer.ui.profileDetail.ProfileDetailContract;
import com.example.clcustomer.ui.profileDetail.ProfileDetailPresenter;
import com.example.clcustomer.ui.progressOrder.ProgressOrderContract;
import com.example.clcustomer.ui.progressOrder.ProgressOrderPresenter;
import com.example.clcustomer.ui.signIn.SignInContract;
import com.example.clcustomer.ui.signIn.SignInPresenter;
import com.example.clcustomer.ui.signInUp.SignInUpPresenter;
import com.example.clcustomer.ui.signInUp.SignInUpContract;

import org.jetbrains.annotations.NotNull;

import dagger.Module;
import dagger.Provides;
import kotlin.jvm.internal.Intrinsics;

@Module
public final class FragmentModule {
    @Provides
    @NotNull
    final SignInUpContract.Presenter provideSignInUpPresenter() {
        return new SignInUpPresenter();
    }

    @Provides
    @NotNull
    final SignInContract.Presenter provideSignInPresenter() {
        return new SignInPresenter();
    }

    @Provides
    @NotNull
    final Presenter provideDashboardPresenter() {
        return new DashboardPresenter();
    }

    @Provides
    @NotNull
    final NotificationsContract.Presenter provideNotificationsPresenter() {
        return new NotificationsPresenter();
    }

    @Provides
    @NotNull
    final ProfileContract.Presenter provideProfilePresenter() {
        return new ProfilePresenter();
    }

    @Provides
    @NotNull
    final ProfileDetailContract.Presenter provideProfileDetailPresenter() {
        return new ProfileDetailPresenter();
    }

    @Provides
    @NotNull
    final ProgressOrderContract.Presenter provideProgressOrderPresenter() {
        return new ProgressOrderPresenter();
    }

    @Provides
    @NotNull
    final ApiServiceInterface provideApiService() {
        ApiServiceInterface apiServiceInterface = Factory.create();
        Intrinsics.checkExpressionValueIsNotNull(apiServiceInterface, "ApiServiceInterface.Factory.create()");
        return apiServiceInterface;
    }
}
