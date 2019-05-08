package com.example.alshimaa.smartguide.view;

import com.example.alshimaa.smartguide.model.HomeMemberData;

import java.util.List;

public interface HomeMemberView {
    void showHomeMemberList(List<HomeMemberData> homeMemberDataList);
    void showHomeMemberError();
}
