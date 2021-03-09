package com.company;

//Created by sadman sakib on 09/05/17.

import com.mysql.jdbc.Connection;

import java.sql.DriverManager;

public class connectConfig {

    public static Connection getConnection() {
        Connection connection = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "root", "");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return connection;
    }


}

