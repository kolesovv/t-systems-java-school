package com.t_systems.sbb.service;

import com.t_systems.sbb.dao.TrainDAOImpl;
import com.t_systems.sbb.entity.Train;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;

@Service
public class TrainServiceImpl {

    @Autowired
    private TrainDAOImpl trainGenericDAO;

    @Transactional
    public Train findById(long id) {
        return trainGenericDAO.findById(id);
    }

    @Transactional
    public Collection<Train> findAll() {
        return trainGenericDAO.findAll();
    }

    @Transactional
    public void save(Train entity) {
        trainGenericDAO.save(entity);
    }

    @Transactional
    public void deleteById(long entityId) {
        trainGenericDAO.deleteById(entityId);
    }
}
