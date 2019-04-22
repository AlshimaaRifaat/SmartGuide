package com.example.alshimaa.smartguide.api;

import com.example.alshimaa.smartguide.model.AddTripResponse;
import com.example.alshimaa.smartguide.model.EditTripStatusResponse;
import com.example.alshimaa.smartguide.model.FollowFlightsResponse;
import com.example.alshimaa.smartguide.model.GetBusNumberResponse;
import com.example.alshimaa.smartguide.model.GetDriverNameResponse;
import com.example.alshimaa.smartguide.model.GetGuideNameResponse;
import com.example.alshimaa.smartguide.model.GetMemeberNameResponse;
import com.example.alshimaa.smartguide.model.GetPathResponse;
import com.example.alshimaa.smartguide.model.LoginResponse;
import com.example.alshimaa.smartguide.model.StartTripResponse;

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

    @POST("getMember")
    Call<GetMemeberNameResponse> getMemeberNameData(@Body Map<String,String> map);

    @POST("addTrip")
    Call<AddTripResponse> getAddTripData(@Body Map<String,String> map);

    @POST("getTrip")
    Call<FollowFlightsResponse> getFollowFlightsData(@Body Map<String,String> map);

    @POST("getPath")
    Call<GetPathResponse> getPathData(@Body Map<String,String> map);

    @POST("filterByStatus")
    Call<FollowFlightsResponse> getSortByStatusData(@Body Map<String,String> map);

    @POST("filterByDate")
    Call<FollowFlightsResponse> getSortByDateData(@Body Map<String,String> map);

    @POST("editTripStatus")
    Call<EditTripStatusResponse> getEditTripStatusData(@Body Map<String,String> map);

    @POST("startTrip")
    Call<StartTripResponse> getStartTripData(@Body Map<String,String> map);

}
