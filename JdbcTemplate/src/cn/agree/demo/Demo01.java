package cn.agree.demo;

import cn.agree.utils.JdbcUtils;

import java.sql.*;

public class Demo01 {
    public static void main(String[] args) throws SQLException {
        Connection conn = JdbcUtils.getConnection();

        // 获取数据库元数据
        DatabaseMetaData metaData1 = conn.getMetaData();
        String url = metaData1.getURL();
        String userName = metaData1.getUserName();
        String driverName = metaData1.getDriverName();

        System.out.println("数据库元数据:"+url+"---"+userName+"---"+driverName);

        String sql = "select * from user where name=? and password=?;";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        // ResultSetMetaData metaData = pstmt.getMetaData();

        // 获取参数元数据
        ParameterMetaData parameterMetaData = pstmt.getParameterMetaData();
        int count = parameterMetaData.getParameterCount();

        System.out.println(count);

        // for (int i=1; i<=count; i++) {
        //     int type = parameterMetaData.getParameterType(i);
        //     System.out.println(type);
        //     System.out.println(parameterMetaData.getParameterTypeName(i));
        // }



        pstmt.setString(1,"admin");
        pstmt.setString(2,"123");

        ResultSet resultSet = pstmt.executeQuery();

        // 获取结果集的元数据
        ResultSetMetaData metaData = resultSet.getMetaData();
        int columnCount = metaData.getColumnCount();

        for (int i=1; i<=count;i++) {
            System.out.println(metaData.getColumnName(i) + "\t");
        }

        while (resultSet.next()) {
            String id = resultSet.getString("id");
            String name = resultSet.getString("name");
            String password = resultSet.getString("password");
            System.out.println(id+"---"+name+"---"+password);
        }

        JdbcUtils.close(conn, pstmt, resultSet);
    }
}
