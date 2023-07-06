package com.javarush.hibernate2.rantsev.dao;

import com.javarush.hibernate2.rantsev.domains.Category;
import org.hibernate.SessionFactory;

public class CategoryDao extends GenericDao<Category> {
    public CategoryDao(SessionFactory sessionFactory) {
        super(Category.class, sessionFactory);
    }
}
