package com.hibernate.SaveData;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestConnection {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/myhiber", "root", "root");
            System.out.println("Connection Successful!");
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
