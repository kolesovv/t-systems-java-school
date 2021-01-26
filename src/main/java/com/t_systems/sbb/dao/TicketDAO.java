package com.t_systems.sbb.dao;

import com.t_systems.sbb.entity.Station;
import com.t_systems.sbb.entity.Ticket;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public class TicketDAO {

    @Autowired
    SessionFactory sessionFactory;

    public Collection<Ticket> findAllByPassenger(long passengerId) {
        Session session = sessionFactory.getCurrentSession();
        Query<Ticket> stationQuery = session.createSQLQuery("SELECT * FROM ticket as t " +
                "WHERE t.passenger_id =: passengerId");
        stationQuery.setParameter("passengerId", passengerId);
        return stationQuery.getResultList();
    }

    public Ticket findById(long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Ticket.class, id);
    }

    public Collection<Ticket> findAll() {
        Session session = sessionFactory.getCurrentSession();
        Query<Ticket>stationQuery = session.createQuery("FROM Ticket");
        return stationQuery.getResultList();
    }

    public void save(Ticket entity) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(entity);
    }

    public void deleteById(long entityId) {
        Session session = sessionFactory.getCurrentSession();
        Query<Station>stationQuery = session.createQuery("DELETE FROM Ticket WHERE id =: ticketId");
        stationQuery.setParameter("ticketId", entityId);
        stationQuery.executeUpdate();
    }
}
