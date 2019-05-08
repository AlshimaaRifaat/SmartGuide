package com.example.alshimaa.smartguide.view;

import com.example.alshimaa.smartguide.model.OldRequestsGuideData;
import com.example.alshimaa.smartguide.model.OldRequestsSupervisorData;

import java.util.List;

public interface OldRequestsSupervisorView {
    void showOldRequestsSupervisorList(List<OldRequestsSupervisorData> oldRequestsSupervisorDataList);
    void showOldRequestsSupervisorError();
}
