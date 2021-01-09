package com.t_systems.sbb.dao;

import com.t_systems.sbb.entity.Path;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PathDAOImpl implements PathDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Path> getPaths() {
        Session session = sessionFactory.getCurrentSession();
        Query<Path> pathQuery = session.createQuery("FROM Path");
        return pathQuery.getResultList();
    }

    @Override
    public void savePath(Path path) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(path);
    }

    @Override
    public Path getPath(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Path.class, id);
    }

    @Override
    public void deletePath(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query<Path> pathQuery = session.createQuery("DELETE FROM Path WHERE id=:pathId");
        pathQuery.setParameter("pathId", id);
        pathQuery.executeUpdate();
    }
}
