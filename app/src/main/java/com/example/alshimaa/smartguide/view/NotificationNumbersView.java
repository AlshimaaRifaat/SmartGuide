package com.example.alshimaa.smartguide.view;

import com.example.alshimaa.smartguide.model.NotificationsData;

import java.util.List;

public interface NotificationNumbersView {
    void showNotificationNumbersList(List<NotificationsData> notificationsDataList);
   /* void showPrice(String price);
    void showEmptyCard();*/
    void showNotificationNumbersError();
}
