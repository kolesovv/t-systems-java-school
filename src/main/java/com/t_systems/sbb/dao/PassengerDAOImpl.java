package com.t_systems.sbb.dao;

import com.t_systems.sbb.entity.Passenger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public class PassengerDAOImpl implements GenericDAO<Passenger> {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Passenger findById(long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Passenger.class, id);
    }

    @Override
    public Collection<Passenger> findAll() {
        Session session = sessionFactory.getCurrentSession();
        Query<Passenger> trainQuery = session.createQuery("FROM Passenger");
        return trainQuery.getResultList();
    }

    @Override
    public void save(Passenger entity) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(entity);
    }

    @Override
    public void deleteById(long entityId) {
        Session session = sessionFactory.getCurrentSession();
        Query<Passenger>trainQuery = session.createQuery("DELETE FROM Passenger WHERE id =: passengerId");
        trainQuery.setParameter("passengerId", entityId);
        trainQuery.executeUpdate();
    }
}
