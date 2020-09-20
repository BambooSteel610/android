package com.phananh.demogridview;

import com.parse.ParseFile;

import java.io.Serializable;

/**
 * Created by Minamino on 1/10/2016.
 */
public class MonAn implements Serializable {
    private String idMonAnh;
    private String tenMonAn;
    private ParseFile hinhMonAn;
    private String moTa;

    public MonAn(String idMonAnh, String tenMonAn, ParseFile hinhMonAn, String moTa) {
        this.idMonAnh = idMonAnh;
        this.tenMonAn = tenMonAn;
        this.hinhMonAn = hinhMonAn;
        this.moTa = moTa;
    }

    public String getIdMonAnh() {
        return idMonAnh;
    }

    public void setIdMonAnh(String idMonAnh) {
        this.idMonAnh = idMonAnh;
    }

    public String getTenMonAn() {
        return tenMonAn;
    }

    public void setTenMonAn(String tenMonAn) {
        this.tenMonAn = tenMonAn;
    }

    public ParseFile getHinhMonAn() {
        return hinhMonAn;
    }

    public void setHinhMonAn(ParseFile hinhMonAn) {
        this.hinhMonAn = hinhMonAn;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }
}
