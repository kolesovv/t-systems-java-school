package com.t_systems.sbb.dao;

import com.t_systems.sbb.entity.Schedule;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Repository
public class ScheduleDAOImpl {

    @Autowired
    SessionFactory sessionFactory;

    public Schedule findById(long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Schedule.class, id);
    }

    public List<Schedule> findAll() {
        Session session = sessionFactory.getCurrentSession();
        Query<Schedule> scheduleQuery = session.createQuery("FROM Schedule");
        return scheduleQuery.getResultList();
    }

    public void create(Date arr, Date dep, long trainId, long stationId) {
        Session session = sessionFactory.getCurrentSession();
        Query<Schedule> scheduleQuery = session.createQuery
                ("INSERT INTO schedule (arrival_time, departure_time, train_id, station_id) " +
                "values (arr =: arr, dep =: dep, trainId =: trainId, stationId =: stationId)");
        scheduleQuery.setParameter("arr", arr)
                        .setParameter("dep", dep)
                        .setParameter("trainId", trainId)
                        .setParameter("stationId", stationId);
        scheduleQuery.executeUpdate();
    }

    public void save(Schedule entity) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(entity);
    }

    public void deleteById(long entityId) {
        Session session = sessionFactory.getCurrentSession();
        Query<Schedule> trainQuery = session.createQuery("DELETE FROM Schedule WHERE id=: scheduleId");
        trainQuery.setParameter("scheduleId", entityId);
        trainQuery.executeUpdate();
    }

    public Collection<Schedule> getScheduleByStation(long stationId){
        Session session = sessionFactory.getCurrentSession();
        Query<Schedule> scheduleQuery = session.createQuery("FROM Schedule WHERE station_id =: stationId");
        scheduleQuery.setParameter("stationId", stationId);
        return scheduleQuery.getResultList();
    }

    public Collection<Schedule> getScheduleByTrain(long trainId) {
        Session session = sessionFactory.getCurrentSession();
        Query<Schedule> scheduleQuery = session.createQuery("FROM Schedule WHERE train_id =: trainId");
        scheduleQuery.setParameter("trainId", trainId);
        return scheduleQuery.getResultList();
    }

    public List<Map> getScheduleByPathAndTime(long stationIdDeparture, Date dateDeparture,
                                              long stationIdArrival, Date dateArrival){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createSQLQuery(
                "SELECT deparute.station_id AS dep, deparute.departure_time AS dep_time,\n" +
                        "       arrival.station_id AS arr, arrival.arrival_time AS arr_time,\n" +
                        "       arrival.train_id\n" +
                        "(SELECT * FROM schedule WHERE departure_time >= :dateDeparture AND station_id = :stationIdDeparture) as deparute\n" +
                        "JOIN\n" +
                        "(SELECT * FROM schedule WHERE arrival_time <= :dateArrival AND station_id = :stationIdArrival) as arrival\n" +
                        "ON\n" +
                        "(deparute.train_id = arrival.train_id)").
                setParameter("dateDeparture", dateDeparture)
                .setParameter("stationIdDeparture", stationIdDeparture)
                .setParameter("dateArrival", dateArrival)
                .setParameter("stationIdArrival", stationIdArrival);

        return query.getResultList();
    }
}
