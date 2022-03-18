package cn.agree.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCUtil {

    private static DataSource ds ;
    static {
        //1.创建连接池对象
        Properties properties = new Properties();
        //将配置文件转换成字节输入流
        ClassLoader classLoader = JDBCUtil.class.getClassLoader();
        InputStream in = classLoader.getResourceAsStream("druid.properties");
        //使用properties对象加载流
        try {
            properties.load(in);
            //使用工厂类创建:工厂设计模式
            ds = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取连接池对象
     * @return
     */
    public static DataSource getDataSource(){
        return ds;
    }
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
    public static void close(Connection conn, Statement stm, ResultSet rst) throws SQLException {
        if (rst != null) {
            rst.close();
        }
        close(conn, stm);
    }
    public static void close(Connection conn, Statement stm) throws SQLException {
        if (conn != null) {
            conn.close();
        }
        if (stm != null) {
            stm.close();
        }
    }
}
