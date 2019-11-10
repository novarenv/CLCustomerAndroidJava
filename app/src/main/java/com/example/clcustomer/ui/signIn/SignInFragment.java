package com.example.clcustomer.ui.signIn;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.auth0.android.jwt.JWT;
import com.example.clcustomer.R;
import com.example.clcustomer.di.component.DaggerFragmentComponent;
import com.example.clcustomer.di.component.FragmentComponent;
import com.example.clcustomer.di.module.FragmentModule;
import com.example.clcustomer.models.CustomerPerusahaan;
import com.example.clcustomer.ui.dashboard.DashboardFragment;
import com.example.clcustomer.ui.signIn.SignInContract.Presenter;
import com.example.clcustomer.ui.signIn.SignInContract.View;
import java.util.HashMap;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class SignInFragment extends Fragment implements View, OnClickListener {
    @Inject
    @NotNull
    public Presenter presenter;
    private android.view.View rootView;
    private CustomerPerusahaan customerPerusahaan;
    private Button loginButton;
    private FragmentActivity myContext;
    private Activity myActivity = (Activity)this.getActivity();
    private JWT jwt;
    private String decoded;
    private String token;
    @NotNull
    private static String TAG = "Sign In Fragment";
    private DashboardFragment dashboardFragment = new DashboardFragment();

    @NotNull
    public final Presenter getPresenter() {

        return this.presenter;
    }

    public final void setPresenter(@NotNull Presenter var1) {
        Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
        this.presenter = var1;
    }

    @NotNull
    public final SignInFragment newInstance() {
        return new SignInFragment();
    }

    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.injectSignIn();
        FragmentActivity myContext = this.myContext;
        if (myContext == null) {
            Intrinsics.throwNpe();
        }

        FragmentActivity var10002 = this.myContext;

        SharedPreferences sharedPreferences = myContext.getSharedPreferences(var10002.getPackageName(), 0);
        if (sharedPreferences == null) {
            Intrinsics.throwNpe();
        }

        Editor var3 = sharedPreferences.edit();
        Intrinsics.checkExpressionValueIsNotNull(var3, "sharedPreferences!!.edit()");
        var3.putString("token", this.token).apply();
    }

    @Nullable
    public android.view.View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkParameterIsNotNull(inflater, "inflater");
        android.view.View rootView = inflater.inflate(R.layout.activity_login, container, false);
        Intrinsics.checkExpressionValueIsNotNull(rootView, "inflater.inflate(com.exa…_login, container, false)");
        this.rootView = rootView;
        android.view.View var10000 = this.rootView;

        return var10000;
    }

    public void onViewCreated(@NotNull android.view.View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkParameterIsNotNull(view, "view");
        super.onViewCreated(view, savedInstanceState);
        FragmentActivity var10000 = this.getActivity();
        if (var10000 == null) {
            Intrinsics.throwNpe();
        }

        SharedPreferences mSettings = var10000.getSharedPreferences("Settings", 0);
        this.loginButton = view.findViewById(R.id.login_button);
        Button var4 = this.loginButton;
        if (var4 != null) {
            var4.setOnClickListener((OnClickListener)this);
        }

        Presenter var5 = this.presenter;

        var5.attach(this);
        var5 = this.presenter;

        var5.subscribe();
        this.initView();
    }

    public void loadDataSuccess(@NotNull CustomerPerusahaan list) {
        Intrinsics.checkParameterIsNotNull(list, "list");
        Log.e("error", "Data dimasukkan ke object");
        this.customerPerusahaan = list;
    }

    public void showErrorMessage(@NotNull String error) {
        Intrinsics.checkParameterIsNotNull(error, "error");
        Log.e("Error", error);
    }

    @SuppressLint("ResourceType")
    public void showDashboardFragment() {
        FragmentActivity myContext = this.myContext;
        if (myContext == null) {
            Intrinsics.throwNpe();
        }

        myContext.getSupportFragmentManager().beginTransaction().disallowAddToBackStack()
                .replace(R.id.frame, (new DashboardFragment())
                        .newInstance(), dashboardFragment.getTAG())
                .commit();
    }

    public void onClick(@Nullable android.view.View v) {
        Integer var2 = v != null ? v.getId() : null;
        int var3 = R.id.login_button;
        if (var2 != null) {
            if (var2 == var3) {
                Presenter presenter = this.presenter;

                presenter.onLoginClick();
            }
        }

    }

    public void onAttach(@NotNull Activity activity) {
        Intrinsics.checkParameterIsNotNull(activity, "activity");
        this.myContext = (FragmentActivity)activity;
        super.onAttach(activity);
    }

    private void injectSignIn() {
        FragmentComponent listComponent = DaggerFragmentComponent.builder().fragmentModule(new FragmentModule()).build();
        listComponent.inject(this);
    }

    private void initView() {
        Log.e("error", "Data diambil");
    }

    public void onDestroyView() {
        super.onDestroyView();
    }

    public String getTagSignIn() {
        return TAG;
    }
}
