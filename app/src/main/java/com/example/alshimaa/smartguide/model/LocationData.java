package com.example.alshimaa.smartguide.model;

public class LocationData {
    Double lat;
    Double lng;
    double speed;
    double status;

    public LocationData(Double lat, Double lng, double speed) {
        this.lat = lat;
        this.lng = lng;
        this.speed = speed;
    }
}
