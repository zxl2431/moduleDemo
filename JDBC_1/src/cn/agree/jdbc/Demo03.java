package cn.agree.jdbc;

import java.sql.*;

public class Demo03 {
    public static void main(String[] args) {
        Connection conn = null;
        try {
            // 注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            // 获取连接
            conn = DriverManager.getConnection("jdbc:mysql:///db1", "root", "root");
            // 开启事务
            conn.setAutoCommit(false);
            Statement pstmt = conn.createStatement();

            String sql = "update account set balance = balance -100 where id=1;";
            pstmt.executeUpdate(sql);

            // 模拟异常
            // int i = 10/0;

            //
            sql = "UPDATE account set balance = balance + 100 where id = 2;";
            pstmt.executeUpdate(sql);

            pstmt.close();
            // 成功 事务提交
            System.out.println("成功,事务提交");
            conn.commit();
        }catch (Exception e) {
            // 失败 事务回滚
            try{
                System.out.println("出了异常, 回滚事务");
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
