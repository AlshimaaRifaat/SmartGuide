package com.example.alshimaa.smartguide.view;

import com.example.alshimaa.smartguide.model.FollowFlightsData;
import com.example.alshimaa.smartguide.model.GetTripsMemberSupervisorData;

import java.util.List;

public interface GetTripsMemberSupervisorView {
    void showTripsMemberSupervisorList(List<GetTripsMemberSupervisorData> getTripsMemberSupervisorDataList);
    void showTripsMemberSupervisorError();
}
