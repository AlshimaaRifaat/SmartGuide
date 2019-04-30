package com.example.alshimaa.smartguide.model;

import java.io.Serializable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OldRequestsGuideData implements Serializable, Parcelable
{

    @SerializedName("requestId")
    @Expose
    private int requestId;
    @SerializedName("companyId")
    @Expose
    private String companyId;
    @SerializedName("driver_id")
    @Expose
    private String driverId;
    @SerializedName("driverName")
    @Expose
    private String driverName;
    @SerializedName("guideId")
    @Expose
    private String guideId;
    @SerializedName("guideName")
    @Expose
    private String guideName;
    @SerializedName("busId")
    @Expose
    private String busId;
    @SerializedName("busNumber")
    @Expose
    private String busNumber;
    @SerializedName("pathId")
    @Expose
    private String pathId;
    @SerializedName("from")
    @Expose
    private String from;
    @SerializedName("to")
    @Expose
    private String to;
    @SerializedName("startTime")
    @Expose
    private String startTime;
    @SerializedName("startDate")
    @Expose
    private String startDate;
    @SerializedName("tripId")
    @Expose
    private String tripId;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("type")
    @Expose
    private String type;
    public final static Parcelable.Creator<OldRequestsGuideData> CREATOR = new Creator<OldRequestsGuideData>() {


        @SuppressWarnings({
                "unchecked"
        })
        public OldRequestsGuideData createFromParcel(Parcel in) {
            return new OldRequestsGuideData(in);
        }

        public OldRequestsGuideData[] newArray(int size) {
            return (new OldRequestsGuideData[size]);
        }

    }
            ;
    private final static long serialVersionUID = -1221128878387578899L;

    protected OldRequestsGuideData(Parcel in) {
        this.requestId = ((int) in.readValue((int.class.getClassLoader())));
        this.companyId = ((String) in.readValue((String.class.getClassLoader())));
        this.driverId = ((String) in.readValue((String.class.getClassLoader())));
        this.driverName = ((String) in.readValue((String.class.getClassLoader())));
        this.guideId = ((String) in.readValue((String.class.getClassLoader())));
        this.guideName = ((String) in.readValue((String.class.getClassLoader())));
        this.busId = ((String) in.readValue((String.class.getClassLoader())));
        this.busNumber = ((String) in.readValue((String.class.getClassLoader())));
        this.pathId = ((String) in.readValue((String.class.getClassLoader())));
        this.from = ((String) in.readValue((String.class.getClassLoader())));
        this.to = ((String) in.readValue((String.class.getClassLoader())));
        this.startTime = ((String) in.readValue((String.class.getClassLoader())));
        this.startDate = ((String) in.readValue((String.class.getClassLoader())));
        this.tripId = ((String) in.readValue((String.class.getClassLoader())));
        this.status = ((String) in.readValue((String.class.getClassLoader())));
        this.type = ((String) in.readValue((String.class.getClassLoader())));
    }

    public OldRequestsGuideData() {
    }

    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
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

    public String getBusId() {
        return busId;
    }

    public void setBusId(String busId) {
        this.busId = busId;
    }

    public String getBusNumber() {
        return busNumber;
    }

    public void setBusNumber(String busNumber) {
        this.busNumber = busNumber;
    }

    public String getPathId() {
        return pathId;
    }

    public void setPathId(String pathId) {
        this.pathId = pathId;
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

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getTripId() {
        return tripId;
    }

    public void setTripId(String tripId) {
        this.tripId = tripId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(requestId);
        dest.writeValue(companyId);
        dest.writeValue(driverId);
        dest.writeValue(driverName);
        dest.writeValue(guideId);
        dest.writeValue(guideName);
        dest.writeValue(busId);
        dest.writeValue(busNumber);
        dest.writeValue(pathId);
        dest.writeValue(from);
        dest.writeValue(to);
        dest.writeValue(startTime);
        dest.writeValue(startDate);
        dest.writeValue(tripId);
        dest.writeValue(status);
        dest.writeValue(type);
    }

    public int describeContents() {
        return 0;
    }

}