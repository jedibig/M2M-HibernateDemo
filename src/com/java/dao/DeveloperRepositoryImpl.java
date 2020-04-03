package com.java.dao;

import com.java.dto.Developer;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class DeveloperRepositoryImpl implements DeveloperRepository {

    public static SessionFactory sf = null;
    static {
        sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory(); // pool of connections; point to one database;

    }

    @Override
    public boolean insert(Developer u) {
        Session s = sf.openSession(); // connection
        s.beginTransaction();
        int id = (int) s.save(u); // save user object, return primary key.
        s.getTransaction().commit();
        s.close();
        return true;
    }

    @Override
    public boolean update(Developer u) {
        Session s = sf.openSession();
        s.beginTransaction();
        s.update(u);
        s.getTransaction().commit();
        s.close();
        return true;
    }

    @Override
    public Developer getById(int id) {
        Developer user = null;
        try{
            Session s = sf.openSession();
            s.beginTransaction();
            user = s.get(Developer.class, id);
            s.close();
        } catch (HibernateException e){
            System.out.println(e.getMessage());
        }
        return user;
    }
}
