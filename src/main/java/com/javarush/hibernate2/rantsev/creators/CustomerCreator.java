package com.javarush.hibernate2.rantsev.creators;

import com.javarush.hibernate2.rantsev.dao.AddressDao;
import com.javarush.hibernate2.rantsev.dao.CityDao;
import com.javarush.hibernate2.rantsev.dao.CustomerDao;
import com.javarush.hibernate2.rantsev.dao.StoreDao;
import com.javarush.hibernate2.rantsev.domains.Address;
import com.javarush.hibernate2.rantsev.domains.City;
import com.javarush.hibernate2.rantsev.domains.Customer;
import com.javarush.hibernate2.rantsev.domains.Store;
import com.javarush.hibernate2.rantsev.factory.PersonalSessionFactory;
import com.javarush.hibernate2.rantsev.util.RandomData;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.concurrent.ThreadLocalRandom;

public class CustomerCreator {

    private final SessionFactory sessionFactory;
    private final AddressDao addressDao;
    private final CityDao cityDao;
    private final CustomerDao customerDao;
    private final StoreDao storeDao;

    public CustomerCreator() {
        sessionFactory = PersonalSessionFactory.getSessionFactory();
        addressDao = new AddressDao(sessionFactory);
        cityDao = new CityDao(sessionFactory);
        customerDao = new CustomerDao(sessionFactory);
        storeDao = new StoreDao(sessionFactory);
    }

    public void createCustomer() {
        String firstName = getRandomCustomer().getFirstName();
        String lastName = getRandomCustomer().getLastName();
        String randomAddress = RandomData.randomAddress();
        String randomPhone = "+01" + ThreadLocalRandom.current().nextInt(100000000,999999999);
        String randomDistrict = RandomData.randomCity();
        String randomEmail = RandomData.randomEmail();
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            Store store = storeDao.getItems(0, 2).get(ThreadLocalRandom.current().nextInt(2));
            City city = cityDao.getRandomItem();

            Address address = new Address();
            address.setAddress(randomAddress);
            address.setPhone(randomPhone);
            address.setCity(city);
            address.setDistrict(randomDistrict);
            addressDao.save(address);

            Customer customer = new Customer();
            customer.setActive(true);
            customer.setEmail(randomEmail);
            customer.setAddress(address);
            customer.setStore(store);
            customer.setFirstName(firstName);
            customer.setLastName(lastName);
            customerDao.save(customer);

            session.getTransaction().commit();
        }
    }

    public Customer getRandomCustomer() {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            Customer customer = customerDao.getRandomItem();
            session.getTransaction().commit();
            return customer;
        }
    }
}
