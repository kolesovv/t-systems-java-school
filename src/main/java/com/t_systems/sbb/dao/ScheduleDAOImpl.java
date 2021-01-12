package com.t_systems.sbb.dao;

import com.t_systems.sbb.entity.Schedule;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ScheduleDAOImpl implements GenericDAO<Schedule> {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Schedule findById(long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Schedule.class, id);
    }

    @Override
    public List<Schedule> findAll() {
        Session session = sessionFactory.getCurrentSession();
        Query<Schedule> scheduleQuery = session.createQuery("FROM Schedule");
        return scheduleQuery.getResultList();
    }

    @Override
    public void create(Schedule entity) {

    }

    @Override
    public void save(Schedule entity) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(entity);
    }

    @Override
    public void delete(Schedule entity) {

    }

    @Override
    public void deleteById(long entityId) {
        Session session = sessionFactory.getCurrentSession();
        Query<Schedule> trainQuery = session.createQuery("DELETE FROM Schedule WHERE id=: scheduleId");
        trainQuery.setParameter("scheduleId", entityId);
        trainQuery.executeUpdate();
    }
}
