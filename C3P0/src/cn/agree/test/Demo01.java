package cn.agree.test;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Demo01 {
    public static void main(String[] args) throws SQLException {
        // 方式一:使用默认配置(default-config)
        // ComboPooledDataSource ds = new ComboPooledDataSource();
        // Connection connection = ds.getConnection();

        // 方式二: 使用命名配置
        ComboPooledDataSource ds = new ComboPooledDataSource("agreec3p0");
        Connection connection = ds.getConnection();
        // String sql = "select * from employee where id = ?";
        String sql = "insert into employee VALUES (null, ?,?,?);";

        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setString(1, "李敏");
        pstmt.setInt(2, 2);
        pstmt.setString(3, "武汉");

        int i = pstmt.executeUpdate();
        // if (rs.next()) {
        //     System.out.println(rs.getString("name")+rs.getString("age")+rs.getString("address"));
        // }

        pstmt.close();
        connection.close();

    }
}
