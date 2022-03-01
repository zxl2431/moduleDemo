package cn.agree.demo;

import cn.agree.utils.JdbcUtils;
import org.springframework.jdbc.core.JdbcTemplate;

public class Demo02 {
    public static void main(String[] args) {
        // addData();
        // editData();
        deleData();
    }

    // JdbcTemplate执行DDL语句
    public static void CreateTable() {
        // 创建表的SQL语句
        String sql = "CREATE TABLE product("
                + "pid INT PRIMARY KEY AUTO_INCREMENT,"
                + "pname VARCHAR(20),"
                + "price DOUBLE"
                + ");";

        // 创建JdbcTemplate对象要求是传入一个连接池 datasource
        JdbcTemplate jdbcTemplate = new JdbcTemplate(JdbcUtils.getDataSource());
        /*
         *  jdbcTemplate.excute(sql) : DDL语句
         *  jdbcTemplate.update(sql): DML语句
         *  jdbcTemplate.queryXXX(sql): DQL查询语句
         *
         * */
        jdbcTemplate.execute(sql);
    }

    // 添加数据
    public static void addData() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(JdbcUtils.getDataSource());

        String sql = "INSERT INTO product VALUES (NULL, ?, ?);";

        jdbcTemplate.update(sql, "iPhone3GS", 3333);
        jdbcTemplate.update(sql, "iPhone4", 5000);
        jdbcTemplate.update(sql, "iPhone4S", 5001);
        jdbcTemplate.update(sql, "iPhone5", 5555);
        jdbcTemplate.update(sql, "iPhone5C", 3888);
        jdbcTemplate.update(sql, "iPhone5S", 5666);
        jdbcTemplate.update(sql, "iPhone6", 6666);
        jdbcTemplate.update(sql, "iPhone6S", 7000);
        jdbcTemplate.update(sql, "iPhone6SP", 7777);
        jdbcTemplate.update(sql, "iPhoneX", 8888);
    }

    // 修改数据
    public static void editData() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(JdbcUtils.getDataSource());

        String sql = "UPDATE product SET pname=?, price=? WHERE pid=?;";

        int i = jdbcTemplate.update(sql, "XVIII", 18888, 10);
        System.out.println("影响的行数: " + i);
    }

    // 删除数据
    public static void deleData() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(JdbcUtils.getDataSource());
        String sql = "DELETE FROM product WHERE pid=?;";
        int i = jdbcTemplate.update(sql, 7);
        System.out.println("影响的行数: " + i);
    }
}