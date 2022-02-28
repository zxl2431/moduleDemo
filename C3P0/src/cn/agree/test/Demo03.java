package cn.agree.test;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class Demo03 {
    public static void main(String[] args) throws Exception {
        // 加载配置文件
        InputStream is = Demo03.class.getResourceAsStream("/druid.properties");
        Properties pp = new Properties();
        pp.load(is);

        // System.out.println(pp);
        // 创建连接池,使用配置文件中的参数
        DataSource dataSource = DruidDataSourceFactory.createDataSource(pp);

        // for (int i=0; i<10; i++) {
        //     Connection conn = dataSource.getConnection();
        //     System.out.println(conn);
        // }

        Connection conn = dataSource.getConnection();
        // 执行SQL语句
        String sql = "insert into employee VALUES (null, ?,?,?);";

        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, "零充");
        pstmt.setInt(2, 102);
        pstmt.setString(3, "济南");

        int i = pstmt.executeUpdate();
        System.out.println("影响的行数:"+i);

        sql = "select * from employee;";
        ResultSet resultSet = pstmt.executeQuery(sql);

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            int age = resultSet.getInt("age");
            String addr = resultSet.getString("address");

            System.out.println(id+"---"+name+"---"+age+"---"+addr);
        }


        pstmt.close();
        conn.close();
    }
}
