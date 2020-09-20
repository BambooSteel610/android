package com.checongbinh.demogooglemap;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.PolylineOptions;

import static android.graphics.Color.*;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback, View.OnClickListener, GoogleMap.OnMarkerClickListener {

    GoogleMap map;
    Button btnThemMarker, btnPolyline,btnPolygon,btnCircle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        btnThemMarker = (Button) findViewById(R.id.btnThemMarker);
        btnPolyline = (Button) findViewById(R.id.btnThemPolyline);
        btnPolygon = (Button) findViewById(R.id.btnThemPolygon);
        btnCircle = (Button) findViewById(R.id.btnThemCircle);

        btnThemMarker.setOnClickListener(this);
        btnCircle.setOnClickListener(this);
        btnPolygon.setOnClickListener(this);
        btnPolyline.setOnClickListener(this);
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;
        googleMap.setMyLocationEnabled(true);
        googleMap.getUiSettings().setCompassEnabled(true);

        googleMap.setOnMarkerClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.btnThemMarker:
                ThemMarker();
            ;break;

            case R.id.btnThemPolyline:
                LatLng tranhungdao393 = new LatLng(10.7598442,106.6886641);
                LatLng tranhungdao = new LatLng(10.7598,106.689);
                LatLng tranhungdao1 = new LatLng(10.76136751,106.68984175);
                LatLng tranhungdao2 = new LatLng(10.76100914,106.68827534);

                 PolylineOptions polylineOptions = new PolylineOptions();
                 polylineOptions.add(tranhungdao393);
                 polylineOptions.add(tranhungdao);

                 map.addPolyline(polylineOptions);

                ;break;

            case R.id.btnThemPolygon:
                LatLng tranhungdao3931 = new LatLng(10.7598442,106.6886641);
                LatLng tranhungdao111 = new LatLng(10.7598,106.689);
                LatLng tranhungdao11 = new LatLng(10.76136751,106.68984175);
                LatLng tranhungdao21 = new LatLng(10.76100914,106.68827534);

                Polygon polygon = map.addPolygon(new PolygonOptions()
                        .add(tranhungdao3931, tranhungdao111,tranhungdao11, tranhungdao21)
                        .strokeColor(RED)
                        .fillColor(BLUE));

                ;break;

            case R.id.btnThemCircle:
                LatLng tranhungdao_c = new LatLng(10.7598442,106.6886641);

                CircleOptions circleOptions = new CircleOptions();
                circleOptions.center(tranhungdao_c);
                circleOptions.radius(1000);

                map.addCircle(circleOptions);
                ;break;
        }



    }

    public void ThemMarker(){
        LatLng tranhungdao = new LatLng(10.7598442,106.6886641);

        MarkerOptions vitri1 = new MarkerOptions();
        vitri1.draggable(true);
        vitri1.position(tranhungdao);
        vitri1.title("393 Trần Hưng Đạo Quận 1");
        vitri1.snippet("Đây là trụ sở CSGT");

        Marker marker = map.addMarker(vitri1);
        marker.showInfoWindow();

//        CameraUpdate moveCamera = CameraUpdateFactory.newLatLng(tranhungdao);
//        map.moveCamera(moveCamera);
//
//        CameraUpdate zoomCamera = CameraUpdateFactory.zoomBy(15);
//        map.animateCamera(zoomCamera,3000,null);

//        CameraUpdate movevszoomCamera = CameraUpdateFactory.newLatLngZoom(tranhungdao,15);
//        map.animateCamera(movevszoomCamera,3000,null);

        CameraPosition cameraPosition = CameraPosition.builder()
                .target(tranhungdao)
                .bearing(8.6f)
                .tilt(90)
                .zoom(15).build();

        CameraUpdate cameraUpdate = CameraUpdateFactory.newCameraPosition(cameraPosition);
        map.animateCamera(cameraUpdate,3000,null);
    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        Toast.makeText(MainActivity.this,"" + marker.getId() + " - title : " + marker.getTitle(),Toast.LENGTH_SHORT).show();

        return true;
    }
}
