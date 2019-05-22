package com.example.alshimaa.smartguide.api;

import com.example.alshimaa.smartguide.model.AddTripResponse;
import com.example.alshimaa.smartguide.model.EditTripStatusResponse;
import com.example.alshimaa.smartguide.model.EndTripDriverResponse;
import com.example.alshimaa.smartguide.model.EndTripGuideResponse;
import com.example.alshimaa.smartguide.model.FollowFlightsResponse;
import com.example.alshimaa.smartguide.model.GetBusNumberResponse;
import com.example.alshimaa.smartguide.model.GetDriverNameResponse;
import com.example.alshimaa.smartguide.model.GetGuideNameResponse;
import com.example.alshimaa.smartguide.model.GetMemeberNameResponse;
import com.example.alshimaa.smartguide.model.GetPathResponse;
import com.example.alshimaa.smartguide.model.GetTripsMemberSupervisorResponse;
import com.example.alshimaa.smartguide.model.HomeMemberResponse;
import com.example.alshimaa.smartguide.model.LoginResponse;
import com.example.alshimaa.smartguide.model.NotificationsResponse;
import com.example.alshimaa.smartguide.model.OldRequestsGuideResponse;
import com.example.alshimaa.smartguide.model.OldRequestsSupervisorResponse;
import com.example.alshimaa.smartguide.model.RequestAnswerResponse;
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


    @POST("tripPause")
    Call<StartTripResponse> getPauseTripData(@Body Map<String,String> map);


    @POST("tripPause")
    Call<StartTripResponse> getRequestPauseTripData(@Body Map<String,String> map);

    @POST("getTripsGuide")
    Call<FollowFlightsResponse> getHomeGuideData(@Body Map<String,String> map);

    @POST("requestPauseTrip")
    Call<StartTripResponse> getRequestPauseGuideData(@Body Map<String,String> map);

    @POST("getRequestPauseTripGuide")
    Call<OldRequestsGuideResponse> getOldRequestsGuideData(@Body Map<String,String> map);

    @POST("getNotifications")
    Call<NotificationsResponse> getNotificationsData(@Body Map<String,String> map);



    @POST("getTripsDriver")
    Call<FollowFlightsResponse> getHomeDriverData(@Body Map<String,String> map);

    @POST("endTripDriver")
    Call<EndTripDriverResponse> getEndTripDriverData(@Body Map<String,String> map);

    @POST("getSupervisors")
    Call<HomeMemberResponse> getHomeMemberData(@Body Map<String,String> map);

    @POST("getRequestPauseTrip")
    Call<OldRequestsSupervisorResponse> getOldRequestsSupervisorData(@Body Map<String,String> map);
    //requestAnswer

    @POST("requestAnswer")
    Call<RequestAnswerResponse> getRequestAnswerData(@Body Map<String,String> map);

    @POST("endTripGuide")
    Call<EndTripGuideResponse> getEndTripGuideData(@Body Map<String,String> map);


    @POST("getTripsMemberSupervisor")
    Call<GetTripsMemberSupervisorResponse> getTripsMemberSupervisorData(@Body Map<String,String> map);

    @POST("startTripGuide")
    Call<StartTripResponse> getstartTripGuideData(@Body Map<String,String> map);


    @POST("startTripDriver")
    Call<StartTripResponse> getstartTripDriverData(@Body Map<String,String> map);

    @POST("endTripSupervisor")
    Call<StartTripResponse> getendTripSupervisorData(@Body Map<String,String> map);
}
