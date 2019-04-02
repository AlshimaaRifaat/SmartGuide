package com.example.alshimaa.smartguide.view;

import com.example.alshimaa.smartguide.model.GetBusNumberData;
import com.example.alshimaa.smartguide.model.GetGuideNameData;

import java.util.List;

public interface GetBusNumberView {
    void showBusNumberList(List<GetBusNumberData> getBusNumberDataListt);
    void showError();
}
