package com.t_systems.sbb.dao;

import com.t_systems.sbb.entity.Station;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public class StationDAOImpl implements GenericDAO<Station> {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Station findById(long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Station.class, id);
    }

    @Override
    public Collection<Station> findAll() {
        Session session = sessionFactory.getCurrentSession();
        Query<Station>stationQuery = session.createQuery("FROM Station");
        return stationQuery.getResultList();
    }

    @Override
    public void create(Station entity) {

    }

    @Override
    public void save(Station entity) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(entity);
    }

    @Override
    public void delete(Station entity) {

    }

    @Override
    public void deleteById(long entityId) {
        Session session = sessionFactory.getCurrentSession();
        Query<Station>stationQuery = session.createQuery("DELETE FROM Station WHERE id =: stationId");
        stationQuery.setParameter("stationId", entityId);
        stationQuery.executeUpdate();
    }
}
