package com.example.alshimaa.smartguide.view;

import com.example.alshimaa.smartguide.model.GetDriverNameData;
import com.example.alshimaa.smartguide.model.GetGuideNameData;

import java.util.List;

public interface GetDriverNameView {
    void showDriverNameList(List<GetDriverNameData> getDriverNameDataList);
    void showDriverError();
}
