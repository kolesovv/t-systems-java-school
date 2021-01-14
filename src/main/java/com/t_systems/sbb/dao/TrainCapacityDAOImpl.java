package com.t_systems.sbb.dao;

import com.t_systems.sbb.entity.TrainCapacity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;

public class TrainCapacityDAOImpl implements GenericDAO<TrainCapacity> {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public TrainCapacity findById(long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(TrainCapacity.class, id);
    }

    @Override
    public Collection<TrainCapacity> findAll() {
        Session session = sessionFactory.getCurrentSession();
        Query<TrainCapacity>trainCapacityQuery = session.createQuery("FROM TrainCapacity");
        return trainCapacityQuery.getResultList();
    }

    @Override
    public void create(TrainCapacity entity) {

    }

    @Override
    public void save(TrainCapacity entity) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(entity);
    }

    @Override
    public void delete(TrainCapacity entity) {

    }

    @Override
    public void deleteById(long entityId) {
        Session session = sessionFactory.getCurrentSession();
        Query<TrainCapacity>trainCapacityQuery = session.createQuery("DELETE FROM TrainCapacity WHERE id=: trainCapacityId");
        trainCapacityQuery.setParameter("trainCapacityId", entityId);
        trainCapacityQuery.executeUpdate();
    }
}
