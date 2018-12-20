package com.gmail.plmcpesar.k12schoolsearch.models;

public class LocationModel {

    private String id;
    private String address;
    private String image;
    private String latitude;
    private String longitude;
    private String desc;


    public LocationModel() {
    }

    public LocationModel(String id, String address, String image, String latitude, String longitude, String desc) {
        this.id = id;
        this.address = address;
        this.image = image;
        this.latitude = latitude;
        this.longitude = longitude;
        this.desc = desc;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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


    public String getLatitude() {
        return latitude;
    }

    public double setLatitude(String latitude) {
        this.latitude = latitude;
        return 0;
    }

    public String getLongitude() {
        return longitude;
    }

    public double setLng(String longitude) {
        this.longitude = longitude;
        return 0;
    }
}
