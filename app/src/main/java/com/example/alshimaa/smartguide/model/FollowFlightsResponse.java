package com.example.alshimaa.smartguide.model;

import java.io.Serializable;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FollowFlightsResponse implements Serializable, Parcelable
{

    @SerializedName("data")
    @Expose
    private List<FollowFlightsData> data = null;
    @SerializedName("status")
    @Expose
    private boolean status;
    @SerializedName("error")
    @Expose
    private String error;
    public final static Parcelable.Creator<FollowFlightsResponse> CREATOR = new Creator<FollowFlightsResponse>() {


        @SuppressWarnings({
                "unchecked"
        })
        public FollowFlightsResponse createFromParcel(Parcel in) {
            return new FollowFlightsResponse(in);
        }

        public FollowFlightsResponse[] newArray(int size) {
            return (new FollowFlightsResponse[size]);
        }

    }
            ;
    private final static long serialVersionUID = -5144014965749535844L;

    protected FollowFlightsResponse(Parcel in) {
        in.readList(this.data, (FollowFlightsData.class.getClassLoader()));
        this.status = ((boolean) in.readValue((boolean.class.getClassLoader())));
        this.error = ((String) in.readValue((String.class.getClassLoader())));
    }

    public FollowFlightsResponse() {
    }

    public List<FollowFlightsData> getData() {
        return data;
    }

    public void setData(List<FollowFlightsData> data) {
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
