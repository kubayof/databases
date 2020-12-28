package com.naofi.controllers.aop;

import org.hibernate.SessionFactory;

public class TransactionAspectBean {
    public final SessionFactory factory;

    public TransactionAspectBean(SessionFactory factory) {
        this.factory = factory;
    }

    public void beginTransaction() {
        factory.getCurrentSession().beginTransaction();
    }

    public void commit() {
        factory.getCurrentSession().getTransaction().commit();
    }

    public void rollback() {
        factory.getCurrentSession().getTransaction().rollback();
    }
}
