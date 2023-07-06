package com.javarush.hibernate2.rantsev.dao;

import com.javarush.hibernate2.rantsev.domains.FilmText;
import org.hibernate.SessionFactory;

public class FilmTextDao extends GenericDao<FilmText>{
    public FilmTextDao(SessionFactory sessionFactory) {
        super(FilmText.class, sessionFactory);
    }
}
