package cn.agree.service.impl;

import cn.agree.dao.CustomerDao;
import cn.agree.dao.impl.CustomerDaoImpl;
import cn.agree.pojo.Customer;
import cn.agree.service.CustomerService;

public class CustomerServiceImpl implements CustomerService {

    private CustomerDao customerDao = new CustomerDaoImpl();

    @Override
    public void save(Customer customer) {
        customerDao.save(customer);
    }

}
