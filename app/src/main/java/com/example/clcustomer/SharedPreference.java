package com.example.clcustomer;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import kotlin.jvm.internal.Intrinsics;

public final class SharedPreference {
    private final String PREFS_NAME;
    @NotNull
    private final SharedPreferences sharedPref;
    @NotNull
    private final Context context;

    @NotNull
    public final SharedPreferences getSharedPref() {
        return this.sharedPref;
    }

    public final void save(@NotNull String KEY_NAME, int value) {
        Intrinsics.checkParameterIsNotNull(KEY_NAME, "KEY_NAME");
        Editor editor = this.sharedPref.edit();
        Intrinsics.checkExpressionValueIsNotNull(editor, "sharedPref.edit()");
        editor.putInt(KEY_NAME, value);
        editor.apply();
    }

    public final void save(@NotNull String KEY_NAME, @NotNull String value) {
        Intrinsics.checkParameterIsNotNull(KEY_NAME, "KEY_NAME");
        Intrinsics.checkParameterIsNotNull(value, "value");
        Editor editor = this.sharedPref.edit();
        Intrinsics.checkExpressionValueIsNotNull(editor, "sharedPref.edit()");
        editor.putString(KEY_NAME, value);
        editor.apply();
    }

    public final void save(@NotNull String KEY_NAME, boolean status) {
        Intrinsics.checkParameterIsNotNull(KEY_NAME, "KEY_NAME");
        Editor editor = this.sharedPref.edit();
        Intrinsics.checkExpressionValueIsNotNull(editor, "sharedPref.edit()");
        editor.putBoolean(KEY_NAME, status);
        editor.apply();
    }

    public final int getValueInt(@NotNull String KEY_NAME) {
        Intrinsics.checkParameterIsNotNull(KEY_NAME, "KEY_NAME");
        return this.sharedPref.getInt(KEY_NAME, 0);
    }

    @Nullable
    public final String getValueString(@NotNull String KEY_NAME) {
        Intrinsics.checkParameterIsNotNull(KEY_NAME, "KEY_NAME");
        return this.sharedPref.getString(KEY_NAME, null);
    }

    public final boolean getValueBoolean(@NotNull String KEY_NAME, boolean defaultValue) {
        Intrinsics.checkParameterIsNotNull(KEY_NAME, "KEY_NAME");
        return this.sharedPref.getBoolean(KEY_NAME, defaultValue);
    }

    public final void clearSharedPreference() {
        Editor editor = this.sharedPref.edit();
        Intrinsics.checkExpressionValueIsNotNull(editor, "sharedPref.edit()");
        editor.clear();
        editor.apply();
    }

    public final void removeValue(@NotNull String KEY_NAME) {
        Intrinsics.checkParameterIsNotNull(KEY_NAME, "KEY_NAME");
        Editor editor = this.sharedPref.edit();
        Intrinsics.checkExpressionValueIsNotNull(editor, "sharedPref.edit()");
        editor.remove(KEY_NAME);
        editor.apply();
    }

    @NotNull
    public final Context getContext() {
        return this.context;
    }

    public SharedPreference(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        this.context = context;
        this.PREFS_NAME = "javacodes";
        SharedPreferences sharedPreferences = this.context.getSharedPreferences(this.PREFS_NAME, 0);
        Intrinsics.checkExpressionValueIsNotNull(sharedPreferences,
                "context.getSharedPrefere…ME, Context.MODE_PRIVATE)");
        this.sharedPref = sharedPreferences;
    }
}
