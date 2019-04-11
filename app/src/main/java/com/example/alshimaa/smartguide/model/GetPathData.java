package com.example.alshimaa.smartguide.model;

import java.io.Serializable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetPathData implements Serializable, Parcelable
{

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("from_to")
    @Expose
    private String fromTo;
    @SerializedName("price")
    @Expose
    private String price;
    @SerializedName("userTokenCompany")
    @Expose
    private String userTokenCompany;
    public final static Parcelable.Creator<GetPathData> CREATOR = new Creator<GetPathData>() {


        @SuppressWarnings({
                "unchecked"
        })
        public GetPathData createFromParcel(Parcel in) {
            return new GetPathData(in);
        }

        public GetPathData[] newArray(int size) {
            return (new GetPathData[size]);
        }

    }
            ;
    private final static long serialVersionUID = 8696043514993786265L;

    protected GetPathData(Parcel in) {
        this.id = ((int) in.readValue((int.class.getClassLoader())));
        this.fromTo = ((String) in.readValue((String.class.getClassLoader())));
        this.price = ((String) in.readValue((String.class.getClassLoader())));
        this.userTokenCompany = ((String) in.readValue((String.class.getClassLoader())));
    }

    public GetPathData() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFromTo() {
        return fromTo;
    }

    public void setFromTo(String fromTo) {
        this.fromTo = fromTo;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getUserTokenCompany() {
        return userTokenCompany;
    }

    public void setUserTokenCompany(String userTokenCompany) {
        this.userTokenCompany = userTokenCompany;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(fromTo);
        dest.writeValue(price);
        dest.writeValue(userTokenCompany);
    }

    public int describeContents() {
        return 0;
    }

}
