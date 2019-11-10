package com.example.clcustomer.ui.dashboard;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.clcustomer.R;
import com.example.clcustomer.R.id;
import com.example.clcustomer.di.component.DaggerFragmentComponent;
import com.example.clcustomer.di.component.FragmentComponent;
import com.example.clcustomer.di.module.FragmentModule;
import com.example.clcustomer.models.CustomerPerusahaan;
import com.example.clcustomer.ui.dashboard.DashboardAdapter.onItemClickListener;
import com.example.clcustomer.ui.dashboard.DashboardContract.Presenter;
import com.example.clcustomer.ui.dashboard.DashboardContract.View;
import com.example.clcustomer.ui.notifications.NotificationsFragment;
import com.example.clcustomer.ui.profile.ProfileFragment;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

import javax.inject.Inject;

import kotlin.NotImplementedError;
import kotlin.jvm.internal.Intrinsics;

public final class DashboardFragment extends Fragment implements View, onItemClickListener, OnClickListener {
    @Inject
    @NotNull
    public Presenter presenter;
    private android.view.View rootView;
    private ImageView ivIcNotifications;
    private TextView tvNamaCustomerProfile;
    private LinearLayout llBottomBarProfile;
    private CustomerPerusahaan customerPerusahaan;
    private FragmentActivity myContext;
    private ProfileFragment profileFragment;
    private NotificationsFragment notificationsFragment;
    @NotNull
    private static final String TAG = "Dashboard Fragment";

    @NotNull
    public final Presenter getPresenter() {

        return this.presenter;
    }

    public final void setPresenter(@NotNull Presenter var1) {
        Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
        this.presenter = var1;
    }

    @NotNull
    public final DashboardFragment newInstance() {
        return new DashboardFragment();
    }

    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.injectDashboard();
    }

    @Nullable
    public android.view.View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkParameterIsNotNull(inflater, "inflater");
        android.view.View view = inflater.inflate(R.layout.dashboard, container, false);
        Intrinsics.checkExpressionValueIsNotNull(view, "inflater.inflate(R.layou…hboard, container, false)");
        this.rootView = view;

        return this.rootView;
    }

    public void onViewCreated(@NotNull android.view.View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkParameterIsNotNull(view, "view");
        super.onViewCreated(view, savedInstanceState);
        this.ivIcNotifications = view.findViewById(id.ic_notifications);
        this.llBottomBarProfile = view.findViewById(id.ll_bottom_bar_profile);
        this.profileFragment = new ProfileFragment();
        this.notificationsFragment = new NotificationsFragment();
        ImageView ivIcNotifications = this.ivIcNotifications;
        if (ivIcNotifications == null) {
            Intrinsics.throwNpe();
        }

        ivIcNotifications.setOnClickListener(this);
        LinearLayout llBottomBarProfile = this.llBottomBarProfile;
        if (llBottomBarProfile == null) {
            Intrinsics.throwNpe();
        }

        llBottomBarProfile.setOnClickListener(this);
        Presenter presenter = this.presenter;

        presenter.attach(this);
        presenter = this.presenter;

        presenter.subscribe();
        this.initView();
    }

    public void loadDataSuccess(@NotNull CustomerPerusahaan list) {
        Intrinsics.checkParameterIsNotNull(list, "list");
        this.customerPerusahaan = list;
        android.view.View view = this.getView();
        if (view == null) {
            Intrinsics.throwNpe();
        }

        this.tvNamaCustomerProfile = view.findViewById(id.tv_customer_name_profile);
        TextView tvNamaCustomerProfile = this.tvNamaCustomerProfile;
        if (tvNamaCustomerProfile == null) {
            Intrinsics.throwNpe();
        }

        CustomerPerusahaan customerPerusahaan = this.customerPerusahaan;
        if (customerPerusahaan == null) {
            Intrinsics.throwNpe();
        }

        tvNamaCustomerProfile.setText(customerPerusahaan.getCustomer_perusahaan_nama());
    }

    public void loadDataAllSuccess(@NotNull List list) {
        Intrinsics.checkParameterIsNotNull(list, "list");
        DashboardAdapter dashboardAdapter = new DashboardAdapter(myContext, list, (Fragment)this);
        FragmentActivity fragmentActivity = this.getActivity();
        if (fragmentActivity == null) {
            Intrinsics.throwNpe();
        }

        Context context = fragmentActivity.getApplicationContext();
        RecyclerView recyclerView = myContext.findViewById(id.recyclerView);
        if (recyclerView == null) {
            Intrinsics.throwNpe();
        }

        recyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        recyclerView.setAdapter(dashboardAdapter);
        dashboardAdapter.setContextFragmentActivity(myContext);
    }

    public void showErrorMessage(@NotNull String error) {
        Intrinsics.checkParameterIsNotNull(error, "error");
        Log.e("Error", error);
    }

    public void itemRemoveClick(@NotNull CustomerPerusahaan customerPerusahaan) {
        Intrinsics.checkParameterIsNotNull(customerPerusahaan, "customerPerusahaan");
        String var2 = "not implemented";
        try {
            throw new NotImplementedError("An operation is not implemented: " + var2);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    public void itemDetail(@NotNull String customerPerusahaanId) {
        Intrinsics.checkParameterIsNotNull(customerPerusahaanId, "customerPerusahaanId");
    }

    public void showNotificationsFragment() {
        FragmentActivity myContext = this.myContext;
        if (myContext != null) {
            FragmentManager fragmentManager = myContext.getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction = fragmentTransaction.addToBackStack(null);
            fragmentTransaction = fragmentTransaction.replace(id.frame,
                    (new NotificationsFragment()).newInstance(), notificationsFragment.getTAG());
            fragmentTransaction.commit();
        }

    }

    public void showProfileFragment() {
        FragmentActivity myContext = this.myContext;
        if (myContext != null) {
            FragmentManager fragmentManager = myContext.getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction = fragmentTransaction.addToBackStack(null);
            Fragment fragment = (new ProfileFragment()).newInstance();
            ProfileFragment profileFragment = this.profileFragment;
            if (profileFragment == null) {
                Intrinsics.throwUninitializedPropertyAccessException("profileFragment");
            }

            fragmentTransaction = fragmentTransaction.replace(id.frame, fragment, profileFragment.getTAG());
            fragmentTransaction.commit();
        }

    }

    public void onClick(@Nullable android.view.View v) {
        Integer var2 = v != null ? v.getId() : null;
        int var3 = id.ic_notifications;
        Presenter presenter;
        if (var2 != null) {
            if (var2 == var3) {
                Log.e("error", "Bottom");
                presenter = this.presenter;

                presenter.onNotificationsClick();
                return;
            }
        }

        var3 = id.ll_bottom_bar_profile;
        if (var2 != null) {
            if (var2 == var3) {
                Log.e("error", "Profile");
                presenter = this.presenter;

                presenter.onProfileClick();
            }
        }

    }

    public void onAttach(@NotNull Activity activity) {
        Intrinsics.checkParameterIsNotNull(activity, "activity");
        this.myContext = (FragmentActivity)activity;
        super.onAttach(activity);
    }

    private void injectDashboard() {
        FragmentComponent listComponent = DaggerFragmentComponent.builder().fragmentModule(new FragmentModule()).build();
        listComponent.inject(this);
    }

    private void initView() {
        Presenter presenter = this.presenter;

        presenter.loadData();

        presenter.loadDataAll();
    }

    public void onDestroyView() {
        super.onDestroyView();
    }

    public final String getTAG() {
            return DashboardFragment.TAG;
        }
}
