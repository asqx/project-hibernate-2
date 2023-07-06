package com.javarush.hibernate2.rantsev.creators;

import com.javarush.hibernate2.rantsev.dao.*;
import com.javarush.hibernate2.rantsev.domains.*;
import com.javarush.hibernate2.rantsev.factory.PersonalSessionFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.concurrent.ThreadLocalRandom;

public class InventoryCreator {
    private final SessionFactory sessionFactory;
    private final FilmDao filmDao;
    private final InventoryDao inventoryDao;
    private final PaymentDao paymentDao;
    private final RentalDao rentalDao;
    private final StoreDao storeDao;

    public InventoryCreator() {
        sessionFactory = PersonalSessionFactory.getSessionFactory();
        filmDao = new FilmDao(sessionFactory);
        inventoryDao = new InventoryDao(sessionFactory);
        paymentDao = new PaymentDao(sessionFactory);
        rentalDao = new RentalDao(sessionFactory);
        storeDao = new StoreDao(sessionFactory);
    }

    public void customerRentInventory(Customer customer) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();

            Film film = filmDao.getFirstAvailableFilmForRent();
            Store store = storeDao.getItems(0, 2).get(ThreadLocalRandom.current().nextInt(2));

            Inventory inventory = new Inventory();
            inventory.setFilm(film);
            inventory.setStore(store);
            inventoryDao.save(inventory);

            Staff staff = store.getStaff();

            Rental rental = new Rental();
            rental.setRentalDate(LocalDateTime.now());
            rental.setCustomer(customer);
            rental.setInventory(inventory);
            rental.setStaff(staff);
            rentalDao.save(rental);

            Payment payment = new Payment();
            payment.setRental(rental);
            payment.setPaymentDate(LocalDateTime.now());
            payment.setCustomer(customer);
            payment.setAmount(BigDecimal.valueOf(44.44));
            payment.setStaff(staff);
            paymentDao.save(payment);

            session.getTransaction().commit();
        }
    }

    public void returnInventoryToStore() {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();

            Rental rental = rentalDao.getAnyUnreturnedRental();
            rental.setReturnDate(LocalDateTime.now());
            rentalDao.save(rental);

            session.getTransaction().commit();
        }
    }


}
