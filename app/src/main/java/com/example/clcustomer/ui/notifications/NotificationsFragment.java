package com.example.clcustomer.ui.notifications;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.clcustomer.R;
import com.example.clcustomer.di.component.DaggerFragmentComponent;
import com.example.clcustomer.di.component.FragmentComponent;
import com.example.clcustomer.di.module.FragmentModule;
import com.example.clcustomer.ui.notifications.NotificationsContract.Presenter;
import com.example.clcustomer.ui.notifications.NotificationsContract.View;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.inject.Inject;

import kotlin.jvm.internal.Intrinsics;

public final class NotificationsFragment extends Fragment implements View {
    @Inject
    @NotNull
    public Presenter presenter;
    private android.view.View rootView;
    @NotNull
    private static final String TAG = "Notifications Fragment";

    @NotNull
    public final Presenter getPresenter() {
        Presenter presenter = this.presenter;

        return presenter;
    }

    public final void setPresenter(@NotNull Presenter presenter) {
        Intrinsics.checkParameterIsNotNull(presenter, "<set-?>");
        this.presenter = presenter;
    }

    @NotNull
    public final NotificationsFragment newInstance() {
        return new NotificationsFragment();
    }

    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.injectNotifications();
    }

    @Nullable
    public android.view.View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkParameterIsNotNull(inflater, "inflater");
        android.view.View view = inflater.inflate(R.layout.notifications, container, false);
        Intrinsics.checkExpressionValueIsNotNull(view, "inflater.inflate(R.layou…ations, container, false)");
        this.rootView = view;

        return this.rootView;
    }

    public void onViewCreated(@NotNull android.view.View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkParameterIsNotNull(view, "view");
        super.onViewCreated(view, savedInstanceState);
        Presenter presenter = this.presenter;

        presenter.attach(this);
    }

    private void injectNotifications() {
        FragmentComponent listComponent = DaggerFragmentComponent.builder().fragmentModule(new FragmentModule()).build();
        listComponent.inject(this);
    }

    public void onDestroyView() {
        super.onDestroyView();
    }

    @NotNull
    public final String getTAG() {
            return NotificationsFragment.TAG;
        }
}
