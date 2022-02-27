package cn.agree.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;

public class MyConnectionPool1 {
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

    public MyConnectionPool1() throws SQLException {
        // 初始化的时候, 往容器中存放5个连接对象
        for (int i=0; i<5; i++) {
            Connection conn = DriverManager.getConnection(url, user, password);
            pool.add(conn);
        }
    }

    public Connection getConnectionFromPool() throws SQLException {
        Connection connection = null;
        if (pool.size() > 0) {
            connection = pool.removeFirst();
        } else {
            // 池子里面没有连接了
            connection = DriverManager.getConnection(url, user, password);
        }
        return connection;
    }

    public int getCount() {
        return pool.size();
    }

    public void addBack(Connection conn) {
        // 如果本来就是池子里面的连接 就归还到池子里面去
        // 如果不是池子里面的连接就直接销毁
        pool.addLast(conn);
    }
}
