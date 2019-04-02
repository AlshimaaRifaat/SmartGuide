package com.example.alshimaa.smartguide.model;

import java.io.Serializable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetBusNumberData implements  Parcelable
{

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("numberBus")
    @Expose
    private String numberBus;
    @SerializedName("plateNumber")
    @Expose
    private String plateNumber;
    @SerializedName("numberChairs")
    @Expose
    private String numberChairs;
    @SerializedName("company_id")
    @Expose
    private String companyId;
    public final static Parcelable.Creator<GetBusNumberData> CREATOR = new Creator<GetBusNumberData>() {


        @SuppressWarnings({
                "unchecked"
        })
        public GetBusNumberData createFromParcel(Parcel in) {
            return new GetBusNumberData(in);
        }

        public GetBusNumberData[] newArray(int size) {
            return (new GetBusNumberData[size]);
        }

    }
            ;
    private final static long serialVersionUID = 7526251199665745319L;

    protected GetBusNumberData(Parcel in) {
        this.id = ((String) in.readValue((String.class.getClassLoader())));
        this.name = ((String) in.readValue((String.class.getClassLoader())));
        this.numberBus = ((String) in.readValue((String.class.getClassLoader())));
        this.plateNumber = ((String) in.readValue((String.class.getClassLoader())));
        this.numberChairs = ((String) in.readValue((String.class.getClassLoader())));
        this.companyId = ((String) in.readValue((String.class.getClassLoader())));
    }

    public GetBusNumberData() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumberBus() {
        return numberBus;
    }

    public void setNumberBus(String numberBus) {
        this.numberBus = numberBus;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getNumberChairs() {
        return numberChairs;
    }

    public void setNumberChairs(String numberChairs) {
        this.numberChairs = numberChairs;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(name);
        dest.writeValue(numberBus);
        dest.writeValue(plateNumber);
        dest.writeValue(numberChairs);
        dest.writeValue(companyId);
    }

    public int describeContents() {
        return 0;
    }

}
