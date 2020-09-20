package com.checongbinh.baitapkethop.DTO;

/**
 * Created by Nhox on 1/14/2016.
 */
public class HienThiBaiHat {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenbaihat() {
        return tenbaihat;
    }

    public void setTenbaihat(String tenbaihat) {
        this.tenbaihat = tenbaihat;
    }

    public String getLoibaihat() {
        return loibaihat;
    }

    public void setLoibaihat(String loibaihat) {
        this.loibaihat = loibaihat;
    }

    int id;
    String tenbaihat,loibaihat;
}
