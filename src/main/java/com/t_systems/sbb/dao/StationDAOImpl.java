package com.t_systems.sbb.dao;

import com.t_systems.sbb.entity.Station;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class StationDAOImpl implements StationDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Station> getStations() {
        Session session = sessionFactory.getCurrentSession();
        Query<Station>stationQuery = session.createQuery("FROM Station");
        return stationQuery.getResultList();
    }
}
