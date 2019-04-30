package com.example.alshimaa.smartguide.model;

import java.io.Serializable;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NotificationsResponse implements Serializable, Parcelable
{

    @SerializedName("data")
    @Expose
    private List<NotificationsData> data = null;
    @SerializedName("status")
    @Expose
    private boolean status;
    @SerializedName("error")
    @Expose
    private String error;
    public final static Parcelable.Creator<NotificationsResponse> CREATOR = new Creator<NotificationsResponse>() {


        @SuppressWarnings({
                "unchecked"
        })
        public NotificationsResponse createFromParcel(Parcel in) {
            return new NotificationsResponse(in);
        }

        public NotificationsResponse[] newArray(int size) {
            return (new NotificationsResponse[size]);
        }

    }
            ;
    private final static long serialVersionUID = -4145808364614758742L;

    protected NotificationsResponse(Parcel in) {
        in.readList(this.data, (NotificationsData.class.getClassLoader()));
        this.status = ((boolean) in.readValue((boolean.class.getClassLoader())));
        this.error = ((String) in.readValue((String.class.getClassLoader())));
    }

    public NotificationsResponse() {
    }

    public List<NotificationsData> getData() {
        return data;
    }

    public void setData(List<NotificationsData> data) {
        this.data = data;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(data);
        dest.writeValue(status);
        dest.writeValue(error);
    }

    public int describeContents() {
        return 0;
    }

}