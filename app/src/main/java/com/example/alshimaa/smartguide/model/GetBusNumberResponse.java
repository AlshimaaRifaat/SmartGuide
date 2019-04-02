package com.example.alshimaa.smartguide.model;

import java.io.Serializable;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetBusNumberResponse implements Serializable, Parcelable
{

    @SerializedName("data")
    @Expose
    private List<GetBusNumberData> data = null;
    @SerializedName("status")
    @Expose
    private boolean status;
    @SerializedName("error")
    @Expose
    private String error;
    public final static Parcelable.Creator<GetBusNumberResponse> CREATOR = new Creator<GetBusNumberResponse>() {


        @SuppressWarnings({
                "unchecked"
        })
        public GetBusNumberResponse createFromParcel(Parcel in) {
            return new GetBusNumberResponse(in);
        }

        public GetBusNumberResponse[] newArray(int size) {
            return (new GetBusNumberResponse[size]);
        }

    }
            ;
    private final static long serialVersionUID = -6202865022789144418L;

    protected GetBusNumberResponse(Parcel in) {
        in.readList(this.data, (GetBusNumberData.class.getClassLoader()));
        this.status = ((boolean) in.readValue((boolean.class.getClassLoader())));
        this.error = ((String) in.readValue((String.class.getClassLoader())));
    }

    public GetBusNumberResponse() {
    }

    public List<GetBusNumberData> getData() {
        return data;
    }

    public void setData(List<GetBusNumberData> data) {
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
