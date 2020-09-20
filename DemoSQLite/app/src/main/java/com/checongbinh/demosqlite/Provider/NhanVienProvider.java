package com.checongbinh.demosqlite.Provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.Nullable;

import com.checongbinh.demosqlite.DAO.NhanVienDAO;

/**
 * Created by Nhox on 12/15/2015.
 */
public class NhanVienProvider extends ContentProvider {

    public static String AUTHOR = "com.checongbinh.demosqlite.NhanVienProvider";
    public static String TABLE_NHANVIEN = "nhanviens";
    public static String TABLE_PHONGBAN = "phongbans";
    public static String URI_TABLENHANVIEN = "content://"+AUTHOR+"/"+TABLE_NHANVIEN;
    // content://com.checongbinh.demosqlite.NhanVienProvider/nhanviens;
    public static UriMatcher uriMatcher ;
    NhanVienDAO nhanVienDAO;
    Cursor cursor;

    @Override
    public boolean onCreate() {
        uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI(AUTHOR,TABLE_NHANVIEN,1); // content://com.checongbinh.demosqlite.NhanVienProvider/nhanviens;
        uriMatcher.addURI(AUTHOR,TABLE_NHANVIEN+"/#",2); // content://com.checongbinh.demosqlite.NhanVienProvider/nhanviens/1;
        uriMatcher.addURI(AUTHOR,TABLE_PHONGBAN,3); // content://com.checongbinh.demosqlite.NhanVienProvider/phongbans;

        nhanVienDAO = new NhanVienDAO(getContext());
        nhanVienDAO.open();
        return false;
    }

    @Nullable
    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        int mactcher = uriMatcher.match(uri);
        switch (mactcher){
            case 1 :
                cursor = nhanVienDAO.LayDanhSachNhanVienProvider(projection, selection, selectionArgs, sortOrder);
                ;break;

            case 2 :
                cursor = nhanVienDAO.LayDanhSachNhanVienTheoIdProvider(projection, selection, selectionArgs, sortOrder);
                ;break;
        }
        ;
        return cursor;
    }

    @Nullable
    @Override
    public String getType(Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues values) {
        return null;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return 0;
    }
}
