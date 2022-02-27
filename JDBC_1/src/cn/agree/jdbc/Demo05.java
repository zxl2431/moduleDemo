package cn.agree.jdbc;

import cn.agree.utils.JDBCUtils01;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Demo05 {
    public static void main(String[] args) throws SQLException {
        // 让用户输入账号和密码
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入账号:");
        String name = sc.nextLine();
        System.out.println("请输入密码:");
        String pswd = sc.nextLine();

        // 注册驱动 获取连接
        Connection conn = JDBCUtils01.getConnection();
        Statement stmt = conn.createStatement();
        String sql = "select * from user where name = '" + name + "' and password = '" +pswd + "';";
        ResultSet resultSet = stmt.executeQuery(sql);

        if (resultSet.next()) {
            String nam = resultSet.getString("name");
            System.out.println("欢迎"+nam+"登录成功");
        } else {
            System.out.println("登录失败");
        }

    }
}
