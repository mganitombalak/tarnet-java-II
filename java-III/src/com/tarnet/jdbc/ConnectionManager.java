package com.tarnet.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
    public static String ConnectionUrl;
    public static String UserName;
    public static String Password;
    private static Connection Connection;

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        //STEP 1. LOAD DRIVER
        Class.forName("org.h2.Driver");
        if (Connection == null) {
            // STEP 2. CREATE CONNECTION
            Connection = DriverManager.getConnection(ConnectionUrl,UserName,Password);
        }
        return Connection;
    }
}
