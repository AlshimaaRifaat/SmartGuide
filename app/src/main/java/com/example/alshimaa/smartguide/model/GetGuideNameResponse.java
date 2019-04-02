package com.example.alshimaa.smartguide.model;

import java.io.Serializable;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetGuideNameResponse implements Serializable, Parcelable
{

    @SerializedName("data")
    @Expose
    private List<GetGuideNameData> data = null;
    @SerializedName("status")
    @Expose
    private boolean status;
    @SerializedName("error")
    @Expose
    private String error;
    public final static Parcelable.Creator<GetGuideNameResponse> CREATOR = new Creator<GetGuideNameResponse>() {


        @SuppressWarnings({
                "unchecked"
        })
        public GetGuideNameResponse createFromParcel(Parcel in) {
            return new GetGuideNameResponse(in);
        }

        public GetGuideNameResponse[] newArray(int size) {
            return (new GetGuideNameResponse[size]);
        }

    }
            ;
    private final static long serialVersionUID = 2833470899861837378L;

    protected GetGuideNameResponse(Parcel in) {
        in.readList(this.data, (GetGuideNameData.class.getClassLoader()));
        this.status = ((boolean) in.readValue((boolean.class.getClassLoader())));
        this.error = ((String) in.readValue((String.class.getClassLoader())));
    }

    public GetGuideNameResponse() {
    }

    public List<GetGuideNameData> getData() {
        return data;
    }

    public void setData(List<GetGuideNameData> data) {
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
