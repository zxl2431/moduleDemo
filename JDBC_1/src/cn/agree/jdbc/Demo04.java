package cn.agree.jdbc;

import cn.agree.utils.JDBCUtils01;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo04 {
    public static void main(String[] args) throws SQLException {
        // createTable();
        // addEmployee();
        // updateEmployee();
        deleteEmployee();
    }

    // 删除员工
    public static void deleteEmployee() throws SQLException {
        Connection conn = JDBCUtils01.getConnection();
        Statement stmt = conn.createStatement();

        // 删除id为3的员工
        String sql = "DELETE FROM employee where id=3;";

        int i = stmt.executeUpdate(sql);

        System.out.println("影响的行数: " + i);
        JDBCUtils01.close(conn, stmt);
    }

    // 修改员工
    public static void updateEmployee() throws SQLException {
        Connection conn = JDBCUtils01.getConnection();
        Statement stmt = conn.createStatement();

        // 将id为
        String sql = "UPDATE employee SET address='天津', name='田七' WHERE id=3;";
        int i = stmt.executeUpdate(sql);
        System.out.println("影响的行数: " + i);

        JDBCUtils01.close(conn, stmt);

    }

    // 定义添加员工
    public static void addEmployee() throws SQLException {
        Connection conn = JDBCUtils01.getConnection();
        Statement stmt = conn.createStatement();

        // 添加4个员工
        String sql = "INSERT INTO employee VALUES (NULL, '张三4', 20, '北京'),"
                + " (NULL, '李四4', 21, '南京'),"
                + " (NULL, '王五4', 18, '东京'),"
                + " (NULL, '赵六4', 17, '西安');";

        int i = stmt.executeUpdate(sql);
        System.out.println("影响的行数: " + i);

        JDBCUtils01.close(conn, stmt);
    }


    // 创建表
    public static void createTable() throws SQLException {
        Connection conn = JDBCUtils01.getConnection();
        System.out.println(conn);
        Statement stmt = conn.createStatement();

        String sql = "CREATE TABLE IF NOT EXISTS employee ("
                + " id INT PRIMARY KEY AUTO_INCREMENT,"
                + " name VARCHAR(20) UNIQUE NOT NULL,"
                + " age INT,"
                + " address VARCHAR(50)"
                + ");";

        int i = stmt.executeUpdate(sql);
        System.out.println("ok");

        JDBCUtils01.close(conn, stmt);
    }

}
