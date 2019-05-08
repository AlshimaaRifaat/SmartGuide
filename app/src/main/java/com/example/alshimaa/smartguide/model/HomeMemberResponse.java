package com.example.alshimaa.smartguide.model;

import java.io.Serializable;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HomeMemberResponse implements Serializable, Parcelable
{

    @SerializedName("data")
    @Expose
    private List<HomeMemberData> data = null;
    @SerializedName("status")
    @Expose
    private boolean status;
    @SerializedName("error")
    @Expose
    private String error;
    public final static Parcelable.Creator<HomeMemberResponse> CREATOR = new Creator<HomeMemberResponse>() {


        @SuppressWarnings({
                "unchecked"
        })
        public HomeMemberResponse createFromParcel(Parcel in) {
            return new HomeMemberResponse(in);
        }

        public HomeMemberResponse[] newArray(int size) {
            return (new HomeMemberResponse[size]);
        }

    }
            ;
    private final static long serialVersionUID = -8404619508734448036L;

    protected HomeMemberResponse(Parcel in) {
        in.readList(this.data, (HomeMemberData.class.getClassLoader()));
        this.status = ((boolean) in.readValue((boolean.class.getClassLoader())));
        this.error = ((String) in.readValue((String.class.getClassLoader())));
    }

    public HomeMemberResponse() {
    }

    public List<HomeMemberData> getData() {
        return data;
    }

    public void setData(List<HomeMemberData> data) {
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
