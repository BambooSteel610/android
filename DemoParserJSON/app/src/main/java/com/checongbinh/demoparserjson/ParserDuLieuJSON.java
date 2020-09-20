package com.checongbinh.demoparserjson;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Nhox on 12/28/2015.
 */
public class ParserDuLieuJSON {
    String dulieu;

    public ParserDuLieuJSON(String dulieu){
        this.dulieu = dulieu;
    }

    public void LayDiaChi(){
        try {
            JSONObject object = new JSONObject(dulieu);
            JSONArray results = object.getJSONArray("results");
            for(int i=0; i<results.length(); i++){
                JSONObject objectResult = results.getJSONObject(i);
                Log.d("dulieuJSON",objectResult.getString("formatted_address"));
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void LayLoaiDuLieu(){
        try {
            JSONObject object = new JSONObject(dulieu);
            JSONArray results = object.getJSONArray("results");

            for (int i=0;i<results.length(); i++){
                JSONObject resultObject = results.getJSONObject(i);
                JSONArray address_component = resultObject.getJSONArray("address_components");

                for (int j=0; j<address_component.length(); j++){
                    if(j==2){
                        JSONObject address_componentObject = address_component.getJSONObject(j);
                        JSONArray address_type = address_componentObject.getJSONArray("types");
                        for (int u=0;u<address_type.length();u++){
                            Log.d("dulieuJSON",address_type.getString(u));
                        }
                    }
                }
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }


    }
}
