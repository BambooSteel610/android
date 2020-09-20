package com.checongbinh.demosqlite.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.checongbinh.demosqlite.DTO.NhanVienDTO;
import com.checongbinh.demosqlite.SQLiteHelper.TaoDatabaseNhanVien;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nhox on 12/6/2015.
 */
public class NhanVienDAO {
    SQLiteDatabase database;
    TaoDatabaseNhanVien taoDatabaseNhanVien;
    String[] columnNhanVien = {TaoDatabaseNhanVien.ID_TBNHANVIEN,TaoDatabaseNhanVien.TENNHANVIEN_TBNHANVIEN};

    public NhanVienDAO(Context context){
        taoDatabaseNhanVien = new TaoDatabaseNhanVien(context);
    }

    public void open(){
        database = taoDatabaseNhanVien.getWritableDatabase();
    }

    public void close(){
        taoDatabaseNhanVien.close();
    }

    public boolean ThemNhanVien(NhanVienDTO nv){
        ContentValues contentValues = new ContentValues();
//        contentValues.put(TaoDatabaseNhanVien.ID_TBNHANVIEN,""); bởi vì tự động tăng
        contentValues.put(TaoDatabaseNhanVien.TENNHANVIEN_TBNHANVIEN,nv.getTennhanvien().toString());

        long id_nhanvien = database.insert(TaoDatabaseNhanVien.TABLE_NHANVIEN,null,contentValues);

        if(id_nhanvien != 0){
            return true;
        }else{
            return false;
        }
    }


    public List<NhanVienDTO> LayDanhSachNhanVien(){
        List<NhanVienDTO> danhSachNhanVien = new ArrayList<NhanVienDTO>();


//        Cursor cursor = database.query(TaoDatabaseNhanVien.TABLE_NHANVIEN,columnNhanVien,null,null,null,null,null);
        String cautruyvan = "select * from " + TaoDatabaseNhanVien.TABLE_NHANVIEN;
        Cursor cursor = database.rawQuery(cautruyvan,null);
        cursor.moveToFirst();
        while(!cursor.isAfterLast()){
            int id_nhanvien = cursor.getInt(cursor.getColumnIndex(TaoDatabaseNhanVien.ID_TBNHANVIEN));
            String nhanvien = cursor.getString(cursor.getColumnIndex(TaoDatabaseNhanVien.TENNHANVIEN_TBNHANVIEN));

            NhanVienDTO nhanVienDTO = new NhanVienDTO();
            nhanVienDTO.set_id(id_nhanvien);
            nhanVienDTO.setTennhanvien(nhanvien);

            danhSachNhanVien.add(nhanVienDTO);
            cursor.moveToNext();
        }


        return danhSachNhanVien;
    }

    public Cursor LayDanhSachNhanVienProvider(String[] projection, String selection, String[] selectionArgs, String sortOrder){
        Cursor cursor = database.query(TaoDatabaseNhanVien.TABLE_NHANVIEN,projection,selection,selectionArgs,null,null,sortOrder);
        return cursor;
    }

    public Cursor LayDanhSachNhanVienTheoIdProvider(String[] projection, String selection, String[] selectionArgs, String sortOrder){
        Cursor cursor = database.query(TaoDatabaseNhanVien.TABLE_NHANVIEN,projection,selection,selectionArgs,null,null,sortOrder);
        return cursor;
    }

    public boolean XoaDuLieu(NhanVienDTO nhanvien){
        // delete from NhanVien Where id = nhanvien.getid();
        int kt = database.delete(TaoDatabaseNhanVien.TABLE_NHANVIEN,TaoDatabaseNhanVien.ID_TBNHANVIEN + " = " + nhanvien.get_id(),null);
        if(kt != 0){
            return true;
        }else{
            return false;
        }
    }

    public boolean CapNhatDuLieu(NhanVienDTO nhanvienmoi){
        ContentValues contentValues = new ContentValues();
        contentValues.put(TaoDatabaseNhanVien.TENNHANVIEN_TBNHANVIEN, nhanvienmoi.getTennhanvien().toString());

        int kt = database.update(TaoDatabaseNhanVien.TABLE_NHANVIEN,contentValues,TaoDatabaseNhanVien.ID_TBNHANVIEN + " = " + nhanvienmoi.get_id(),null);
        if(kt != 0){
            return true;
        }else{
            return false;
        }

    }
}
