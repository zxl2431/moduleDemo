package cn.agree.test;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class Demo02 {
    public static void main(String[] args) throws SQLException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        // 获取连接数大于maxPooolSize 超过超时时间就会报超时
        for (int i=0; i<10; i++) {
            Connection connection = dataSource.getConnection();
            System.out.println(connection);
        }



    }
}
