package cn.agree.jdbc;

import cn.agree.pojo.Employee;
import cn.agree.utils.JDBCUtils01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Demo07 {
    public static void main(String[] args) throws SQLException {
        // addEmployee();
        // updateEmployee();
        // deleteEmployee();

        queryEmployee();
    }

    // 向employee表中增加数据
    public static void addEmployee() throws SQLException {
        Connection conn = JDBCUtils01.getConnection();
        String sql = "insert into employee values (null, ?, ? ,?);";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);

        preparedStatement.setString(1, "刘德华");
        preparedStatement.setInt(2, 57);
        preparedStatement.setString(3, "香港");
        int i = preparedStatement.executeUpdate();
        System.out.println("影响的行数:"+ i);

        // 再次设置参数
        preparedStatement.setString(1, "张学友");
        preparedStatement.setInt(2, 55);
        preparedStatement.setString(3, "澳门");
        i = preparedStatement.executeUpdate();
        System.out.println("影响的行数:" + i);

        // 再次设置参数
        preparedStatement.setString(1, "黎明");
        preparedStatement.setInt(2, 52);
        preparedStatement.setString(3, "香港");
        i = preparedStatement.executeUpdate();
        System.out.println("影响的行数:" + i);

        JDBCUtils01.close(conn, preparedStatement);
    }

    // 修改数据
    public static void updateEmployee() throws SQLException {
        Connection conn = JDBCUtils01.getConnection();

        String sql = "update employee set address=? where id=?;";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, "台湾");
        pstmt.setInt(2, 2);
        int i = pstmt.executeUpdate();
        System.out.println("影响的行数:"+ i);

        JDBCUtils01.close(conn, pstmt);
    }

    // 删除数据
    public static void deleteEmployee() throws SQLException {
        Connection conn = JDBCUtils01.getConnection();

        String sql = "DELETE FROM employee where id = ?;";

        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, 2);
        int i = pstmt.executeUpdate();
        System.out.println("影响的行数:"+ i);

        JDBCUtils01.close(conn, pstmt);

    }

    // 查询数据
    public static void queryEmployee() throws SQLException {
        Connection conn = JDBCUtils01.getConnection();
        String sql = "select * from employee where id < ?;";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, 6);

        ResultSet rs = pstmt.executeQuery();

        ArrayList<Employee> list = new ArrayList<>();

        while(rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            int age = rs.getInt("age");
            String address = rs.getString("address");

            Employee e = new Employee(id, name, age, address);

            list.add(e);
        }

        // 输出对象
        for (Employee e : list) {
            System.out.println(e);
        }

        JDBCUtils01.close(conn, pstmt, rs);
    }


}
