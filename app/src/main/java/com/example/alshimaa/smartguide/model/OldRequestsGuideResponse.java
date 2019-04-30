package com.example.alshimaa.smartguide.model;

import java.io.Serializable;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OldRequestsGuideResponse implements Serializable, Parcelable
{

    @SerializedName("data")
    @Expose
    private List<OldRequestsGuideData> data = null;
    @SerializedName("status")
    @Expose
    private boolean status;
    @SerializedName("error")
    @Expose
    private String error;
    public final static Parcelable.Creator<OldRequestsGuideResponse> CREATOR = new Creator<OldRequestsGuideResponse>() {


        @SuppressWarnings({
                "unchecked"
        })
        public OldRequestsGuideResponse createFromParcel(Parcel in) {
            return new OldRequestsGuideResponse(in);
        }

        public OldRequestsGuideResponse[] newArray(int size) {
            return (new OldRequestsGuideResponse[size]);
        }

    }
            ;
    private final static long serialVersionUID = 2912770041657598480L;

    protected OldRequestsGuideResponse(Parcel in) {
        in.readList(this.data, (OldRequestsGuideData.class.getClassLoader()));
        this.status = ((boolean) in.readValue((boolean.class.getClassLoader())));
        this.error = ((String) in.readValue((String.class.getClassLoader())));
    }

    public OldRequestsGuideResponse() {
    }

    public List<OldRequestsGuideData> getData() {
        return data;
    }

    public void setData(List<OldRequestsGuideData> data) {
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
