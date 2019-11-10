package com.example.clcustomer.ui.profileDetail;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.clcustomer.R;
import com.example.clcustomer.di.component.DaggerFragmentComponent;
import com.example.clcustomer.di.component.FragmentComponent;
import com.example.clcustomer.di.module.FragmentModule;
import com.example.clcustomer.ui.profileDetail.ProfileDetailContract.Presenter;
import com.example.clcustomer.ui.profileDetail.ProfileDetailContract.View;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.inject.Inject;

import kotlin.jvm.internal.Intrinsics;

public final class ProfileDetailFragment extends Fragment implements View {
    @Inject
    @NotNull
    public Presenter presenter;
    private android.view.View rootView;
    @NotNull
    private static final String TAG = "Notifications Fragment";

    @NotNull
    public final Presenter getPresenter() {

        return this.presenter;
    }

    public final void setPresenter(@NotNull Presenter var1) {
        Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
        this.presenter = var1;
    }

    @NotNull
    public final ProfileDetailFragment newInstance() {
        return new ProfileDetailFragment();
    }

    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.injectProfileDetail();
    }

    @Nullable
    public android.view.View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkParameterIsNotNull(inflater, "inflater");
        android.view.View view = inflater.inflate(R.layout.profile_detail, container, false);
        Intrinsics.checkExpressionValueIsNotNull(view, "inflater.inflate(R.layou…detail, container, false)");
        this.rootView = view;

        return this.rootView;
    }

    public void onViewCreated(@NotNull android.view.View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkParameterIsNotNull(view, "view");
        super.onViewCreated(view, savedInstanceState);
        Presenter presenter = this.presenter;

        presenter.attach(this);
    }

    private final void injectProfileDetail() {
        FragmentComponent listComponent = DaggerFragmentComponent.builder().fragmentModule(new FragmentModule()).build();
        listComponent.inject(this);
    }
    public void onDestroyView() {
        super.onDestroyView();
    }

    @NotNull
    public final String getTAG() {
        return ProfileDetailFragment.TAG;
    }
}
