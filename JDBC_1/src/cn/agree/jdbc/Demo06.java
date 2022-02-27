package cn.agree.jdbc;

import cn.agree.utils.JDBCUtils01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Demo06 {
    public static void main(String[] args) throws SQLException {

        //
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入用户名:");
        String name = scanner.nextLine();
        System.out.println("请输入密码:");
        String pswd = scanner.nextLine();



        // 获取连接
        Connection conn = JDBCUtils01.getConnection();
        String sql = "select * from user where name =? and password=?;";
        PreparedStatement prestmt = conn.prepareStatement(sql);

        prestmt.setString(1, name);
        prestmt.setString(2, pswd);

        ResultSet result = prestmt.executeQuery();

        if (result.next()) {
            System.out.println("有结果");
        } else {
            System.out.println("无结果");
        }
    }
}
