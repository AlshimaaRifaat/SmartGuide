package com.example.alshimaa.smartguide.view;

import com.example.alshimaa.smartguide.model.FollowFlightsData;

import java.util.List;

public interface HomeDriverView {
    void showHomeDriverList(List<FollowFlightsData> followFlightsDataList);
    void showHomeDriverError();
}
