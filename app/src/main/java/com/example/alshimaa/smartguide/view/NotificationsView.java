package com.example.alshimaa.smartguide.view;

import com.example.alshimaa.smartguide.model.NotificationsData;
import com.example.alshimaa.smartguide.model.OldRequestsGuideData;

import java.util.List;

public interface NotificationsView {
    void showNotificationList(List<NotificationsData> notificationsDataList);
    void showNotificationError();
}
