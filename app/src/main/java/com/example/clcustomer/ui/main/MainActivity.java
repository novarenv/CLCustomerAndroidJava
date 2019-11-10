package com.example.clcustomer.ui.main;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.clcustomer.R;
import com.example.clcustomer.di.component.ActivityComponent;
import com.example.clcustomer.di.component.DaggerActivityComponent;
import com.example.clcustomer.di.module.ActivityModule;
import com.example.clcustomer.ui.dashboard.DashboardFragment;
import com.example.clcustomer.ui.main.MainContract.Presenter;
import com.example.clcustomer.ui.main.MainContract.View;
import com.example.clcustomer.ui.signIn.SignInFragment;
import com.example.clcustomer.ui.signInUp.SignInUpFragment;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.inject.Inject;

import kotlin.jvm.internal.Intrinsics;

public final class MainActivity extends AppCompatActivity implements View {
    @Inject
    @NotNull
    public Presenter presenter;
    private SignInUpFragment signInUpFragment = new SignInUpFragment();
    private DashboardFragment dashboardFragment = new DashboardFragment();

    @NotNull
    public final Presenter getPresenter() {

        return this.presenter;
    }

    public final void setPresenter(@NotNull Presenter var1) {
        Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
        this.presenter = var1;
    }

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_main);
        this.injectDependency();
        Presenter presenter  = this.presenter;

        presenter.attach(this);
    }

    protected void onResume() {
        super.onResume();
    }

    public void showSignInUpFragment() {
        Log.e("error", "Sign In Fragment");
        this.getSupportFragmentManager()
                .beginTransaction()
                .disallowAddToBackStack()
                .replace(R.id.frame, (new SignInUpFragment()).newInstance(),
                        this.signInUpFragment.getTAG()).commit();
    }

    public void onBackPressed() {
        FragmentManager supportFragmentManager = this.getSupportFragmentManager();
        Intrinsics.checkExpressionValueIsNotNull(supportFragmentManager, "supportFragmentManager");
        Fragment fragment = supportFragmentManager.findFragmentByTag(this.dashboardFragment.getTAG());
        Log.e("error", "On Back Pressed");
        if (fragment == null) {
            Log.e("error", "Gak out :((");
            super.onBackPressed();
        } else {
            Log.e("error", "Out");
            this.getSupportFragmentManager().popBackStack();
        }

    }

    private void injectDependency() {
        ActivityComponent activityComponent = DaggerActivityComponent.builder()
                .activityModule(new ActivityModule(this)).build();
        activityComponent.inject(this);
    }
}
