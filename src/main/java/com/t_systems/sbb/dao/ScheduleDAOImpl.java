package com.t_systems.sbb.dao;

import com.t_systems.sbb.entity.Schedule;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;
import java.util.Map;

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

    public List<Schedule> getScheduleByStation(long stationId){
        Session session = sessionFactory.getCurrentSession();
        Query<Schedule> scheduleQuery = session.createQuery("SELECT * FROM Schedule AS s WHERE s.station_id=: stationId");
        scheduleQuery.setParameter("stationId", stationId);
        return scheduleQuery.getResultList();
    }

    public List<Map> getScheduleByPathAndTime(long stationIdDeparture, Date dateDeparture,
                                              long stationIdArrival,Date dateArrival){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery(
                "SELECT * FROM" +
                "(SELECT * FROM schedule WHERE departure_time >=: dateDeparture AND station_id =: stationDeparture) as deparute" +
                "JOIN" +
                "(SELECT * FROM schedule WHERE arrival_time <=: dateArrival AND station_id =: stationArrival) as arrival" +
                "ON" +
                "deparute.train_id = arrival.train_id");

        query
                .setParameter("dateDeparture", dateDeparture)
                .setParameter("stationIdDeparture", stationIdDeparture)
                .setParameter("dateArrival", dateArrival)
                .setParameter("stationIdArrival", stationIdArrival);

        return query.getResultList();
    }
}
