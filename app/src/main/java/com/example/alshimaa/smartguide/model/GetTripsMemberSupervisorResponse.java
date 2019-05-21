package com.example.alshimaa.smartguide.model;

import java.io.Serializable;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetTripsMemberSupervisorResponse implements Serializable, Parcelable
{

    @SerializedName("data")
    @Expose
    private List<GetTripsMemberSupervisorData> data = null;
    @SerializedName("status")
    @Expose
    private boolean status;
    @SerializedName("error")
    @Expose
    private String error;
    public final static Parcelable.Creator<GetTripsMemberSupervisorResponse> CREATOR = new Creator<GetTripsMemberSupervisorResponse>() {


        @SuppressWarnings({
                "unchecked"
        })
        public GetTripsMemberSupervisorResponse createFromParcel(Parcel in) {
            return new GetTripsMemberSupervisorResponse(in);
        }

        public GetTripsMemberSupervisorResponse[] newArray(int size) {
            return (new GetTripsMemberSupervisorResponse[size]);
        }

    }
            ;
    private final static long serialVersionUID = 3499571355575774787L;

    protected GetTripsMemberSupervisorResponse(Parcel in) {
        in.readList(this.data, (GetTripsMemberSupervisorData.class.getClassLoader()));
        this.status = ((boolean) in.readValue((boolean.class.getClassLoader())));
        this.error = ((String) in.readValue((String.class.getClassLoader())));
    }

    public GetTripsMemberSupervisorResponse() {
    }

    public List<GetTripsMemberSupervisorData> getData() {
        return data;
    }

    public void setData(List<GetTripsMemberSupervisorData> data) {
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
