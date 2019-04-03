package com.example.alshimaa.smartguide.view;

import com.example.alshimaa.smartguide.model.GetBusNumberData;
import com.example.alshimaa.smartguide.model.GetMemberNameData;

import java.util.List;

public interface GetMemberNameView {
    void showMemeberNameList(List<GetMemberNameData> getMemberNameDataList);
    void showMemeberNameError();
}
