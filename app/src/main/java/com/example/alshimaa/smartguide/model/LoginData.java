package com.example.alshimaa.smartguide.model;

import java.io.Serializable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginData implements  Parcelable
{

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("userToken")
    @Expose
    private String userToken;
    @SerializedName("role")
    @Expose
    private String role;
    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("companyId")
    @Expose
    private String companyId;
    @SerializedName("ssn")
    @Expose
    private String ssn;
    @SerializedName("nationality")
    @Expose
    private String nationality;
    public final static Parcelable.Creator<LoginData> CREATOR = new Creator<LoginData>() {


        @SuppressWarnings({
                "unchecked"
        })
        public LoginData createFromParcel(Parcel in) {
            return new LoginData(in);
        }

        public LoginData[] newArray(int size) {
            return (new LoginData[size]);
        }

    }
            ;
    private final static long serialVersionUID = -8416246704374721745L;

    protected LoginData(Parcel in) {
        this.name = ((String) in.readValue((String.class.getClassLoader())));
        this.userToken = ((String) in.readValue((String.class.getClassLoader())));
        this.role = ((String) in.readValue((String.class.getClassLoader())));
        this.phone = ((String) in.readValue((String.class.getClassLoader())));
        this.address = ((String) in.readValue((String.class.getClassLoader())));
        this.image = ((String) in.readValue((String.class.getClassLoader())));
        this.companyId = ((String) in.readValue((String.class.getClassLoader())));
        this.ssn = ((String) in.readValue((String.class.getClassLoader())));
        this.nationality = ((String) in.readValue((String.class.getClassLoader())));
    }

    public LoginData() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserToken() {
        return userToken;
    }

    public void setUserToken(String userToken) {
        this.userToken = userToken;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
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

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(name);
        dest.writeValue(userToken);
        dest.writeValue(role);
        dest.writeValue(phone);
        dest.writeValue(address);
        dest.writeValue(image);
        dest.writeValue(companyId);
        dest.writeValue(ssn);
        dest.writeValue(nationality);
    }

    public int describeContents() {
        return 0;
    }

}
