package com.example.alshimaa.smartguide.view;

public interface StartTripView {
    void showStartTripMsg(String Msg);
    void showStartTripError();

    void showPauseTripMsg(String Msg);
    void showPauseTripError();

    void showRequestPauseTripMsg(String Msg);
    void showRequestPauseTripError();

    void showRequestPauseTripGuideMsg(String Msg);
    void showRequestPauseTripGuideError();

    void showEndTripMsg(String Msg);
    void showEndTripError();

}
