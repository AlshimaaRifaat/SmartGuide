package com.example.alshimaa.smartguide.model;

import java.io.Serializable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FollowFlightsData implements  Parcelable
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
    @SerializedName("memberId")
    @Expose
    private String memberId;
    @SerializedName("memberName")
    @Expose
    private String memberName;
    @SerializedName("driverId")
    @Expose
    private String driverId;
    @SerializedName("driverName")
    @Expose
    private String driverName;
    @SerializedName("busId")
    @Expose
    private String busId;
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
    @SerializedName("startLat")
    @Expose
    private Object startLat;
    @SerializedName("startLng")
    @Expose
    private Object startLng;
    @SerializedName("endLat")
    @Expose
    private Object endLat;
    @SerializedName("endLng")
    @Expose
    private Object endLng;
    @SerializedName("status")
    @Expose
    private String status;
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
    private final static long serialVersionUID = -6307884786033853348L;

    protected FollowFlightsData(Parcel in) {
        this.tripId = ((String) in.readValue((String.class.getClassLoader())));
        this.tripName = ((String) in.readValue((String.class.getClassLoader())));
        this.companyId = ((String) in.readValue((String.class.getClassLoader())));
        this.companyName = ((String) in.readValue((String.class.getClassLoader())));
        this.guideId = ((String) in.readValue((String.class.getClassLoader())));
        this.guideName = ((String) in.readValue((String.class.getClassLoader())));
        this.memberId = ((String) in.readValue((String.class.getClassLoader())));
        this.memberName = ((String) in.readValue((String.class.getClassLoader())));
        this.driverId = ((String) in.readValue((String.class.getClassLoader())));
        this.driverName = ((String) in.readValue((String.class.getClassLoader())));
        this.busId = ((String) in.readValue((String.class.getClassLoader())));
        this.busName = ((String) in.readValue((String.class.getClassLoader())));
        this.numberPassenger = ((String) in.readValue((String.class.getClassLoader())));
        this.dateStart = ((String) in.readValue((String.class.getClassLoader())));
        this.dateEnd = ((String) in.readValue((String.class.getClassLoader())));
        this.from = ((String) in.readValue((String.class.getClassLoader())));
        this.to = ((String) in.readValue((String.class.getClassLoader())));
        this.startLat = ((Object) in.readValue((Object.class.getClassLoader())));
        this.startLng = ((Object) in.readValue((Object.class.getClassLoader())));
        this.endLat = ((Object) in.readValue((Object.class.getClassLoader())));
        this.endLng = ((Object) in.readValue((Object.class.getClassLoader())));
        this.status = ((String) in.readValue((String.class.getClassLoader())));
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

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
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

    public String getBusId() {
        return busId;
    }

    public void setBusId(String busId) {
        this.busId = busId;
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

    public Object getStartLat() {
        return startLat;
    }

    public void setStartLat(Object startLat) {
        this.startLat = startLat;
    }

    public Object getStartLng() {
        return startLng;
    }

    public void setStartLng(Object startLng) {
        this.startLng = startLng;
    }

    public Object getEndLat() {
        return endLat;
    }

    public void setEndLat(Object endLat) {
        this.endLat = endLat;
    }

    public Object getEndLng() {
        return endLng;
    }

    public void setEndLng(Object endLng) {
        this.endLng = endLng;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(tripId);
        dest.writeValue(tripName);
        dest.writeValue(companyId);
        dest.writeValue(companyName);
        dest.writeValue(guideId);
        dest.writeValue(guideName);
        dest.writeValue(memberId);
        dest.writeValue(memberName);
        dest.writeValue(driverId);
        dest.writeValue(driverName);
        dest.writeValue(busId);
        dest.writeValue(busName);
        dest.writeValue(numberPassenger);
        dest.writeValue(dateStart);
        dest.writeValue(dateEnd);
        dest.writeValue(from);
        dest.writeValue(to);
        dest.writeValue(startLat);
        dest.writeValue(startLng);
        dest.writeValue(endLat);
        dest.writeValue(endLng);
        dest.writeValue(status);
    }

    public int describeContents() {
        return 0;
    }

}