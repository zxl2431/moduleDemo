package cn.agree.test;

import cn.agree.utils.MyConnectionPool1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PoolTest01 {
    public static void main(String[] args) throws SQLException {
        MyConnectionPool1 pool1 = new MyConnectionPool1();

        System.out.println("开始池子里有多少连接:"+ pool1.getCount());

        Connection conn = pool1.getConnectionFromPool();

        System.out.println("后来池子里有几个连接:"+pool1.getCount());

        System.out.println(conn);

        String sql = "select * from user where id=?;";
        PreparedStatement prestmt = conn.prepareStatement(sql);
        prestmt.setInt(1, 1);

        ResultSet resultSet = prestmt.executeQuery();

        if (resultSet.next()) {
            System.out.println(resultSet.getString("name"));
        }

        pool1.addBack(conn);

        System.out.println("最后池子里有多少连接:"+ pool1.getCount());


    }
}
