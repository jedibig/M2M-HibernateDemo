package com.java.dao;

import com.java.dto.Developer;
import com.java.dto.Project;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class ProjectRepositoryImpl implements ProjectRepository {
    static SessionFactory sf = DeveloperRepositoryImpl.sf;

    @Override
    public boolean insert(Project p) {
        Session s = sf.openSession(); // connection
        s.beginTransaction();
        int id = (int) s.save(p); // save user object, return primary key.
        s.getTransaction().commit();
        s.close();
        return true;
    }

    @Override
    public boolean update(Project project) {
        Session s = sf.openSession(); // connection
        s.beginTransaction();
        s.update(project); // save user object, return primary key.
        s.getTransaction().commit();
        s.close();
        return true;
    }

    @Override
    public Project getById(int projectId) {
        Project project = null;
        try{
            Session s = sf.openSession();
            s.beginTransaction();
            project = s.get(Project.class, projectId);
            s.close();
        } catch (HibernateException e){
            System.out.println(e.getMessage());
        }
        return project;
    }
}
