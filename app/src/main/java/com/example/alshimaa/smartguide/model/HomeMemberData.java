package com.example.alshimaa.smartguide.model;

import java.io.Serializable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HomeMemberData implements Serializable, Parcelable
{

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("userToken")
    @Expose
    private String userToken;
    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("mobile")
    @Expose
    private String mobile;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("ssn")
    @Expose
    private String ssn;
    @SerializedName("nationality")
    @Expose
    private String nationality;
    @SerializedName("player_ids")
    @Expose
    private Object playerIds;
    @SerializedName("status")
    @Expose
    private String status;
    public final static Parcelable.Creator<HomeMemberData> CREATOR = new Creator<HomeMemberData>() {


        @SuppressWarnings({
                "unchecked"
        })
        public HomeMemberData createFromParcel(Parcel in) {
            return new HomeMemberData(in);
        }

        public HomeMemberData[] newArray(int size) {
            return (new HomeMemberData[size]);
        }

    }
            ;
    private final static long serialVersionUID = 4396456830614658461L;

    protected HomeMemberData(Parcel in) {
        this.id = ((int) in.readValue((int.class.getClassLoader())));
        this.name = ((String) in.readValue((String.class.getClassLoader())));
        this.image = ((String) in.readValue((String.class.getClassLoader())));
        this.userToken = ((String) in.readValue((String.class.getClassLoader())));
        this.phone = ((String) in.readValue((String.class.getClassLoader())));
        this.mobile = ((String) in.readValue((String.class.getClassLoader())));
        this.address = ((String) in.readValue((String.class.getClassLoader())));
        this.ssn = ((String) in.readValue((String.class.getClassLoader())));
        this.nationality = ((String) in.readValue((String.class.getClassLoader())));
        this.playerIds = ((Object) in.readValue((Object.class.getClassLoader())));
        this.status = ((String) in.readValue((String.class.getClassLoader())));
    }

    public HomeMemberData() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getUserToken() {
        return userToken;
    }

    public void setUserToken(String userToken) {
        this.userToken = userToken;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public Object getPlayerIds() {
        return playerIds;
    }

    public void setPlayerIds(Object playerIds) {
        this.playerIds = playerIds;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(name);
        dest.writeValue(image);
        dest.writeValue(userToken);
        dest.writeValue(phone);
        dest.writeValue(mobile);
        dest.writeValue(address);
        dest.writeValue(ssn);
        dest.writeValue(nationality);
        dest.writeValue(playerIds);
        dest.writeValue(status);
    }

    public int describeContents() {
        return 0;
    }

}
