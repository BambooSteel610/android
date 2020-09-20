package com.checongbinh.connectsqlserver;

import android.os.AsyncTask;
import android.os.StrictMode;
import android.util.Log;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Nhox on 1/21/2016.
 */
public class ConnectionClass {
    String ip = "10.0.3.2";
    String classs = "net.sourceforge.jtds.jdbc.Driver";
    String db = "Andro";
    String un = "Binh\\Nhox";
    String pass = " ";
//    String duongdan = "jdbc:jtds:sqlserver://" + ip + ";"
//            + "databaseName=" + db + ";user=" + un + ";password="
//            + pass + ";";

    String duongdan = "jdbc:jtds:sqlserver://" + ip + ";"
            + "databaseName=" + db + ";user=" + un + ";instance=Binh\\Nhox;useNTLMv2=true;Integrated Security=true";

    Connection connection;

    public Connection CONN(){

        try {
            Class.forName(classs);
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                    .permitAll().build();
            StrictMode.setThreadPolicy(policy);
            Connection conn = null;
            String ConnURL = duongdan;

            connection = DriverManager.getConnection(ConnURL);

            Log.d("ketnoi",connection.toString());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }


}
