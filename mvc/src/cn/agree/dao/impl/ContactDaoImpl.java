package cn.agree.dao.impl;

import cn.agree.dao.ContactDao;
import cn.agree.domain.Contact;
import cn.agree.utils.JDBCUtil;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ContactDaoImpl implements ContactDao {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtil.getDataSource());

    @Override
    public List<Contact> queryAll() {
        String sql = "SELECT * FROM contact;";
        List<Contact> query = template.query(sql, new RowMapper<Contact>() {
            @Override
            public Contact mapRow(ResultSet resultSet, int i) throws SQLException {
                Contact contact = new Contact();

                contact.setId(resultSet.getInt("id"));
                contact.setName(resultSet.getString("name"));
                contact.setSex(resultSet.getString("sex"));
                contact.setAge(resultSet.getInt("age"));
                contact.setAddress(resultSet.getString("address"));
                contact.setQq(resultSet.getString("qq"));
                contact.setEmail(resultSet.getString("email"));
                System.out.println("RowMapper封装的结果:"+contact);

                return contact;
            }
        });
        return query;
    }
}
