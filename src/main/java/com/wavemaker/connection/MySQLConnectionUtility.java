package com.wavemaker.connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class MySQLConnectionUtility {
    private static String MYSQL_HOST = "jdbc:mysql://localhost:3306/DetailsOfUser";
    private static String MYSQL_USER_NAME = "root";
    private static String MYSQL_PASSWORD = "Pramati@123";
    private static Connection connection;

    public static Connection getConnection() {
        if (connection == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(MYSQL_HOST, MYSQL_USER_NAME, MYSQL_PASSWORD);
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("SQL Exception while Creating Mysql Connection " + MYSQL_HOST + " With User " + MYSQL_USER_NAME);
            }
            catch(ClassNotFoundException e){
                e.printStackTrace();
            }
        }
        return connection;
    }
}