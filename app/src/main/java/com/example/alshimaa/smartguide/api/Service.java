package com.example.alshimaa.smartguide.api;

import com.example.alshimaa.smartguide.model.GetBusNumberResponse;
import com.example.alshimaa.smartguide.model.GetDriverNameResponse;
import com.example.alshimaa.smartguide.model.GetGuideNameResponse;
import com.example.alshimaa.smartguide.model.LoginResponse;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface Service {
    @POST("login")
    Call<LoginResponse> getLoginData(@Body Map<String,String> map);

    @POST("getGuide")
    Call<GetGuideNameResponse> getGuideNameData(@Body Map<String,String> map);

    @POST("getBus")
    Call<GetBusNumberResponse> getBusNumberData(@Body Map<String,String> map);

    @POST("getDriver")
    Call<GetDriverNameResponse> getDriverNameData(@Body Map<String,String> map);
}
