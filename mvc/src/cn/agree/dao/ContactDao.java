package cn.agree.dao;

import cn.agree.domain.Contact;

import java.util.List;

public interface ContactDao {
    /*
    *  查询所有联系人的方法
    * */
    List<Contact> queryAll();

    /*
    * 添加联系人
    * */
    void add(Contact con);

    /*
    *  删除联系人
    * */
    void delete(int id);

    /*
    *  根据id查询联系人
    * */
    Contact queryById(int id);

}
