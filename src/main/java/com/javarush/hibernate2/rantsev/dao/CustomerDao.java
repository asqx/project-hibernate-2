package com.javarush.hibernate2.rantsev.dao;

import com.javarush.hibernate2.rantsev.domains.Customer;
import org.hibernate.SessionFactory;

public class CustomerDao extends GenericDao<Customer>{
    public CustomerDao(SessionFactory sessionFactory) {
        super(Customer.class, sessionFactory);
    }
}
