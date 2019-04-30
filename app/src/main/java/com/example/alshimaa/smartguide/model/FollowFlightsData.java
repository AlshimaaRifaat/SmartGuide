package com.example.alshimaa.smartguide.model;

import java.io.Serializable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FollowFlightsData implements Serializable, Parcelable
{

    @SerializedName("tripId")
    @Expose
    private String tripId;
    @SerializedName("tripName")
    @Expose
    private String tripName;
    @SerializedName("companyId")
    @Expose
    private String companyId;
    @SerializedName("companyName")
    @Expose
    private String companyName;
    @SerializedName("guideId")
    @Expose
    private String guideId;
    @SerializedName("guideName")
    @Expose
    private String guideName;
    @SerializedName("supervisorId")
    @Expose
    private String supervisorId;
    @SerializedName("supervisorName")
    @Expose
    private String supervisorName;
    @SerializedName("driverId")
    @Expose
    private String driverId;
    @SerializedName("driverName")
    @Expose
    private String driverName;
    @SerializedName("busName")
    @Expose
    private String busName;
    @SerializedName("numberPassenger")
    @Expose
    private String numberPassenger;
    @SerializedName("dateStart")
    @Expose
    private String dateStart;
    @SerializedName("dateEnd")
    @Expose
    private String dateEnd;
    @SerializedName("from")
    @Expose
    private String from;
    @SerializedName("to")
    @Expose
    private String to;
    @SerializedName("latStart")
    @Expose
    private String latStart;
    @SerializedName("lngStart")
    @Expose
    private String lngStart;
    @SerializedName("latEnd")
    @Expose
    private String latEnd;
    @SerializedName("lngEnd")
    @Expose
    private String lngEnd;
    @SerializedName("price")
    @Expose
    private String price;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("statusId")
    @Expose
    private String statusId;
    public final static Parcelable.Creator<FollowFlightsData> CREATOR = new Creator<FollowFlightsData>() {


        @SuppressWarnings({
                "unchecked"
        })
        public FollowFlightsData createFromParcel(Parcel in) {
            return new FollowFlightsData(in);
        }

        public FollowFlightsData[] newArray(int size) {
            return (new FollowFlightsData[size]);
        }

    }
            ;
    private final static long serialVersionUID = -2963082273590582297L;

    protected FollowFlightsData(Parcel in) {
        this.tripId = ((String) in.readValue((String.class.getClassLoader())));
        this.tripName = ((String) in.readValue((String.class.getClassLoader())));
        this.companyId = ((String) in.readValue((String.class.getClassLoader())));
        this.companyName = ((String) in.readValue((String.class.getClassLoader())));
        this.guideId = ((String) in.readValue((String.class.getClassLoader())));
        this.guideName = ((String) in.readValue((String.class.getClassLoader())));
        this.supervisorId = ((String) in.readValue((String.class.getClassLoader())));
        this.supervisorName = ((String) in.readValue((String.class.getClassLoader())));
        this.driverId = ((String) in.readValue((String.class.getClassLoader())));
        this.driverName = ((String) in.readValue((String.class.getClassLoader())));
        this.busName = ((String) in.readValue((String.class.getClassLoader())));
        this.numberPassenger = ((String) in.readValue((String.class.getClassLoader())));
        this.dateStart = ((String) in.readValue((String.class.getClassLoader())));
        this.dateEnd = ((String) in.readValue((String.class.getClassLoader())));
        this.from = ((String) in.readValue((String.class.getClassLoader())));
        this.to = ((String) in.readValue((String.class.getClassLoader())));
        this.latStart = ((String) in.readValue((String.class.getClassLoader())));
        this.lngStart = ((String) in.readValue((String.class.getClassLoader())));
        this.latEnd = ((String) in.readValue((String.class.getClassLoader())));
        this.lngEnd = ((String) in.readValue((String.class.getClassLoader())));
        this.price = ((String) in.readValue((String.class.getClassLoader())));
        this.status = ((String) in.readValue((String.class.getClassLoader())));
        this.statusId = ((String) in.readValue((String.class.getClassLoader())));
    }

    public FollowFlightsData() {
    }

    public String getTripId() {
        return tripId;
    }

    public void setTripId(String tripId) {
        this.tripId = tripId;
    }

    public String getTripName() {
        return tripName;
    }

    public void setTripName(String tripName) {
        this.tripName = tripName;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getGuideId() {
        return guideId;
    }

    public void setGuideId(String guideId) {
        this.guideId = guideId;
    }

    public String getGuideName() {
        return guideName;
    }

    public void setGuideName(String guideName) {
        this.guideName = guideName;
    }

    public String getSupervisorId() {
        return supervisorId;
    }

    public void setSupervisorId(String supervisorId) {
        this.supervisorId = supervisorId;
    }

    public String getSupervisorName() {
        return supervisorName;
    }

    public void setSupervisorName(String supervisorName) {
        this.supervisorName = supervisorName;
    }

    public String getDriverId() {
        return driverId;
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getBusName() {
        return busName;
    }

    public void setBusName(String busName) {
        this.busName = busName;
    }

    public String getNumberPassenger() {
        return numberPassenger;
    }

    public void setNumberPassenger(String numberPassenger) {
        this.numberPassenger = numberPassenger;
    }

    public String getDateStart() {
        return dateStart;
    }

    public void setDateStart(String dateStart) {
        this.dateStart = dateStart;
    }

    public String getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(String dateEnd) {
        this.dateEnd = dateEnd;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getLatStart() {
        return latStart;
    }

    public void setLatStart(String latStart) {
        this.latStart = latStart;
    }

    public String getLngStart() {
        return lngStart;
    }

    public void setLngStart(String lngStart) {
        this.lngStart = lngStart;
    }

    public String getLatEnd() {
        return latEnd;
    }

    public void setLatEnd(String latEnd) {
        this.latEnd = latEnd;
    }

    public String getLngEnd() {
        return lngEnd;
    }

    public void setLngEnd(String lngEnd) {
        this.lngEnd = lngEnd;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatusId() {
        return statusId;
    }

    public void setStatusId(String statusId) {
        this.statusId = statusId;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(tripId);
        dest.writeValue(tripName);
        dest.writeValue(companyId);
        dest.writeValue(companyName);
        dest.writeValue(guideId);
        dest.writeValue(guideName);
        dest.writeValue(supervisorId);
        dest.writeValue(supervisorName);
        dest.writeValue(driverId);
        dest.writeValue(driverName);
        dest.writeValue(busName);
        dest.writeValue(numberPassenger);
        dest.writeValue(dateStart);
        dest.writeValue(dateEnd);
        dest.writeValue(from);
        dest.writeValue(to);
        dest.writeValue(latStart);
        dest.writeValue(lngStart);
        dest.writeValue(latEnd);
        dest.writeValue(lngEnd);
        dest.writeValue(price);
        dest.writeValue(status);
        dest.writeValue(statusId);
    }

    public int describeContents() {
        return 0;
    }

}