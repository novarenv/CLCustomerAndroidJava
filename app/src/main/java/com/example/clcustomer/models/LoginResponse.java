package com.example.clcustomer.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import kotlin.jvm.internal.Intrinsics;

public final class LoginResponse {
    @SerializedName("status")
    private final int status;
    @SerializedName("error")
    @NotNull
    private final String error;
    @SerializedName("error_type")
    @NotNull
    private final String errorType;
    @Expose(
            deserialize = false
    )
    @SerializedName("message")
    @NotNull
    private final String message;

    public final int getStatus() {
        return this.status;
    }

    @NotNull
    public final String getError() {
        return this.error;
    }

    @NotNull
    public final String getErrorType() {
        return this.errorType;
    }

    @NotNull
    public final String getMessage() {
        return this.message;
    }

    public LoginResponse(int status, @NotNull String error, @NotNull String errorType, @NotNull String message) {
        Intrinsics.checkParameterIsNotNull(error, "error");
        Intrinsics.checkParameterIsNotNull(errorType, "errorType");
        Intrinsics.checkParameterIsNotNull(message, "message");
        this.status = status;
        this.error = error;
        this.errorType = errorType;
        this.message = message;
    }
}
