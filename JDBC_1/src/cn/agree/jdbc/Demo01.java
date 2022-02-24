package cn.agree.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo01 {
    public static void main(String[] args) throws Exception {
        // 注册驱动
        // DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        Class.forName("com.mysql.jdbc.Driver");
        // 连接MySQL 获取连接
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1", "root", "root");
        System.out.println(connection);
        // 获取statement

        Statement stmt = connection.createStatement();

        // 1插入记录
        String sql = "INSERT INTO category (cname) VALUES('手机');";
        int i = stmt.executeUpdate(sql);
        System.out.println("影响的条数:"+ i);


    }
}
