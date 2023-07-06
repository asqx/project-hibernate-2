package com.javarush.hibernate2.rantsev.factory;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PersonalSessionFactory {
    private static PersonalSessionFactory instance;
    private final SessionFactory sessionFactory;

    private PersonalSessionFactory() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    public static SessionFactory getSessionFactory() {
        if (instance == null) {
            instance = new PersonalSessionFactory();
        }
        return instance.sessionFactory;
    }
}
