package com.t_systems.sbb.dao;

import com.t_systems.sbb.entity.Train;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TrainDAOImpl implements TrainDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Train> getTrain() {
        Session session = sessionFactory.getCurrentSession();
        Query<Train>trainQuery = session.createQuery("FROM Train");
        return trainQuery.getResultList();
    }

    @Override
    public void saveTrain(Train train) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(train);
    }

    @Override
    public Train getTrain(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Train.class, id);
    }

    @Override
    public void deleteTrain(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query<Train>trainQuery = session.createQuery("DELETE FROM Train WHERE id=: trainId");
        trainQuery.setParameter("trainId", id);
        trainQuery.executeUpdate();
    }
}
