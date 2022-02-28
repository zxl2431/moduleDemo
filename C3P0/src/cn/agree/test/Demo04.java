package cn.agree.test;

import cn.agree.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Demo04 {
    public static void main(String[] args) throws SQLException {
        Connection conn = JdbcUtils.getConnection();

        // 执行SQL语句
        String sql = "insert into employee VALUES (null, ?,?,?);";

        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, "林彪");
        pstmt.setInt(2, 99);
        pstmt.setString(3, "山东");

        int i = pstmt.executeUpdate();
        System.out.println("影响的行数:"+i);

        JdbcUtils.close(conn, pstmt);
    }
}
