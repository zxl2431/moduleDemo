package cn.agree.jdbc;

import java.sql.*;

public class Demo02 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql:///db1", "root", "root");
        System.out.println(connection);

        Statement statement = connection.createStatement();

        String sql = "select * from category;";
        ResultSet resultSet = statement.executeQuery(sql);

        // 一行一行的取出
        while (resultSet.next()) {
            // 取出一行中的各个列
            int cid = resultSet.getInt("cid");
            String cname = resultSet.getString("cname");
            System.out.println(cid + "==" + cname);

        }

        // 关闭资源
        resultSet.close();
        statement.close();
        connection.close();
    }
}
