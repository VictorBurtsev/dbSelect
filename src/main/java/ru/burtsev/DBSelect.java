package ru.burtsev;

import java.io.*;
import java.sql.*;

public class DBSelect {

    public static final String driverName = "com.mysql.jdbc.Driver";
    public static final String connectionURL = "jdbc:mysql://localhost:3306/web?useSSL=false&user=root&password=demo";


    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Введите фамилию преподавателя: ");
        String search = reader.readLine(); // Иванов Иван Иванович

        Class.forName(driverName);

        Connection connection = DriverManager.getConnection(connectionURL);
        String sql = "SELECT name, addr, phone FROM teachers WHERE name = '" + search +"' ";
        Statement cmd = connection.createStatement();
        ResultSet resultSet = cmd.executeQuery(sql);

        while (resultSet.next()) {
            String name = resultSet.getString("name");
            String addr = resultSet.getString("addr");
            int phone = resultSet.getInt("phone");

            System.out.printf("%-25s %-25s %d\n", name, addr, phone);
        }

        resultSet.close();



    }
}
