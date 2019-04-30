package com.example.alshimaa.smartguide.view;

import com.example.alshimaa.smartguide.model.OldRequestsGuideData;

import java.util.List;

public interface OldRequestsGuideView {
    void showOldRequestsGuideList(List<OldRequestsGuideData> oldRequestsGuideDataList);
    void showOldRequestsError();
}
