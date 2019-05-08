package com.example.alshimaa.smartguide.model;

import java.io.Serializable;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OldRequestsSupervisorResponse implements Serializable, Parcelable
{

    @SerializedName("data")
    @Expose
    private List<OldRequestsSupervisorData> data = null;
    @SerializedName("status")
    @Expose
    private boolean status;
    @SerializedName("error")
    @Expose
    private String error;
    public final static Parcelable.Creator<OldRequestsSupervisorResponse> CREATOR = new Creator<OldRequestsSupervisorResponse>() {


        @SuppressWarnings({
                "unchecked"
        })
        public OldRequestsSupervisorResponse createFromParcel(Parcel in) {
            return new OldRequestsSupervisorResponse(in);
        }

        public OldRequestsSupervisorResponse[] newArray(int size) {
            return (new OldRequestsSupervisorResponse[size]);
        }

    }
            ;
    private final static long serialVersionUID = 2638060879682300720L;

    protected OldRequestsSupervisorResponse(Parcel in) {
        in.readList(this.data, (OldRequestsSupervisorData.class.getClassLoader()));
        this.status = ((boolean) in.readValue((boolean.class.getClassLoader())));
        this.error = ((String) in.readValue((String.class.getClassLoader())));
    }

    public OldRequestsSupervisorResponse() {
    }

    public List<OldRequestsSupervisorData> getData() {
        return data;
    }

    public void setData(List<OldRequestsSupervisorData> data) {
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
