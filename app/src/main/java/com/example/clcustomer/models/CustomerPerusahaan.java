package com.example.clcustomer.models;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class CustomerPerusahaan {
    private final int customer_perusahaan_id;
    @NotNull
    private final String customer_perusahaan_pkal;
    @NotNull
    private final String customer_perusahaan_nama;
    @NotNull
    private final String customer_perusahaan_alamat;
    @NotNull
    private final String customer_perusahaan_telepon;
    @NotNull
    private final String customer_perusahaan_fax;
    private final int customer_status_id;

    public final int getCustomer_perusahaan_id() {
        return this.customer_perusahaan_id;
    }

    @NotNull
    public final String getCustomer_perusahaan_pkal() {
        return this.customer_perusahaan_pkal;
    }

    @NotNull
    public final String getCustomer_perusahaan_nama() {
        return this.customer_perusahaan_nama;
    }

    @NotNull
    public final String getCustomer_perusahaan_alamat() {
        return this.customer_perusahaan_alamat;
    }

    @NotNull
    public final String getCustomer_perusahaan_telepon() {
        return this.customer_perusahaan_telepon;
    }

    @NotNull
    public final String getCustomer_perusahaan_fax() {
        return this.customer_perusahaan_fax;
    }

    public final int getCustomer_status_id() {
        return this.customer_status_id;
    }

    public CustomerPerusahaan(int customer_perusahaan_id, @NotNull String customer_perusahaan_pkal, @NotNull String customer_perusahaan_nama, @NotNull String customer_perusahaan_alamat, @NotNull String customer_perusahaan_telepon, @NotNull String customer_perusahaan_fax, int customer_status_id) {
        Intrinsics.checkParameterIsNotNull(customer_perusahaan_pkal, "customer_perusahaan_pkal");
        Intrinsics.checkParameterIsNotNull(customer_perusahaan_nama, "customer_perusahaan_nama");
        Intrinsics.checkParameterIsNotNull(customer_perusahaan_alamat, "customer_perusahaan_alamat");
        Intrinsics.checkParameterIsNotNull(customer_perusahaan_telepon, "customer_perusahaan_telepon");
        Intrinsics.checkParameterIsNotNull(customer_perusahaan_fax, "customer_perusahaan_fax");
        this.customer_perusahaan_id = customer_perusahaan_id;
        this.customer_perusahaan_pkal = customer_perusahaan_pkal;
        this.customer_perusahaan_nama = customer_perusahaan_nama;
        this.customer_perusahaan_alamat = customer_perusahaan_alamat;
        this.customer_perusahaan_telepon = customer_perusahaan_telepon;
        this.customer_perusahaan_fax = customer_perusahaan_fax;
        this.customer_status_id = customer_status_id;
    }
}
