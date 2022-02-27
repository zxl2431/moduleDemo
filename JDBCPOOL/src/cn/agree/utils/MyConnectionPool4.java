package cn.agree.utils;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.LinkedList;
import java.util.logging.Logger;

public class MyConnectionPool4 implements DataSource {
    private LinkedList<Connection> pool = new LinkedList<>();
    private String user = "root";
    private String password = "root";
    private String url = "jdbc:mysql://localhost:3306/db1";

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public MyConnectionPool4() throws SQLException {
        // 初始化的时候, 往容器中存放5个连接对象
        for (int i=0; i<5; i++) {
            Connection connection = DriverManager.getConnection(url, user, password);
            // 这次放的不再是Connection了 而是包装了一层的MyConnection
            Connection conn = new MyConnection(connection);
            pool.add(conn);
        }
    }

    @Override
    public Connection getConnection() throws SQLException {
        Connection connection = null;

        if (pool.size() > 0) {
            connection = pool.removeFirst();
        } else {
            connection = DriverManager.getConnection(url, user, password);
        }

        return connection;
    }

    public int getCount() {
        return pool.size();
    }

    public void addBack(Connection conn) throws SQLException {
        // 原来池子里面的就归还
        // 原来不是池子里面的就直接销毁
        if (conn instanceof MyConnection) {
            pool.addLast(conn);
        } else {
            conn.close();
        }
    }

    @Override
    public Connection getConnection(String username, String password) throws SQLException {
        return null;
    }

    @Override
    public PrintWriter getLogWriter() throws SQLException {
        return null;
    }

    @Override
    public void setLogWriter(PrintWriter out) throws SQLException {

    }

    @Override
    public void setLoginTimeout(int seconds) throws SQLException {

    }

    @Override
    public int getLoginTimeout() throws SQLException {
        return 0;
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return null;
    }

    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        return null;
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return false;
    }
}
