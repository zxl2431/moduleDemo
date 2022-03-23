package cn.agree.dao;

import cn.agree.pojo.User01;
import cn.agree.utils.JdbcUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class SearchDao {

    public List<User01> findUserByLikeName(String word) {
        System.out.println("SearchDao.findUserByLikeName...");
        // 创建JdbcTemplate
        JdbcTemplate jdbcTemplate = new JdbcTemplate(JdbcUtils.getDataSource());
        String sql = "select * from user where name like ? limit 0,6";
        // 执行查询操作
        List<User01> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<User01>(User01.class), "%"+word+"%");
        return list;

    }
}
