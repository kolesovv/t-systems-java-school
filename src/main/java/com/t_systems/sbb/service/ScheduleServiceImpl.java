package com.t_systems.sbb.service;

import com.t_systems.sbb.dao.GenericDAO;
import com.t_systems.sbb.entity.Schedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ScheduleServiceImpl implements GenericService<Schedule> {

    @Autowired
    GenericDAO<Schedule> genericDAO;


    @Override
    @Transactional
    public Schedule findById(int id) {
        return genericDAO.findById(id);
    }

    @Override
    @Transactional
    public List<Schedule> findAll() {
        return genericDAO.findAll();
    }

    @Override
    @Transactional
    public void create(Schedule entity) {

    }

    @Override
    @Transactional
    public void save(Schedule entity) {

    }

    @Override
    @Transactional
    public void delete(Schedule entity) {
        genericDAO.delete(entity);
    }

    @Override
    @Transactional
    public void deleteById(int entityId) {
        genericDAO.deleteById(entityId);
    }
}
