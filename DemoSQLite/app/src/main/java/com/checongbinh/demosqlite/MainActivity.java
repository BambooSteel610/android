package com.checongbinh.demosqlite;

import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.checongbinh.demosqlite.Adapter.CustomNhanVienAdapter;
import com.checongbinh.demosqlite.DAO.NhanVienDAO;
import com.checongbinh.demosqlite.DTO.NhanVienDTO;
import com.checongbinh.demosqlite.Provider.NhanVienProvider;
import com.checongbinh.demosqlite.SQLiteHelper.TaoDatabaseNhanVien;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button btnThemNhanVien,btnXoaNhanVien;
    EditText edTenNhanVien;
    ListView listNhanVien;

    List<NhanVienDTO> dsNhanVien;
    NhanVienDAO nhanVienDAO;
    CustomNhanVienAdapter adapter;
    public static final int REQUEST_CODE_SUA = 1;
    public static final int RESULT_CODE_SUA = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnThemNhanVien = (Button) findViewById(R.id.btnThemNhanVien);
        btnXoaNhanVien = (Button) findViewById(R.id.btnXoaNhanVien);
        edTenNhanVien = (EditText) findViewById(R.id.edTenNhanVien);
        listNhanVien = (ListView) findViewById(R.id.listDanhSachNhanVien);

        dsNhanVien = new ArrayList<NhanVienDTO>();

        nhanVienDAO = new NhanVienDAO(this);
        nhanVienDAO.open();

        dsNhanVien = nhanVienDAO.LayDanhSachNhanVien();

        ContentResolver contentResolver = getContentResolver();
        Uri uri = Uri.parse("content://com.checongbinh.demosqlite.NhanVienProvider/nhanviens");

        Cursor cursor = contentResolver.query(uri, null, null, null, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            Log.d("dulieu_provider",cursor.getString(1));
            cursor.moveToNext();

        }

        ContentResolver contentResolver1 = getContentResolver();
//        Uri uri1 = Uri.parse("content://com.checongbinh.demosqlite.NhanVienProvider/nhanviens/1");
        Uri uri1 = Uri.parse(NhanVienProvider.URI_TABLENHANVIEN);
        String where = "TenNhanVien = 1";
        Cursor cursor1 = contentResolver.query(uri, null, where, null, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            Log.d("dulieu_provider",cursor.getString(1));
            cursor.moveToNext();

        }

        adapter = new CustomNhanVienAdapter(this,R.layout.layout_customlistnhanvien,dsNhanVien);
        listNhanVien.setAdapter(adapter);

        btnThemNhanVien.setOnClickListener(this);
        btnXoaNhanVien.setOnClickListener(this);

        registerForContextMenu(listNhanVien);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.context_menu,menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()){

            case R.id.mnXoa :
                AdapterView.AdapterContextMenuInfo menuInfo = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
                NhanVienDTO nhavien = dsNhanVien.get(menuInfo.position);
                nhanVienDAO.XoaDuLieu(nhavien);
                adapter.remove(nhavien);
                adapter.notifyDataSetChanged();
                ;break;

            case R.id.mnSua :
                AdapterView.AdapterContextMenuInfo menuInfosua = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
                Intent iMoManHinhSua = new Intent(MainActivity.this,SuaNhanVienActivity.class);

                NhanVienDTO nhanviensua = dsNhanVien.get(menuInfosua.position);
                iMoManHinhSua.putExtra("nhanvien",nhanviensua);

                startActivityForResult(iMoManHinhSua,REQUEST_CODE_SUA);
                ;break;
        }
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REQUEST_CODE_SUA){
            switch (resultCode){
                case RESULT_CODE_SUA:
                    NhanVienDTO nhanvienmoi = (NhanVienDTO) data.getSerializableExtra("nhanvien");
                    nhanVienDAO.CapNhatDuLieu(nhanvienmoi);

                    dsNhanVien = nhanVienDAO.LayDanhSachNhanVien();
                    adapter = new CustomNhanVienAdapter(this,R.layout.layout_customlistnhanvien,dsNhanVien);
                    adapter.notifyDataSetChanged();
                    listNhanVien.setAdapter(adapter);
                    ;break;
            }
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnThemNhanVien:

                String tennhanvien = edTenNhanVien.getText().toString();

                NhanVienDTO nhanVienDTO = new NhanVienDTO();
                nhanVienDTO.setTennhanvien(tennhanvien);

                dsNhanVien.add(nhanVienDTO);

                boolean kiemtra = nhanVienDAO.ThemNhanVien(nhanVienDTO);
                if(kiemtra){
                    Toast.makeText(MainActivity.this,"Thêm thành công !",Toast.LENGTH_SHORT).show();
                    adapter.notifyDataSetChanged();
                }
                ;break;

            case R.id.btnXoaNhanVien:
                NhanVienDTO nhanVienDTO1 = dsNhanVien.get(0);
                nhanVienDAO.XoaDuLieu(nhanVienDTO1);
                adapter.remove(nhanVienDTO1);
                adapter.notifyDataSetChanged();
                ;break;

        }
    }
}
