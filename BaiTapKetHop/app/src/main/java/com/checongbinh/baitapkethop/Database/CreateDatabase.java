package com.checongbinh.baitapkethop.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.checongbinh.baitapkethop.DTO.BaiHat;
import com.checongbinh.baitapkethop.DTO.CaSi;
import com.checongbinh.baitapkethop.DTO.ChiTietBaiHat;
import com.checongbinh.baitapkethop.DTO.HienThiBaiHat;
import com.checongbinh.baitapkethop.DTO.SoVol;
import com.checongbinh.baitapkethop.DTO.TacGia;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nhox on 1/14/2016.
 */
public class CreateDatabase extends SQLiteOpenHelper {

    public static String TABLE_BAIHAT = "BAIHAT";
    public static String TABLE_CHITIETBAIHAT = "CHITIETBAIHAT";
    public static String TABLE_TACGIA = "TACGIA";
    public static String TABLE_SOVOL = "SOVOL";
    public static String TABLE_CASI = "CASI";

    public static String ID = "_id";
    public static String TENBAIHAT_TBBAIHAT = "tenbaihat";

    public static String TENTACGIA_TBTACGIA = "tentacgia";

    public static String TENVOL_TBSOVOL = "tenvol";

    public static String MABAIHAT_TBCHITIET = "mabaihat";
    public static String MATACGIA_TBCHITIET = "matacgia";
    public static String MAVOL_TBCHITIET = "mavol";
    public static String MACASI_TBCHITIET = "macasi";
    public static String LOIBAIHAT_TBCHITIET = "loibaihat";
    public static String UATHICH_TBCHITIET = "loibaihat";

    public static String TENCASI_TBCASI = "tencasi";

    SQLiteDatabase database;

