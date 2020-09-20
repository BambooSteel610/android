package DTO;

import java.io.Serializable;

/**
 * Created by Nhox on 10/15/2015.
 */
public class NhanVien implements Serializable{
    int MaNhanVien;
    String Hoten;
    String GioiTinh;

    public NhanVien (int id , String hoten, String gioitinh){
        MaNhanVien = id;
        Hoten = hoten;
        GioiTinh = gioitinh;
    };

    public int getMaNhanVien() {
        return MaNhanVien;
    }

    public void setMaNhanVien(int maNhanVien) {
        MaNhanVien = maNhanVien;
    }

    public String getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        GioiTinh = gioiTinh;
    }

    public String getHoten() {
        return Hoten;
    }

    public void setHoten(String hoten) {
        Hoten = hoten;
    }


}
