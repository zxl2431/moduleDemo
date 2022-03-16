package cn.agree.dao;

import cn.agree.pojo.User;
import cn.agree.utils.JDBCUtil;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserDao {

    public static User login(String name, String password) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtil.getDataSource());
        String sql = "select * from user where name=? and password=?";
        User user = null;
        try {
            user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), name, password);
        }catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("dao层查出来的user:"+user);
        return user;

    }
}
