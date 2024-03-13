package com.codeventsl.wildLifeManagementSystem.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {
    private static DBConnection dbConnection;
    private final Connection connection;
    private static final Properties props = new Properties();
    private static final String url = "jdbc:mysql://localhost:3306/wildAnimalManagementSystem";

    static{
        props.setProperty("user", "root");
        props.setProperty("password", "1234");
    }

    private DBConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        this.connection = DriverManager.getConnection(url,props);
    }

    public static DBConnection getInstance() throws SQLException, ClassNotFoundException {
        return (dbConnection == null) ? dbConnection = new DBConnection() : dbConnection;
    }

    public Connection getConnection() {
        return connection;
    }
}
