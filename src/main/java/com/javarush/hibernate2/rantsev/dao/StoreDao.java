package com.javarush.hibernate2.rantsev.dao;

import com.javarush.hibernate2.rantsev.domains.Store;
import org.hibernate.SessionFactory;

public class StoreDao extends GenericDao<Store>{
    public StoreDao(SessionFactory sessionFactory) {
        super(Store.class, sessionFactory);
    }
}
