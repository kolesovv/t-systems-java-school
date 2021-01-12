package com.t_systems.sbb.dao;

import com.t_systems.sbb.entity.Train;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public class TrainDAOImpl implements GenericDAO<Train> {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Train findById(long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Train.class, id);
    }

    @Override
    public Collection<Train> findAll() {
        Session session = sessionFactory.getCurrentSession();
        Query<Train>trainQuery = session.createQuery("FROM Train");
        return trainQuery.getResultList();
    }

    @Override
    public void create(Train entity) {

    }

    @Override
    public void save(Train entity) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(entity);
    }

    @Override
    public void delete(Train entity) {

    }

    @Override
    public void deleteById(long entityId) {
        Session session = sessionFactory.getCurrentSession();
        Query<Train>trainQuery = session.createQuery("DELETE FROM Train WHERE id=: trainId");
        trainQuery.setParameter("trainId", entityId);
        trainQuery.executeUpdate();
    }
}
