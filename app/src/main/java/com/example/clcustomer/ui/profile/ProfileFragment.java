package com.example.clcustomer.ui.profile;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import com.example.clcustomer.R;
import com.example.clcustomer.di.component.DaggerFragmentComponent;
import com.example.clcustomer.di.component.FragmentComponent;
import com.example.clcustomer.di.module.FragmentModule;
import com.example.clcustomer.models.CustomerPerusahaan;
import com.example.clcustomer.ui.profile.ProfileContract.Presenter;
import com.example.clcustomer.ui.profile.ProfileContract.View;
import com.example.clcustomer.ui.profileDetail.ProfileDetailFragment;
import com.example.clcustomer.ui.signInUp.SignInUpFragment;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.inject.Inject;

import kotlin.jvm.internal.Intrinsics;

public final class ProfileFragment extends Fragment implements View, android.view.View.OnClickListener {
    @Inject
    @NotNull
    public Presenter presenter;
    private android.view.View rootView;
    private CustomerPerusahaan customerPerusahaan;
    private TextView tvCustomerNameProfile;
    private FragmentActivity myContext;
    @NotNull
    private static final String TAG = "Profile Fragment";
    private CardView cvProfileDetail;
    private ProfileDetailFragment profileDetailFragment;

    @NotNull
    public final Presenter getPresenter() {

        return this.presenter;
    }

    public final void setPresenter(@NotNull Presenter var1) {
        Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
        this.presenter = var1;
    }

    @NotNull
    public final ProfileFragment newInstance() {
        return new ProfileFragment();
    }

    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.injectProfile();
    }

    @Nullable
    public android.view.View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkParameterIsNotNull(inflater, "inflater");
        android.view.View rootView = inflater.inflate(R.layout.my_profile, container, false);
        Intrinsics.checkExpressionValueIsNotNull(rootView, "inflater.inflate(R.layou…rofile, container, false)");
        this.rootView = rootView;

        return this.rootView;
    }

    public void onViewCreated(@NotNull android.view.View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkParameterIsNotNull(view, "view");
        super.onViewCreated(view, savedInstanceState);
        this.tvCustomerNameProfile = view.findViewById(R.id.tv_customer_name_profile);
        this.cvProfileDetail = view.findViewById(R.id.cv_profile_user);
        this.profileDetailFragment = new ProfileDetailFragment();

        Presenter presenter = this.presenter;
        cvProfileDetail.setOnClickListener(this);

        presenter.attach(this);
        presenter = this.presenter;

        presenter.subscribe();
        this.initView();
    }

    public void loadDataSuccess(@NotNull CustomerPerusahaan list) {
        Intrinsics.checkParameterIsNotNull(list, "list");
        Log.e("error", "Data dimasukkan ke object");
        this.customerPerusahaan = list;
        TextView tvCustomerNameProfile = this.tvCustomerNameProfile;
        if (tvCustomerNameProfile != null) {
            tvCustomerNameProfile.setText(this.customerPerusahaan.getCustomer_perusahaan_nama());
        }

    }

    public void showErrorMessage(@NotNull String error) {
        Intrinsics.checkParameterIsNotNull(error, "error");
        Log.e("Error", error);
    }

    public void showProfileDetail() {
        myContext.getSupportFragmentManager()
                .beginTransaction()
                .disallowAddToBackStack()
                .replace(R.id.frame, profileDetailFragment.newInstance(),
                        profileDetailFragment.getTAG()).commit();
    }

    public void onAttach(@NotNull Activity activity) {
        Intrinsics.checkParameterIsNotNull(activity, "activity");
        this.myContext = (FragmentActivity)activity;
        super.onAttach(activity);
    }

    @Override
    public void onClick(android.view.View view) {
        switch (view.getId()){
            case R.id.cv_profile_user:
                presenter.onProfileDetailClick();
                break;
        }
    }

    private void injectProfile() {
        FragmentComponent listComponent = DaggerFragmentComponent.builder().fragmentModule(new FragmentModule()).build();
        listComponent.inject(this);
    }

    private void initView() {
        Log.e("error", "Data diambil");
        Presenter presenter = this.presenter;

        presenter.loadData();
    }

    public void onDestroyView() {
        super.onDestroyView();
    }

    @NotNull
    public final String getTAG() {
        return ProfileFragment.TAG;
    }
}
