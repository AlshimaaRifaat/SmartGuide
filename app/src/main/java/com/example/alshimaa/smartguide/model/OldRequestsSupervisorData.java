package com.example.alshimaa.smartguide.model;

import java.io.Serializable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OldRequestsSupervisorData implements Serializable, Parcelable
{

    @SerializedName("requestId")
    @Expose
    private int requestId;
    @SerializedName("companyId")
    @Expose
    private int companyId;
    @SerializedName("driver_id")
    @Expose
    private int driverId;
    @SerializedName("driverName")
    @Expose
    private String driverName;
    @SerializedName("guideId")
    @Expose
    private int guideId;
    @SerializedName("guideName")
    @Expose
    private String guideName;
    @SerializedName("busId")
    @Expose
    private int busId;
    @SerializedName("busNumber")
    @Expose
    private String busNumber;
    @SerializedName("pathId")
    @Expose
    private int pathId;
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
    private int tripId;
    @SerializedName("status")
    @Expose
    private int status;
    public final static Parcelable.Creator<OldRequestsSupervisorData> CREATOR = new Creator<OldRequestsSupervisorData>() {


        @SuppressWarnings({
                "unchecked"
        })
        public OldRequestsSupervisorData createFromParcel(Parcel in) {
            return new OldRequestsSupervisorData(in);
        }

        public OldRequestsSupervisorData[] newArray(int size) {
            return (new OldRequestsSupervisorData[size]);
        }

    }
            ;
    private final static long serialVersionUID = -6837443104978891020L;

    protected OldRequestsSupervisorData(Parcel in) {
        this.requestId = ((int) in.readValue((int.class.getClassLoader())));
        this.companyId = ((int) in.readValue((int.class.getClassLoader())));
        this.driverId = ((int) in.readValue((int.class.getClassLoader())));
        this.driverName = ((String) in.readValue((String.class.getClassLoader())));
        this.guideId = ((int) in.readValue((int.class.getClassLoader())));
        this.guideName = ((String) in.readValue((String.class.getClassLoader())));
        this.busId = ((int) in.readValue((int.class.getClassLoader())));
        this.busNumber = ((String) in.readValue((String.class.getClassLoader())));
        this.pathId = ((int) in.readValue((int.class.getClassLoader())));
        this.from = ((String) in.readValue((String.class.getClassLoader())));
        this.to = ((String) in.readValue((String.class.getClassLoader())));
        this.startTime = ((String) in.readValue((String.class.getClassLoader())));
        this.startDate = ((String) in.readValue((String.class.getClassLoader())));
        this.tripId = ((int) in.readValue((int.class.getClassLoader())));
        this.status = ((int) in.readValue((int.class.getClassLoader())));
    }

    public OldRequestsSupervisorData() {
    }

    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public int getDriverId() {
        return driverId;
    }

    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public int getGuideId() {
        return guideId;
    }

    public void setGuideId(int guideId) {
        this.guideId = guideId;
    }

    public String getGuideName() {
        return guideName;
    }

    public void setGuideName(String guideName) {
        this.guideName = guideName;
    }

    public int getBusId() {
        return busId;
    }

    public void setBusId(int busId) {
        this.busId = busId;
    }

    public String getBusNumber() {
        return busNumber;
    }

    public void setBusNumber(String busNumber) {
        this.busNumber = busNumber;
    }

    public int getPathId() {
        return pathId;
    }

    public void setPathId(int pathId) {
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

    public int getTripId() {
        return tripId;
    }

    public void setTripId(int tripId) {
        this.tripId = tripId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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
    }

    public int describeContents() {
        return 0;
    }

}
