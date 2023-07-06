package com.javarush.hibernate2.rantsev.dao;

import com.javarush.hibernate2.rantsev.domains.Address;
import org.hibernate.SessionFactory;

public class AddressDao extends GenericDao<Address> {
    public AddressDao(SessionFactory sessionFactory) {
        super(Address.class, sessionFactory);
    }
}
