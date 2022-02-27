package cn.agree.test;

import cn.agree.utils.MyConnectionPool2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PoolTest02 {
    public static void main(String[] args) throws SQLException {
        MyConnectionPool2 pool2 = new MyConnectionPool2();

        System.out.println("最开始的连接数:"+ pool2.getCount());
        Connection conn1 = pool2.getConnectionFromPool();
        System.out.println(conn1);
        Connection conn2 = pool2.getConnectionFromPool();
        Connection conn3 = pool2.getConnectionFromPool();
        Connection conn4 = pool2.getConnectionFromPool();
        Connection conn5 = pool2.getConnectionFromPool();
        Connection conn6 = pool2.getConnectionFromPool();
        System.out.println(conn6);

        System.out.println("归还之前的连接数:"+ pool2.getCount());

        String sql = "select * from user where id=?;";
        PreparedStatement prestmt = conn1.prepareStatement(sql);
        prestmt.setInt(1, 1);

        ResultSet resultSet = prestmt.executeQuery();

        if (resultSet.next()) {
            System.out.println(resultSet.getString("name"));
        }

        pool2.addBack(conn5);
        System.out.println("归还之后的连接数:"+pool2.getCount());
        pool2.addBack(conn6);




    }
}
