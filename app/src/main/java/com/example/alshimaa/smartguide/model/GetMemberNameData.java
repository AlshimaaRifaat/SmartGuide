package com.example.alshimaa.smartguide.model;

import java.io.Serializable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetMemberNameData implements  Parcelable
{

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("email")
    @Expose
    private String email;
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
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("birthday")
    @Expose
    private String birthday;
    @SerializedName("user_token")
    @Expose
    private String userToken;
    @SerializedName("company_id")
    @Expose
    private String companyId;
    @SerializedName("userTokenCompany")
    @Expose
    private String userTokenCompany;
    public final static Parcelable.Creator<GetMemberNameData> CREATOR = new Creator<GetMemberNameData>() {


        @SuppressWarnings({
                "unchecked"
        })
        public GetMemberNameData createFromParcel(Parcel in) {
            return new GetMemberNameData(in);
        }

        public GetMemberNameData[] newArray(int size) {
            return (new GetMemberNameData[size]);
        }

    }
            ;
    private final static long serialVersionUID = 407646789380895118L;

    protected GetMemberNameData(Parcel in) {
        this.id = ((String) in.readValue((String.class.getClassLoader())));
        this.name = ((String) in.readValue((String.class.getClassLoader())));
        this.email = ((String) in.readValue((String.class.getClassLoader())));
        this.phone = ((String) in.readValue((String.class.getClassLoader())));
        this.mobile = ((String) in.readValue((String.class.getClassLoader())));
        this.address = ((String) in.readValue((String.class.getClassLoader())));
        this.ssn = ((String) in.readValue((String.class.getClassLoader())));
        this.nationality = ((String) in.readValue((String.class.getClassLoader())));
        this.image = ((String) in.readValue((String.class.getClassLoader())));
        this.birthday = ((String) in.readValue((String.class.getClassLoader())));
        this.userToken = ((String) in.readValue((String.class.getClassLoader())));
        this.companyId = ((String) in.readValue((String.class.getClassLoader())));
        this.userTokenCompany = ((String) in.readValue((String.class.getClassLoader())));
    }

    public GetMemberNameData() {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getUserToken() {
        return userToken;
    }

    public void setUserToken(String userToken) {
        this.userToken = userToken;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getUserTokenCompany() {
        return userTokenCompany;
    }

    public void setUserTokenCompany(String userTokenCompany) {
        this.userTokenCompany = userTokenCompany;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(name);
        dest.writeValue(email);
        dest.writeValue(phone);
        dest.writeValue(mobile);
        dest.writeValue(address);
        dest.writeValue(ssn);
        dest.writeValue(nationality);
        dest.writeValue(image);
        dest.writeValue(birthday);
        dest.writeValue(userToken);
        dest.writeValue(companyId);
        dest.writeValue(userTokenCompany);
    }

    public int describeContents() {
        return 0;
    }

}
