package cn.agree.jdbc;

import cn.agree.utils.JDBCUtils01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Demo08 {
    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入账号:");
        String name = sc.nextLine();
        System.out.println("请输入密码:");
        String password = sc.nextLine();

        Connection conn = JDBCUtils01.getConnection();
        String sql = "select * from user where name=? and password=?;";
        PreparedStatement pstmt = conn.prepareStatement(sql);

        pstmt.setString(1, name);
        pstmt.setString(2, password);
        // pstmt.setString(2, "a' or '1'='1");

        ResultSet rs = pstmt.executeQuery();

        if (rs.next()) {
            String name2 = rs.getString("name");
            System.out.println("欢迎:"+ name2);
        } else {
            System.out.println("查无此人!");
        }
        JDBCUtils01.close(conn, pstmt);
    }
}
