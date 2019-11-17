package com.example.saro.smartfarm;

public class places {
    String places,total,cropname,nam,mob_no;

    public places(String places, String total, String cropname,String nam,String mob_no) {
        this.places = places;
        this.total = total;
        this.cropname = cropname;
        this.nam=nam;
        this.mob_no=mob_no;
    }

    public String getMob_no() {
        return mob_no;
    }

    public void setMob_no(String mob_no) {
        this.mob_no = mob_no;
    }

    public String getNam() {
        return nam;
    }

    public void setNam(String nam) {
        this.nam = nam;
    }

    public String getPlaces() {
        return places;
    }

    public void setPlaces(String places) {
        this.places = places;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getCropname() {
        return cropname;
    }

    public void setCropname(String cropname) {
        this.cropname = cropname;
    }
}
