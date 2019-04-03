package com.example.alshimaa.smartguide.model;

import java.io.Serializable;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetMemeberNameResponse implements Serializable, Parcelable
{

    @SerializedName("data")
    @Expose
    private List<GetMemberNameData> data = null;
    @SerializedName("status")
    @Expose
    private boolean status;
    @SerializedName("error")
    @Expose
    private String error;
    public final static Parcelable.Creator<GetMemeberNameResponse> CREATOR = new Creator<GetMemeberNameResponse>() {


        @SuppressWarnings({
                "unchecked"
        })
        public GetMemeberNameResponse createFromParcel(Parcel in) {
            return new GetMemeberNameResponse(in);
        }

        public GetMemeberNameResponse[] newArray(int size) {
            return (new GetMemeberNameResponse[size]);
        }

    }
            ;
    private final static long serialVersionUID = 3052538492054174973L;

    protected GetMemeberNameResponse(Parcel in) {
        in.readList(this.data, (GetMemberNameData.class.getClassLoader()));
        this.status = ((boolean) in.readValue((boolean.class.getClassLoader())));
        this.error = ((String) in.readValue((String.class.getClassLoader())));
    }

    public GetMemeberNameResponse() {
    }

    public List<GetMemberNameData> getData() {
        return data;
    }

    public void setData(List<GetMemberNameData> data) {
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

