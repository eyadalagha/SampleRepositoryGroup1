package com.example.iyad.materialdesign01_g2;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by iyad on 7/30/2015.
 */
public class Employee implements Parcelable{

    private String name;
    private int photoId;
    Employee e;
    public static final Creator<Employee> CREATOR = new Creator<Employee>(){

        @Override
        public Employee createFromParcel(Parcel source) {

            return new Employee(source);
        }

        @Override
        public Employee[] newArray(int size) {
            return new Employee[size];
        }
    };

    public Employee(Parcel source){
        String name = source.readString();
        int photoId = source.readInt();
    }

    public Employee(String name, int photoId){
        this.name = name;
        this.photoId = photoId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhotoId() {
        return photoId;
    }

    public void setPhotoId(int photoId) {
        this.photoId = photoId;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(getName());
        dest.writeInt(getPhotoId());
    }

}
