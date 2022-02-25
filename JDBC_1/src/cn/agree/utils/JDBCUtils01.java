package cn.agree.utils;

import java.security.spec.PSSParameterSpec;
import java.sql.*;

public class JDBCUtils01 {
    // 1. 将固定字符串定义为常量
    private static final String DRIVER_CLASS = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql:///db1";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    // 2.在静态代码块中注册驱动
    // 当这个类加载到内存的时候就走这个静态代码块,再去触发Driver类中的静态代码块
    static {
        try {
            Class.forName(DRIVER_CLASS);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // 3.提供一个静态方法获取连接
    public static Connection getConnection() throws SQLException {
        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        return conn;
    }

    // 4. 重载关闭资源的方法 close()
    public static void close(Connection conn, Statement stmt) {
        close(conn, stmt, null);
    }

    // 5.定义关闭资源方法 close()
    public static void close(Connection conn, Statement stmt, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
