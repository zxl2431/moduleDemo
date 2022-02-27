package cn.agree.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;

/*
*  区分原本就在池子里面的连接和新创建的连接
*
* */

public class MyConnectionPool2 {
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

    // 初始化池子
    public MyConnectionPool2() throws SQLException {
        // 初始化的时候, 往容器中存放5个连接对象
        for (int i=0; i<5; i++) {
            Connection connection = DriverManager.getConnection(url, user, password);
            // 这次放的不再是Connection了 而是包装了一层的MyConnection
            Connection conn = new MyConnection(connection);
            pool.add(conn);
        }
    }

    //  从池子里面拿连接
    public Connection getConnectionFromPool() throws SQLException {
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



}
