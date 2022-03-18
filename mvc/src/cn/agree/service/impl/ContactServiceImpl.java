package cn.agree.service.impl;

import cn.agree.dao.ContactDao;
import cn.agree.dao.impl.ContactDaoImpl;
import cn.agree.domain.Contact;
import cn.agree.service.ContactService;

import java.util.List;

public class ContactServiceImpl implements ContactService {

    private ContactDao contactDao = new ContactDaoImpl();

    @Override
    public List<Contact> queryAll() {
        return contactDao.queryAll();
    }
}
