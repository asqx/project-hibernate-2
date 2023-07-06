package com.javarush.hibernate2.rantsev.creators;

import com.javarush.hibernate2.rantsev.dao.*;
import com.javarush.hibernate2.rantsev.domains.*;
import com.javarush.hibernate2.rantsev.factory.PersonalSessionFactory;
import com.javarush.hibernate2.rantsev.util.RandomData;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.math.BigDecimal;
import java.time.Year;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public class FilmCreator {
    private final SessionFactory sessionFactory;
    private final ActorDao actorDao;
    private final CategoryDao categoryDao;
    private final FilmDao filmDao;
    private final FilmTextDao filmTextDao;
    private final LanguageDao languageDao;


    public FilmCreator() {
        sessionFactory = PersonalSessionFactory.getSessionFactory();
        actorDao = new ActorDao(sessionFactory);
        categoryDao = new CategoryDao(sessionFactory);
        filmDao = new FilmDao(sessionFactory);
        filmTextDao = new FilmTextDao(sessionFactory);
        languageDao = new LanguageDao(sessionFactory);
    }

    public void newFilmWasMade() {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();

            Language language = languageDao.getItemsRandom(0, 20).stream().unordered().findAny().get();
            String title = RandomData.getFilmName();
            String description = filmDao.getItemsRandom(0, 10).stream().findAny().get().getDescription();

            Film film = new Film();
            film.setActors(actorDao.getItemsRandom(1, 15));
            film.setRating(Rating.NC17);
            film.setSpecialFeatures(Set.of(Feature.TRAILERS, Feature.COMMENTARIES));
            film.setLength((short) 120);
            film.setReplacementCost(BigDecimal.TEN);
            System.out.println(language.getName());
            film.setLanguage(language);
            film.setDescription(description);
            film.setTitle(title);
            film.setOriginalLanguage(language);
            film.setCategories(categoryDao.getItemsRandom(0, 5));
            film.setYear(Year.now());
            film.setRentalDuration((byte) ((ThreadLocalRandom.current().nextInt(6)) + 1));
            film.setRentalRate(BigDecimal.ZERO);
            filmDao.save(film);

            FilmText filmText = new FilmText();
            filmText.setFilm(film);
            filmText.setId(film.getId());
            filmText.setDescription(description);
            filmText.setTitle(title);
            filmTextDao.save(filmText);

            session.getTransaction().commit();
        }
    }

}
