package com.javarush.hibernate2.rantsev.dao;

import com.javarush.hibernate2.rantsev.domains.Payment;
import org.hibernate.SessionFactory;

public class PaymentDao extends GenericDao<Payment>{
    public PaymentDao(SessionFactory sessionFactory) {
        super(Payment.class, sessionFactory);
    }
}
