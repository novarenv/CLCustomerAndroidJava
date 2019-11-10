package com.example.clcustomer.api;

import com.google.gson.GsonBuilder;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.TimeUnit;

import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient.Builder;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import okhttp3.logging.HttpLoggingInterceptor.Level;
import retrofit2.Converter;
import retrofit2.converter.gson.GsonConverterFactory;

public final class ApiWorker {
    private static OkHttpClient mClient;
    private static GsonConverterFactory mGsonConverter;
    private static String token;
    @NotNull
    private static final Request request;
    public static final ApiWorker INSTANCE;

    @NotNull
    public final OkHttpClient getClient() throws NoSuchAlgorithmException, KeyManagementException {
        if (mClient == null) {
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.level(Level.BODY);
            Builder httpBuilder = new Builder();
            httpBuilder.connectTimeout(15L, TimeUnit.SECONDS)
                    .readTimeout(20L, TimeUnit.SECONDS)
                    .addInterceptor((Interceptor)interceptor);
            mClient = httpBuilder.build();
        }

        return mClient;
    }

    @NotNull
    public final Request getRequest() {
        return request;
    }

    @NotNull
    public final GsonConverterFactory getGsonConverter() {
        if (mGsonConverter == null) {
            mGsonConverter = GsonConverterFactory.create((new GsonBuilder()).setLenient().disableHtmlEscaping().create());
        }

        return mGsonConverter;
    }

    @NotNull
    public final Response requestBuilderWithBearerToken(@NotNull String token) throws KeyManagementException, NoSuchAlgorithmException, IOException {
        Intrinsics.checkParameterIsNotNull(token, "token");
        return this.getClient().newCall(request).execute();
    }

    @NotNull
    public static OkHttpClient getmClient() {
        return mClient;
    }

    private ApiWorker() {

    }

    static {
        ApiWorker var0 = new ApiWorker();
        INSTANCE = var0;
        request = (new okhttp3.Request.Builder()).url("http://api.calibrapps-lab.site/").get().addHeader("cache-control", "no-cache").addHeader("Authorization", "Bearer " + token).build();
    }
}
