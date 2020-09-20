package com.phananh.demogridview;

import android.graphics.Bitmap;

import java.io.Serializable;

/**
 * Created by Minamino on 1/5/2016.
 */
public class DanhMuc implements Serializable {
    private String idDanhMuc;
    private int hinh;
    private String ten;

    public String getIdDanhMuc() {
        return idDanhMuc;
    }

    public void setIdDanhMuc(String idDanhMuc) {
        this.idDanhMuc = idDanhMuc;
    }

    public int getHinh() {
        return hinh;
    }

    public void setHinh(int hinh) {
        this.hinh = hinh;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public DanhMuc(String idDanhMuc, int hinh, String ten) {
        this.hinh = hinh;
        this.idDanhMuc=idDanhMuc;
        this.ten = ten;
    }
}
