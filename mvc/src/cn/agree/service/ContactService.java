package cn.agree.service;

import cn.agree.domain.Contact;

import java.util.List;

public interface ContactService {
    /*
    *  查询所有联系人的方法
    * */
    List<Contact> queryAll();
}
