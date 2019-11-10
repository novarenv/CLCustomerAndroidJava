package com.example.clcustomer.api;

import com.example.clcustomer.models.CustomerPerusahaan;
import com.example.clcustomer.models.LoginPostData;
import com.example.clcustomer.models.LoginResponse;
import com.example.clcustomer.util.Constants;

import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

import java.util.List;

import retrofit2.Retrofit;
import retrofit2.Retrofit.Builder;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
public interface ApiServiceInterface {
    ApiServiceInterface.Factory Factory = ApiServiceInterface.Factory.$$INSTANCE;

    @GET("api/customer-perusahaan")
    @NotNull
    Observable<List<CustomerPerusahaan>> getCustomerPerusahaan();

    @GET("api/customer-perusahaan/{id}")
    @NotNull
    Observable<CustomerPerusahaan> getCustomerPerusahaan(@Path("id") int var1);

    @Headers({"Content-Type: application/json"})
    @POST("login")
    @NotNull
    Observable<LoginResponse> doLogin(@Body @NotNull LoginPostData var1);

    final class Factory {
        static final ApiServiceInterface.Factory $$INSTANCE;

        private Factory() {
        }

        static {
            $$INSTANCE = new Factory();
        }

        @NotNull
        public static ApiServiceInterface create() {
            Retrofit retrofit = (new Builder())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
//                    .addConverterFactory(ApiWorker.getGsonConverter())
//                    .client(ApiWorker.getmClient())
                    .baseUrl(Constants.BASE_URL)
                    .build();
            ApiServiceInterface apiServiceInterface = retrofit.create(ApiServiceInterface.class);
            Intrinsics.checkExpressionValueIsNotNull(apiServiceInterface,
                    "retrofit.create(ApiServiceInterface::class.java)");
            return apiServiceInterface;
        }
    }
}
