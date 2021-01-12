package com.t_systems.sbb.dao;

import com.t_systems.sbb.entity.Path;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public class PathDAOImpl implements GenericDAO<Path> {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Path findById(long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Path.class, id);
    }

    @Override
    public Collection<Path> findAll() {
        Session session = sessionFactory.getCurrentSession();
        Query<Path> pathQuery = session.createQuery("FROM Path");
        return pathQuery.getResultList();
    }

    @Override
    public void create(Path entity) {

    }

    @Override
    public void save(Path entity) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(entity);
    }

    @Override
    public void delete(Path entity) {

    }

    @Override
    public void deleteById(long entityId) {
        Session session = sessionFactory.getCurrentSession();
        Query<Path> pathQuery = session.createQuery("DELETE FROM Path WHERE id=:pathId");
        pathQuery.setParameter("pathId", entityId);
        pathQuery.executeUpdate();
    }
}
