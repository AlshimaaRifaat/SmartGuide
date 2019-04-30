package com.example.alshimaa.smartguide.model;

import java.io.Serializable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NotificationsData implements Serializable, Parcelable
{

    @SerializedName("supervisorName")
    @Expose
    private String supervisorName;
    @SerializedName("driverName")
    @Expose
    private String driverName;
    @SerializedName("guideName")
    @Expose
    private String guideName;
    @SerializedName("headings")
    @Expose
    private String headings;
    @SerializedName("message")
    @Expose
    private String message;
    public final static Parcelable.Creator<NotificationsData> CREATOR = new Creator<NotificationsData>() {


        @SuppressWarnings({
                "unchecked"
        })
        public NotificationsData createFromParcel(Parcel in) {
            return new NotificationsData(in);
        }

        public NotificationsData[] newArray(int size) {
            return (new NotificationsData[size]);
        }

    }
            ;
    private final static long serialVersionUID = 989263587754091418L;

    protected NotificationsData(Parcel in) {
        this.supervisorName = ((String) in.readValue((String.class.getClassLoader())));
        this.driverName = ((String) in.readValue((String.class.getClassLoader())));
        this.guideName = ((String) in.readValue((String.class.getClassLoader())));
        this.headings = ((String) in.readValue((String.class.getClassLoader())));
        this.message = ((String) in.readValue((String.class.getClassLoader())));
    }

    public NotificationsData() {
    }

    public String getSupervisorName() {
        return supervisorName;
    }

    public void setSupervisorName(String supervisorName) {
        this.supervisorName = supervisorName;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getGuideName() {
        return guideName;
    }

    public void setGuideName(String guideName) {
        this.guideName = guideName;
    }

    public String getHeadings() {
        return headings;
    }

    public void setHeadings(String headings) {
        this.headings = headings;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(supervisorName);
        dest.writeValue(driverName);
        dest.writeValue(guideName);
        dest.writeValue(headings);
        dest.writeValue(message);
    }

    public int describeContents() {
        return 0;
    }

}
