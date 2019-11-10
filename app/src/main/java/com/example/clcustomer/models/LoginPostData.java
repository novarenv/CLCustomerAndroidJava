package com.example.clcustomer.models;

import com.google.gson.annotations.SerializedName;

import org.jetbrains.annotations.NotNull;

import kotlin.jvm.internal.Intrinsics;

public final class LoginPostData {
    @SerializedName("UserId")
    @NotNull
    private String userID;
    @SerializedName("Password")
    @NotNull
    private String userPassword;

    @NotNull
    public final String getUserID() {
        return this.userID;
    }

    public final void setUserID(@NotNull String var1) {
        Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
        this.userID = var1;
    }

    @NotNull
    public final String getUserPassword() {
        return this.userPassword;
    }

    public final void setUserPassword(@NotNull String var1) {
        Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
        this.userPassword = var1;
    }

    public LoginPostData(@NotNull String userID, @NotNull String userPassword) {
        Intrinsics.checkParameterIsNotNull(userID, "userID");
        Intrinsics.checkParameterIsNotNull(userPassword, "userPassword");
        this.userID = userID;
        this.userPassword = userPassword;
    }
}
