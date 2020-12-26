package com.mmc.common.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManagerFactory;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

@SuppressWarnings("unchecked")
@Transactional
@Repository("baseDaoImpl")
public class BaseDaoImpl<T> implements BaseDao<T> {

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @Override
    public Session getSession() {
        return entityManagerFactory.unwrap(SessionFactory.class).openSession();
    }

    @Override
    public HibernateTemplate getTemplate() {
        return null;
    }

    @Override
    public Serializable add(T t) {
        return this.getSession().save(t);
    }

    @Override
    public T get(T t, Long id) {
        return (T) this.getSession().load(t.getClass(), id);
    }

    @Override
    public void update(T obj) {
        Session session = this.getSession();
        Transaction tr = session.beginTransaction();
        session.merge(obj);
        tr.commit();
    }

    @Override
    public void delete(T t, Long id) {
        Session session = this.getSession();
        Transaction tr = session.beginTransaction();
        session.delete(session.load(t.getClass(), id));
        tr.commit();
    }

}
