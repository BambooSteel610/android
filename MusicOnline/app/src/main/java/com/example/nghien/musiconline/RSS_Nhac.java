package com.example.nghien.musiconline;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class RSS_Nhac extends Activity {

    ListView listView;
    InputStream inputStream;
    List<BaiViet> dsBaiViet;
    BaiViet baiViet;
    String noidung;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rss);

        listView = (ListView) findViewById(R.id.listTinTuc);
        dsBaiViet = new ArrayList<BaiViet>();

        LayDuLieuXML();

        AdapterTinTuc adapterTinTuc = new AdapterTinTuc(this,R.layout.custom_listview_layout,dsBaiViet);
        listView.setAdapter(adapterTinTuc);


    }

    private void LayDuLieuXML(){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    URL url = new URL("http://kenhmp3.com/rss/vietnam/kenhmp3.rss");
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                    httpURLConnection.connect();

                    inputStream = httpURLConnection.getInputStream();
//                    InputStreamReader reader = new InputStreamReader(inputStream);
//                    BufferedReader bufferedReader = new BufferedReader(reader);
//                    StringBuilder builder = new StringBuilder();
//                    String line = "";
//                    while((line = bufferedReader.readLine()) !=null){
//                        builder.append(line);
//                    }
//
//                    Log.d("du lieu",builder.toString());

                    XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
                    XmlPullParser xmlPullParser = factory.newPullParser();
                    xmlPullParser.setInput(inputStream,null);

                    int events = xmlPullParser.getEventType();
                    while (events != XmlPullParser.END_DOCUMENT){
                        switch (events){

                            case XmlPullParser.START_TAG:
                                String themo = xmlPullParser.getName();
                                if(themo.equals("item")){
                                    baiViet = new BaiViet();
                                }
                                ;break;

                            case XmlPullParser.TEXT:
                                noidung = xmlPullParser.getText();


                                ;break;

                            case XmlPullParser.END_TAG:
                                String thedong = xmlPullParser.getName();

                                if(thedong.equals("title") && baiViet != null){
                                    baiViet.setTitle(noidung);
                                }else if(thedong.equals("description") && baiViet != null){

                                    baiViet.setDescription(noidung);

                                }else if(thedong.equals("link") && baiViet != null){

                                    baiViet.setLink(noidung);

                                }else if(thedong.equals("pubDate") && baiViet != null){
                                    baiViet.setPubdate(noidung);


                                }else if(thedong.equals("item") && baiViet != null){
                                    dsBaiViet.add(baiViet);
                                }

                                ;break;
                        }

                        events = xmlPullParser.next();
                    }


                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (XmlPullParserException e) {
                    e.printStackTrace();
                }
            }
        });

        thread.start();
    }





}
