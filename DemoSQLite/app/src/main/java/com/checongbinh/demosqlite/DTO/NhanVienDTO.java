package com.checongbinh.demosqlite.DTO;

import java.io.Serializable;

/**
 * Created by Nhox on 12/6/2015.
 */
public class NhanVienDTO implements Serializable {
    int _id;
    String tennhanvien;

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getTennhanvien() {
        return tennhanvien;
    }

    public void setTennhanvien(String tennhanvien) {
        this.tennhanvien = tennhanvien;
    }


}