    public CreateDatabase(Context context) {
        super(context, "songDB", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String tableBaiHat = " CREATE TABLE " + TABLE_BAIHAT + " ( " + ID + " INTEGER PRIMARY KEY AUTOINCREMENT , " + TENBAIHAT_TBBAIHAT + " TEXT )";

        String tableTacGia = " CREATE TABLE " + TABLE_TACGIA + " ( " + ID + " INTEGER PRIMARY KEY AUTOINCREMENT , "
                + TENTACGIA_TBTACGIA + " TEXT )";

        String tableSoVol = " CREATE TABLE " + TABLE_SOVOL + " ( " + ID + " INTEGER PRIMARY KEY AUTOINCREMENT , "
                + TENVOL_TBSOVOL + " TEXT )";

        String tableChiTietBaiHat = " CREATE TABLE " + TABLE_CHITIETBAIHAT + " ( " + MABAIHAT_TBCHITIET + " INTEGER , "
                + MATACGIA_TBCHITIET + " INTEGER , " + MAVOL_TBCHITIET + " INTEGER , " + MACASI_TBCHITIET + " INTEGER "
                + LOIBAIHAT_TBCHITIET + " TEXT, " + UATHICH_TBCHITIET + " BOOLEAN, PRIMARY KEY(" + MABAIHAT_TBCHITIET + ", " + MATACGIA_TBCHITIET + ", "
                +MAVOL_TBCHITIET + "," + MACASI_TBCHITIET + " ) )";

        String tableCaSi = " CREATE TABLE " + TABLE_CASI + " ( " + ID + " INTEGER PRIMARY KEY AUTOINCREMENT , "
                + TENCASI_TBCASI + " TEXT )";

        db.execSQL(tableBaiHat);
        db.execSQL(tableSoVol);
        db.execSQL(tableTacGia);
        db.execSQL(tableChiTietBaiHat);
        db.execSQL(tableCaSi);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public long ThemBaiHat(BaiHat baiHat,ChiTietBaiHat chiTietBaiHat){
        database = this.getWritableDatabase();
        ContentValues contentBaiHat = new ContentValues();
        contentBaiHat.put(TENBAIHAT_TBBAIHAT, baiHat.getTenbaihat().toString());

        long id = database.insert(TABLE_BAIHAT,null,contentBaiHat);

        ContentValues contentChiTietBaiHat = new ContentValues();
        contentChiTietBaiHat.put(MABAIHAT_TBCHITIET,id);
        contentChiTietBaiHat.put(MACASI_TBCHITIET,chiTietBaiHat.getMacasi());
        contentChiTietBaiHat.put(MATACGIA_TBCHITIET,chiTietBaiHat.getMatacgia());
        contentChiTietBaiHat.put(MAVOL_TBCHITIET,chiTietBaiHat.getMavol());
        contentChiTietBaiHat.put(LOIBAIHAT_TBCHITIET, chiTietBaiHat.getLoibaihat());

        long result = database.insert(TABLE_CHITIETBAIHAT,null,contentChiTietBaiHat);
        return result;
    }

    public long ThemTacGia(TacGia tacGia){
        database = this.getWritableDatabase();
        ContentValues contentTacGia = new ContentValues();
        contentTacGia.put(TENTACGIA_TBTACGIA,tacGia.getTentacgia());

        long result = database.insert(TABLE_TACGIA,null,contentTacGia);
        return result;
    }

    public long ThemCaSi(CaSi caSi){
        database = this.getWritableDatabase();
        ContentValues contentCaSi = new ContentValues();
        contentCaSi.put(TENCASI_TBCASI,caSi.getTencasi());

        long result = database.insert(TABLE_CASI,null,contentCaSi);
        return result;
    }

    public long ThemVol(SoVol soVol){
        database = this.getWritableDatabase();
        ContentValues contentVol = new ContentValues();
        contentVol.put(TENVOL_TBSOVOL,soVol.getTenvol());

        long result = database.insert(TABLE_SOVOL,null,contentVol);
        return result;
    }


    public List<HienThiBaiHat> LayDanhSachBaiHat(){
        database = this.getWritableDatabase();
        List<HienThiBaiHat> baiHatList = new ArrayList<HienThiBaiHat>();

        String truyvan = "SELECT * FROM " + TABLE_CHITIETBAIHAT + " ct," + TABLE_BAIHAT + " bh WHERE ct.mabaihat=bh._id";
        Cursor cursor = database.rawQuery(truyvan,null);
        cursor.moveToFirst();
        while(!cursor.isAfterLast()){
            HienThiBaiHat baiHat = new HienThiBaiHat();
            baiHat.setId(cursor.getInt(cursor.getColumnIndex(MABAIHAT_TBCHITIET)));
            baiHat.setTenbaihat(cursor.getString(cursor.getColumnIndex(TENBAIHAT_TBBAIHAT)));
            baiHat.setLoibaihat(cursor.getString(cursor.getColumnIndex(LOIBAIHAT_TBCHITIET)));
            baiHatList.add(baiHat);
            cursor.moveToNext();
        }
        return baiHatList;
    }

    public List<TacGia> LayDanhSachTacGia(){
        database = this.getWritableDatabase();
        List<TacGia> listTacGia = new ArrayList<TacGia>();

        String truyvan = "SELECT * FROM " + TABLE_TACGIA;
        Cursor cursor = database.rawQuery(truyvan, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            TacGia tacGia = new TacGia();
            tacGia.setTacgia(cursor.getInt(cursor.getColumnIndex(ID)));
            tacGia.setTentacgia(cursor.getString(cursor.getColumnIndex(TENTACGIA_TBTACGIA)));
            listTacGia.add(tacGia);

            cursor.moveToNext();
        }

        return listTacGia;
    }

    public List<CaSi> LayDanhSachCaSi(){
        database = this.getWritableDatabase();
        List<CaSi> listCaSi = new ArrayList<CaSi>();

        String truyvan = "SELECT * FROM " + TABLE_CASI;
        Cursor cursor = database.rawQuery(truyvan, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            CaSi tacGia = new CaSi();
            tacGia.setId(cursor.getInt(cursor.getColumnIndex(ID)));
            tacGia.setTencasi(cursor.getString(cursor.getColumnIndex(TENCASI_TBCASI)));
            listCaSi.add(tacGia);

            cursor.moveToNext();
        }

        return listCaSi;
    }

    public List<SoVol> LayDanhSachVol(){
        database = this.getWritableDatabase();
        List<SoVol> listVol = new ArrayList<SoVol>();

        String truyvan = "SELECT * FROM " + TABLE_SOVOL;
        Cursor cursor = database.rawQuery(truyvan, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            SoVol soVol = new SoVol();
            soVol.setId(cursor.getInt(cursor.getColumnIndex(ID)));
            soVol.setTenvol(cursor.getString(cursor.getColumnIndex(TENVOL_TBSOVOL)));
            listVol.add(soVol);

            cursor.moveToNext();
        }

        return listVol;
    }
}
