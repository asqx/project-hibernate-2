package com.javarush.hibernate2.rantsev.dao;

import com.javarush.hibernate2.rantsev.domains.Staff;
import org.hibernate.SessionFactory;

public class StaffDao extends GenericDao<Staff>{
    public StaffDao(SessionFactory sessionFactory) {
        super(Staff.class, sessionFactory);
    }
}
