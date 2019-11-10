package com.example.clcustomer.ui.signInUp;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;

import com.example.clcustomer.R;
import com.example.clcustomer.di.component.DaggerFragmentComponent;
import com.example.clcustomer.di.component.FragmentComponent;
import com.example.clcustomer.di.module.FragmentModule;
import com.example.clcustomer.ui.signIn.SignInFragment;
import com.example.clcustomer.ui.signInUp.SignInUpContract.Presenter;
import com.example.clcustomer.ui.signInUp.SignInUpContract.View;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.inject.Inject;

import kotlin.jvm.internal.Intrinsics;

public final class SignInUpFragment extends Fragment implements View, OnClickListener {
    @Inject
    @NotNull
    public Presenter presenter;
    private android.view.View rootView;
    private FragmentActivity myContext;
    private Button loginButton;
    private SignInFragment signInFragment;
    @NotNull
    private static final String TAG = "Sign In Up Fragment";

    @NotNull
    public final Presenter getPresenter() {

        return this.presenter;
    }

    public final void setPresenter(@NotNull Presenter var1) {
        Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
        this.presenter = var1;
    }

    @NotNull
    public final SignInUpFragment newInstance() {
        return new SignInUpFragment();
    }

    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.injectSignInUp();
    }

    @Nullable
    public android.view.View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkParameterIsNotNull(inflater, "inflater");
        android.view.View view = inflater.inflate(R.layout.login_register, container, false);
        Intrinsics.checkExpressionValueIsNotNull(view, "inflater.inflate(R.layou…gister, container, false)");
        this.rootView = view;

        return this.rootView;
    }

    public void onViewCreated(@NotNull android.view.View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkParameterIsNotNull(view, "view");
        super.onViewCreated(view, savedInstanceState);
        this.signInFragment = new SignInFragment();
        FragmentActivity myContext = this.myContext;
        if (myContext == null) {
            Intrinsics.throwUninitializedPropertyAccessException("myContext");
        }

        android.view.View viewLoginButton = myContext.findViewById(R.id.login_button);
        Intrinsics.checkExpressionValueIsNotNull(viewLoginButton, "myContext.findViewById(R.id.login_button)");
        this.loginButton = (Button)viewLoginButton;
        Button loginButton = this.loginButton;

        loginButton.setOnClickListener(this);
        Presenter presenter = this.presenter;

        presenter.attach(this);
        presenter = this.presenter;

        presenter.subscribe();
        this.initView();
    }

    public void showErrorMessage(@NotNull String error) {
        Intrinsics.checkParameterIsNotNull(error, "error");
        Log.e("Error", error);
    }

    public void showSignInFragment() {
        Log.e("error", "Show Sign In Fragment");
        FragmentActivity myContext = this.myContext;
        if (myContext == null) {
            Intrinsics.throwUninitializedPropertyAccessException("myContext");
        }

        FragmentTransaction fragmentTransaction = myContext.getSupportFragmentManager().beginTransaction().disallowAddToBackStack();
        SignInFragment signInFragment = this.signInFragment;
        if (signInFragment == null) {
            Intrinsics.throwUninitializedPropertyAccessException("signInFragment");
        }

        Fragment fragment = signInFragment.newInstance();
        SignInFragment signInFragment1 = this.signInFragment;
        if (signInFragment1 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("signInFragment");
        }

        fragmentTransaction.replace(R.id.frame, fragment, signInFragment1.getTag()).commit();
    }

    public void onClick(@Nullable android.view.View v) {
        Integer var2 = v != null ? v.getId() : null;
        int var3 = R.id.login_button;
        if (var2 != null) {
            if (var2 == var3) {
                Log.e("error", "Login Sign In Up");
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

    private void injectSignInUp() {
        FragmentComponent listComponent = DaggerFragmentComponent.builder().fragmentModule(new FragmentModule()).build();
        listComponent.inject(this);
    }

    private void initView() {
        Log.e("error", "Data diambil");
    }

    public void onDestroyView() {
        super.onDestroyView();
    }

    @NotNull
    public final String getTAG() {
            return SignInUpFragment.TAG;
        }
}
