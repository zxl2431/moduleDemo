package cn.agree.dao;


import cn.agree.pojo.User;
import cn.agree.utils.JDBCUtil;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserDaoImpl {

   public User findUser(User user) {
       System.out.println("到了dao层");
       JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtil.getDataSource());
       String sql = "select * from user where name=? and password=?";
       User user1 = null;

       try {
           user1 = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), user.getUsername(), user.getPassword());
       }catch (Exception e) {
           return null;
       }

       return user1;
   }



}
