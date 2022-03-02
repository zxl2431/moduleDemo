package cn.agree.demo;

import cn.agree.utils.JdbcUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class Demo03 {
    public static void main(String[] args) {
        // test01();
        // test02();
        // test03();
        // test04();
        // test05();
        // test06();
    }

    // 查询返回的是一个整数
    public static void test01() {
        String sql = "select pid from product where price = 18888;";

        JdbcTemplate jdbcTemplate = new JdbcTemplate(JdbcUtils.getDataSource());
        long forInt = jdbcTemplate.queryForLong(sql);
        System.out.println(forInt);
    }

    // queryForObject()
    public static void test02() {
        String sql = "SELECT pname FROM product WHERE price=7777";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(JdbcUtils.getDataSource());
        String str = jdbcTemplate.queryForObject(sql, String.class);
        System.out.println(str);
    }

    // queryForMap()
    public static void test03() {
        String sql = "SELECT * FROM product WHERE pid=?;";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(JdbcUtils.getDataSource());
        Map<String, Object> map = jdbcTemplate.queryForMap(sql, 6);

        System.out.println(map);

    }

    // queryForList()
    // 返回一个List集合, List里面存放的是Map类型的数据
    public static void test04() {
        String sql = "SELECT * FROM product WHERE pid<?;";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(JdbcUtils.getDataSource());
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql, 8);

        for (Map<String, Object> map : maps) {
            System.out.println(map);
        }
    }

    // query
    // 执行查询语句, 返回一个List集合, List中存放的是RowMapper指定类型的数据
    public static void test05() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(JdbcUtils.getDataSource());

        // 查询数据的SQL语句
        String sql = "SELECT * FROM product;";

        List<Product> list = jdbcTemplate.query(sql, new RowMapper<Product>() {

            @Override
            public Product mapRow(ResultSet resultSet, int i) throws SQLException {
                Product product = new Product();
                product.setPid(resultSet.getInt("pid"));
                product.setName(resultSet.getString("pname"));
                product.setPrice(resultSet.getDouble("price"));
                return product;
            }
        });

        for (Product product : list) {
            System.out.println(product);
        }


    }

    // query 使用BeanPropertyRowMapper做映射
    public static void test06() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(JdbcUtils.getDataSource());

        // 查询数据的SQL语句
        String sql = "SELECT * FROM product;";

        List<Product> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Product.class));

        for (Product product: list) {
            System.out.println(product);
        }

    }


}
