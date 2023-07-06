package com.javarush.hibernate2.rantsev.dao;

import com.javarush.hibernate2.rantsev.domains.Inventory;
import org.hibernate.SessionFactory;

public class InventoryDao extends GenericDao<Inventory>{
    public InventoryDao(SessionFactory sessionFactory) {
        super(Inventory.class, sessionFactory);
    }
}
