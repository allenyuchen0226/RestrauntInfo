package com.example.restrauntInfo.dao;

import com.example.restrauntInfo.entity.Restraunt;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RestrauntDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void addRestraunt(Restraunt restraunt) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(restraunt);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public Restraunt getRestrauntById(int id) {
        Restraunt restraunt = null;
        try (Session session = sessionFactory.openSession()) {
            restraunt = session.get(Restraunt.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return restraunt;
    }

    public List<Restraunt> getAllLAs() {
        List<Restraunt> list = null;
        try (Session session = sessionFactory.openSession()) {
            Criteria crit = session.createCriteria(Restraunt.class);
            crit.add(Restrictions.eq("city", "LA"));
            list = crit.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
