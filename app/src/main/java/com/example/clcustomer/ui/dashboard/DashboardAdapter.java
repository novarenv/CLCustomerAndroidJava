package com.example.clcustomer.ui.dashboard;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import com.example.clcustomer.R;
import com.example.clcustomer.models.CustomerPerusahaan;
import com.example.clcustomer.ui.notifications.NotificationsFragment;
import com.example.clcustomer.ui.progressOrder.ProgressOrderFragment;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref.ObjectRef;

public final class DashboardAdapter extends Adapter {
    private final DashboardAdapter.onItemClickListener listener;
    private final Context context;
    private List<CustomerPerusahaan> customerPerusahaanList;
    private FragmentActivity contextFragmentActivity;
    private ProgressOrderFragment progressOrderFragment = new ProgressOrderFragment();

    @NotNull
    public DashboardAdapter.ListViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkParameterIsNotNull(parent, "parent");
        View itemView = LayoutInflater.from(this.context).inflate(R.layout.cv_progress_order, parent, false);
        Intrinsics.checkExpressionValueIsNotNull(itemView, "itemView");
        return new DashboardAdapter.ListViewHolder(itemView);
    }

    public int getItemCount() {
        return this.customerPerusahaanList.size();
    }

    private void onBindViewHolder(@NotNull DashboardAdapter.ListViewHolder holder, int position) {
        Intrinsics.checkParameterIsNotNull(holder, "holder");
        @NotNull
        CustomerPerusahaan post = this.customerPerusahaanList.get(position);
        TextView title = holder.getTitle();

        title.setText(post.getCustomer_perusahaan_nama());
        holder.itemView.setOnClickListener(
                view -> showProgressOrderFragment()
        );
    }

    public void onBindViewHolder(@NotNull ViewHolder viewHolder, int i) {
        this.onBindViewHolder((DashboardAdapter.ListViewHolder)viewHolder, i);
    }

    DashboardAdapter(@NotNull Context context, @NotNull List<CustomerPerusahaan> list,
                     @NotNull Fragment fragment) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(list, "list");
        Intrinsics.checkParameterIsNotNull(fragment, "fragment");
        this.context = context;
        this.customerPerusahaanList= list;
        this.listener = (DashboardAdapter.onItemClickListener)fragment;
    }

    public void setContextFragmentActivity(FragmentActivity context) {
        this.contextFragmentActivity = context;
    }

    private void showProgressOrderFragment() {
        FragmentActivity myContext = this.contextFragmentActivity;
        if (myContext != null) {
            FragmentManager fragmentManager = myContext.getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction = fragmentTransaction.addToBackStack(null);
            fragmentTransaction = fragmentTransaction.replace(R.id.frame,
                    (new ProgressOrderFragment()).newInstance(), progressOrderFragment.getTAG());
            fragmentTransaction.commit();
        }
    }

    public static final class ListViewHolder extends ViewHolder {
        private CardView layout;
        private final TextView title;

        final CardView getLayout() {
            return this.layout;
        }

        public final void setLayout(CardView cardView) {
            this.layout = cardView;
        }

        final TextView getTitle() {
            return this.title;
        }

        ListViewHolder(@NotNull View itemView) {
            super(itemView);
            Intrinsics.checkParameterIsNotNull(itemView, "itemView");
            this.layout = itemView.findViewById(R.id.cv_progress_order);
            this.title = itemView.findViewById(R.id.progress_order_nama);
        }
    }

    public interface onItemClickListener {
        void itemRemoveClick(@NotNull CustomerPerusahaan var1);

        void itemDetail(@NotNull String var1);
    }
}
