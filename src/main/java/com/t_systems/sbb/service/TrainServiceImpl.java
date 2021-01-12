package com.t_systems.sbb.service;

import com.t_systems.sbb.dao.GenericDAO;
import com.t_systems.sbb.entity.Train;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;

@Service
public class TrainServiceImpl implements GenericService<Train> {

    @Autowired
    private GenericDAO<Train> trainGenericDAO;

    @Override
    @Transactional
    public Train findById(long id) {
        return trainGenericDAO.findById(id);
    }

    @Override
    @Transactional
    public Collection<Train> findAll() {
        return trainGenericDAO.findAll();
    }

    @Override
    @Transactional
    public void create(Train entity) {
        trainGenericDAO.create(entity);
    }

    @Override
    @Transactional
    public void save(Train entity) {
        trainGenericDAO.save(entity);
    }

    @Override
    @Transactional
    public void delete(Train entity) {
        trainGenericDAO.delete(entity);
    }

    @Override
    @Transactional
    public void deleteById(long entityId) {
        trainGenericDAO.deleteById(entityId);
    }
}
