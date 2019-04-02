package com.example.alshimaa.smartguide.view;

import com.example.alshimaa.smartguide.model.GetGuideNameData;

import java.util.List;

public interface GetGuideNameView {
    void showGuideNameList(List<GetGuideNameData> getGuideNameDataList);
    void showError();
}
