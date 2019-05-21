package com.example.alshimaa.smartguide.model;

import java.io.Serializable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetTripsMemberSupervisorData implements Serializable, Parcelable
{

    @SerializedName("tripId")
    @Expose
    private int tripId;
    @SerializedName("tripName")
    @Expose
    private String tripName;
    @SerializedName("companyId")
    @Expose
    private int companyId;
    @SerializedName("companyName")
    @Expose
    private String companyName;
    @SerializedName("guideName")
    @Expose
    private String guideName;
    @SerializedName("driverName")
    @Expose
    private String driverName;
    @SerializedName("busName")
    @Expose
    private String busName;
    @SerializedName("numberPassenger")
    @Expose
    private int numberPassenger;
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
    private double latStart;
    @SerializedName("lngStart")
    @Expose
    private double lngStart;
    @SerializedName("latEnd")
    @Expose
    private double latEnd;
    @SerializedName("lngEnd")
    @Expose
    private double lngEnd;
    @SerializedName("price")
    @Expose
    private String price;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("statusId")
    @Expose
    private int statusId;
    public final static Parcelable.Creator<GetTripsMemberSupervisorData> CREATOR = new Creator<GetTripsMemberSupervisorData>() {


        @SuppressWarnings({
                "unchecked"
        })
        public GetTripsMemberSupervisorData createFromParcel(Parcel in) {
            return new GetTripsMemberSupervisorData(in);
        }

        public GetTripsMemberSupervisorData[] newArray(int size) {
            return (new GetTripsMemberSupervisorData[size]);
        }

    }
            ;
    private final static long serialVersionUID = -2771686785398973219L;

    protected GetTripsMemberSupervisorData(Parcel in) {
        this.tripId = ((int) in.readValue((int.class.getClassLoader())));
        this.tripName = ((String) in.readValue((String.class.getClassLoader())));
        this.companyId = ((int) in.readValue((int.class.getClassLoader())));
        this.companyName = ((String) in.readValue((String.class.getClassLoader())));
        this.guideName = ((String) in.readValue((String.class.getClassLoader())));
        this.driverName = ((String) in.readValue((String.class.getClassLoader())));
        this.busName = ((String) in.readValue((String.class.getClassLoader())));
        this.numberPassenger = ((int) in.readValue((int.class.getClassLoader())));
        this.dateStart = ((String) in.readValue((String.class.getClassLoader())));
        this.dateEnd = ((String) in.readValue((String.class.getClassLoader())));
        this.from = ((String) in.readValue((String.class.getClassLoader())));
        this.to = ((String) in.readValue((String.class.getClassLoader())));
        this.latStart = ((double) in.readValue((double.class.getClassLoader())));
        this.lngStart = ((double) in.readValue((double.class.getClassLoader())));
        this.latEnd = ((double) in.readValue((double.class.getClassLoader())));
        this.lngEnd = ((double) in.readValue((double.class.getClassLoader())));
        this.price = ((String) in.readValue((String.class.getClassLoader())));
        this.status = ((String) in.readValue((String.class.getClassLoader())));
        this.statusId = ((int) in.readValue((int.class.getClassLoader())));
    }

    public GetTripsMemberSupervisorData() {
    }

    public int getTripId() {
        return tripId;
    }

    public void setTripId(int tripId) {
        this.tripId = tripId;
    }

    public String getTripName() {
        return tripName;
    }

    public void setTripName(String tripName) {
        this.tripName = tripName;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getGuideName() {
        return guideName;
    }

    public void setGuideName(String guideName) {
        this.guideName = guideName;
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

    public int getNumberPassenger() {
        return numberPassenger;
    }

    public void setNumberPassenger(int numberPassenger) {
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

    public double getLatStart() {
        return latStart;
    }

    public void setLatStart(double latStart) {
        this.latStart = latStart;
    }

    public double getLngStart() {
        return lngStart;
    }

    public void setLngStart(double lngStart) {
        this.lngStart = lngStart;
    }

    public double getLatEnd() {
        return latEnd;
    }

    public void setLatEnd(double latEnd) {
        this.latEnd = latEnd;
    }

    public double getLngEnd() {
        return lngEnd;
    }

    public void setLngEnd(double lngEnd) {
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

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(tripId);
        dest.writeValue(tripName);
        dest.writeValue(companyId);
        dest.writeValue(companyName);
        dest.writeValue(guideName);
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
