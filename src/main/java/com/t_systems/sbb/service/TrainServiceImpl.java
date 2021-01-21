package com.t_systems.sbb.service;

import com.t_systems.sbb.dao.GenericDAO;
import com.t_systems.sbb.dto.TrainDTO;
import com.t_systems.sbb.entity.Train;
import com.t_systems.sbb.mapper.TrainMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.LinkedList;

@Service
public class TrainServiceImpl {

    @Autowired
    private GenericDAO<Train> trainGenericDAO;

    @Autowired
    private TrainMapper trainMapper;

    @Transactional
    public Train findById(long id) {
        return trainGenericDAO.findById(id);
    }

    @Transactional
    public Collection<Train> findAll() {
        return trainGenericDAO.findAll();
    }

    @Transactional
    public void create(Train entity) {
        trainGenericDAO.create(entity);
    }

    @Transactional
    public void save(Train entity) {
        trainGenericDAO.save(entity);
    }

    @Transactional
    public void delete(Train entity) {
        trainGenericDAO.delete(entity);
    }

    @Transactional
    public void deleteById(long entityId) {
        trainGenericDAO.deleteById(entityId);
    }

    @Transactional
    public TrainDTO findByIdDTO(long id) {
        return trainMapper.toDto(trainGenericDAO.findById(id));
    }

    @Transactional
    public Collection<TrainDTO> findAllDTO() {
        return trainMapper.toDto(trainGenericDAO.findAll());
    }

    @Transactional
    public void save(TrainDTO dto) {
        Train train = trainMapper.toEntity(dto);
        train.setSchedules(new LinkedList<>());
        trainGenericDAO.save(train);
    }

    @Transactional
    public void deleteByIdDTO(long entityId) {
        trainGenericDAO.deleteById(entityId);
    }
}
