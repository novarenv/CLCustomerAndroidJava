package com.example.clcustomer.ui.progressOrder;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import com.example.clcustomer.R;
import com.example.clcustomer.di.component.DaggerFragmentComponent;
import com.example.clcustomer.di.component.FragmentComponent;
import com.example.clcustomer.di.module.FragmentModule;
import com.example.clcustomer.models.CustomerPerusahaan;
import com.example.clcustomer.ui.progressOrder.ProgressOrderContract.Presenter;
import com.example.clcustomer.ui.progressOrder.ProgressOrderContract.View;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

import javax.inject.Inject;

import kotlin.jvm.internal.Intrinsics;

public final class ProgressOrderFragment extends Fragment implements View {
    @Inject
    @NotNull
    public Presenter presenter;
    private android.view.View rootView;
    private FragmentActivity myContext;
    @NotNull
    private static final String TAG = "Progress Order Fragment";

    @NotNull
    public final Presenter getPresenter() {

        return this.presenter;
    }

    public final void setPresenter(@NotNull Presenter var1) {
        Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
        this.presenter = var1;
    }

    @NotNull
    public final ProgressOrderFragment newInstance() {
        Log.e("error", "Progress Order Instance");
        return new ProgressOrderFragment();
    }

    public void onCreate(@Nullable Bundle savedInstanceState) {
        Log.e("error", "On Create ProgressOrder");
        super.onCreate(savedInstanceState);
        this.injectProgressOrder();
    }

    @NotNull
    public android.view.View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkParameterIsNotNull(inflater, "inflater");
        android.view.View view = inflater.inflate(R.layout.progress_order, container, false);
        Intrinsics.checkExpressionValueIsNotNull(view, "inflater.inflate(R.layou…_order, container, false)");
        this.rootView = view;

        return this.rootView;
    }

    public void onViewCreated(@NotNull android.view.View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkParameterIsNotNull(view, "view");
        super.onViewCreated(view, savedInstanceState);
        Presenter presenter = this.presenter;

        presenter.attach(this);
        presenter = this.presenter;

        presenter.subscribe();
        this.initView();
    }

    public void loadDataSuccess(@NotNull CustomerPerusahaan list) {
        Intrinsics.checkParameterIsNotNull(list, "list");
    }

    public void loadDataAllSuccess(@NotNull List list) {
        Intrinsics.checkParameterIsNotNull(list, "list");
    }

    public void showErrorMessage(@NotNull String error) {
        Intrinsics.checkParameterIsNotNull(error, "error");
        Log.e("Error", error);
    }

    public void onAttach(@NotNull Activity activity) {
        Intrinsics.checkParameterIsNotNull(activity, "activity");
        this.myContext = (FragmentActivity)activity;
        super.onAttach(activity);
    }

    public final void injectProgressOrder() {
        FragmentComponent listComponent = DaggerFragmentComponent.builder().fragmentModule(new FragmentModule()).build();
        listComponent.inject(this);
    }

    private final void initView() {
        Presenter presenter = this.presenter;

        presenter.loadData();
        presenter = this.presenter;

        presenter.loadDataAll();
    }

    public void onDestroyView() {
        super.onDestroyView();
    }

    @NotNull
    public final String getTAG() {
            return ProgressOrderFragment.TAG;
        }
}
