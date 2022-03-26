package cn.agree.demo;

import cn.agree.utils.JdbcUtils;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcTest {

    @Test
    public void jdbcTest() {
        JdbcTemplate tem = new JdbcTemplate(JdbcUtils.getDataSource());
        System.out.println(tem);
    }
}
