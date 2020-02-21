package com.smartex.buyit.models;

import android.os.Parcel;
import android.os.Parcelable;

public class Reviews implements Parcelable {
    private int groceryId, userId;
    private String text, date, userName;

    protected Reviews(Parcel in) {
        groceryId = in.readInt();
        userId = in.readInt();
        text = in.readString();
        date = in.readString();
        userName = in.readString();
    }

    public static final Creator<Reviews> CREATOR = new Creator<Reviews>() {
        @Override
        public Reviews createFromParcel(Parcel in) {
            return new Reviews(in);
        }

        @Override
        public Reviews[] newArray(int size) {
            return new Reviews[size];
        }
    };

    @Override
    public String toString() {
        return "Reviews{" +
                "groceryId=" + groceryId +
                ", userId=" + userId +
                ", text='" + text + '\'' +
                ", date='" + date + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }

    public int getGroceryId() {
        return groceryId;
    }

    public void setGroceryId(int groceryId) {
        this.groceryId = groceryId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Reviews(int groceryId, int userId, String text, String date, String userName) {
        this.groceryId = groceryId;
        this.userId = userId;
        this.text = text;
        this.date = date;
        this.userName = userName;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(groceryId);
        dest.writeInt(userId);
        dest.writeString(text);
        dest.writeString(date);
        dest.writeString(userName);
    }
}
