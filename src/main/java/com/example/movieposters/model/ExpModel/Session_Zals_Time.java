package com.example.movieposters.model.ExpModel;

import android.os.Parcel;
import android.os.Parcelable;

public class Session_Zals_Time implements Parcelable {

    public final String name;

    public Session_Zals_Time(String name) {
        this.name = name;
    }

    protected Session_Zals_Time(Parcel in) {
        name = in.readString();
    }

    public static final Creator<Session_Zals_Time> CREATOR = new Creator<Session_Zals_Time>() {
        @Override
        public Session_Zals_Time createFromParcel(Parcel in) {
            return new Session_Zals_Time(in);
        }

        @Override
        public Session_Zals_Time[] newArray(int size) {
            return new Session_Zals_Time[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
    }
}
