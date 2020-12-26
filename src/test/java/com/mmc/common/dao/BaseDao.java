package com.mmc.common.dao;

import org.hibernate.Session;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository("baseDao")
public interface BaseDao<T> {
    Session getSession();

    HibernateTemplate getTemplate();

    Serializable add(T t);

    T get(T t, Long id);

    void update(T t);

    void delete(T t, Long id);
}
