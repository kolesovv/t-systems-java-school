package com.t_systems.sbb.service;

import com.t_systems.sbb.dao.PassengerDAOImpl;
import com.t_systems.sbb.entity.Passenger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;

@Service
public class PassengerServiceImpl implements GenericService<Passenger>{

    @Autowired
    PassengerDAOImpl passengerDAO;

    @Override
    @Transactional
    public Passenger findById(long id) {
        return passengerDAO.findById(id);
    }

    @Override
    @Transactional
    public Collection<Passenger> findAll() {
        return passengerDAO.findAll();
    }

    @Override
    @Transactional
    public void save(Passenger entity) {
        passengerDAO.save(entity);
    }

    @Override
    @Transactional
    public void deleteById(long entityId) {
        passengerDAO.deleteById(entityId);
    }
}
