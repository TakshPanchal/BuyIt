package com.smartex.buyit.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.smartex.buyit.Utils;

import java.util.ArrayList;

public class GrossaryItems implements Parcelable {
    private int id, popularityPoint, userPoint;
    private String name, des, imgURL, category;
    private double prise;
    private ArrayList<Reviews> reviews;

    protected GrossaryItems(Parcel in) {
        id = in.readInt();
        popularityPoint = in.readInt();
        userPoint = in.readInt();
        name = in.readString();
        des = in.readString();
        imgURL = in.readString();
        category = in.readString();
        prise = in.readDouble();
        reviews = in.createTypedArrayList(Reviews.CREATOR);
    }

    public static final Creator<GrossaryItems> CREATOR = new Creator<GrossaryItems>() {
        @Override
        public GrossaryItems createFromParcel(Parcel in) {
            return new GrossaryItems(in);
        }

        @Override
        public GrossaryItems[] newArray(int size) {
            return new GrossaryItems[size];
        }
    };

    @Override
    public String toString() {
        return "GrossaryItems{" +
                "id=" + id +
                ", popularityPoint=" + popularityPoint +
                ", userPoint=" + userPoint +
                ", name='" + name + '\'' +
                ", des='" + des + '\'' +
                ", imgURL='" + imgURL + '\'' +
                ", category='" + category + '\'' +
                ", prise=" + prise +
                ", reviews=" + reviews +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPopularityPoint() {
        return popularityPoint;
    }

    public void setPopularityPoint(int popularityPoint) {
        this.popularityPoint = popularityPoint;
    }

    public int getUserPoint() {
        return userPoint;
    }

    public void setUserPoint(int userPoint) {
        this.userPoint = userPoint;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrise() {
        return prise;
    }

    public void setPrise(double prise) {
        this.prise = prise;
    }

    public ArrayList<Reviews> getReviews() {
        return reviews;
    }

    public void setReviews(ArrayList<Reviews> reviews) {
        this.reviews = reviews;
    }

    public GrossaryItems(String name, String des, String imgURL, String category, double prise) {
        this.id = Utils.getId();
        this.popularityPoint = 0;
        this.userPoint = 0;
        this.name = name;
        this.des = des;
        this.imgURL = imgURL;
        this.category = category;
        this.prise = prise;
        this.reviews = new ArrayList<>();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeInt(popularityPoint);
        dest.writeInt(userPoint);
        dest.writeString(name);
        dest.writeString(des);
        dest.writeString(imgURL);
        dest.writeString(category);
        dest.writeDouble(prise);
        dest.writeTypedList(reviews);
    }
}
