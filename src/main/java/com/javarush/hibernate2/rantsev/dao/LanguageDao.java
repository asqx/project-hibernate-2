package com.javarush.hibernate2.rantsev.dao;

import com.javarush.hibernate2.rantsev.domains.Language;
import org.hibernate.SessionFactory;

public class LanguageDao extends GenericDao<Language>{
    public LanguageDao(SessionFactory sessionFactory) {
        super(Language.class, sessionFactory);
    }
}
