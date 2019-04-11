package com.example.alshimaa.smartguide.model;

import java.io.Serializable;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetPathResponse implements Serializable, Parcelable
{

    @SerializedName("data")
    @Expose
    private List<GetPathData> data = null;
    @SerializedName("status")
    @Expose
    private boolean status;
    @SerializedName("error")
    @Expose
    private String error;
    public final static Parcelable.Creator<GetPathResponse> CREATOR = new Creator<GetPathResponse>() {


        @SuppressWarnings({
                "unchecked"
        })
        public GetPathResponse createFromParcel(Parcel in) {
            return new GetPathResponse(in);
        }

        public GetPathResponse[] newArray(int size) {
            return (new GetPathResponse[size]);
        }

    }
            ;
    private final static long serialVersionUID = -3537301796037145070L;

    protected GetPathResponse(Parcel in) {
        in.readList(this.data, (GetPathData.class.getClassLoader()));
        this.status = ((boolean) in.readValue((boolean.class.getClassLoader())));
        this.error = ((String) in.readValue((String.class.getClassLoader())));
    }

    public GetPathResponse() {
    }

    public List<GetPathData> getData() {
        return data;
    }

    public void setData(List<GetPathData> data) {
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
