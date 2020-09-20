package com.checongbinh.demobaseadapter;

/**
 * Created by Nhox on 10/28/2015.
 */
public class Album {
    int HinhAnh;
    String TenAlbum;
    String NgayPhatHanh;
    Boolean kiemtra;

    public Boolean getKiemtra() {
        return kiemtra;
    }

    public void setKiemtra(Boolean kiemtra) {
        this.kiemtra = kiemtra;
    }

    public int getHinhAnh() {
        return HinhAnh;
    }

    public void setHinhAnh(int hinhAnh) {
        HinhAnh = hinhAnh;
    }

    public String getTenAlbum() {
        return TenAlbum;
    }

    public void setTenAlbum(String tenAlbum) {
        TenAlbum = tenAlbum;
    }

    public String getNgayPhatHanh() {
        return NgayPhatHanh;
    }

    public void setNgayPhatHanh(String ngayPhatHanh) {
        NgayPhatHanh = ngayPhatHanh;
    }
}
