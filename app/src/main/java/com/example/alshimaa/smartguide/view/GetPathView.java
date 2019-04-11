package com.example.alshimaa.smartguide.view;

import com.example.alshimaa.smartguide.model.GetPathData;

import java.util.List;

public interface GetPathView {
    void showGetPathList(List<GetPathData> getPathDataList);
    void showGetPathError();
}
