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

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getStatus() {
        return status;
    }

    public void setStatus(double status) {
        this.status = status;
    }
}
