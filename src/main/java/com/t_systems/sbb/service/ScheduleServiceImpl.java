package com.t_systems.sbb.service;

import com.t_systems.sbb.dao.GenericDAO;
import com.t_systems.sbb.entity.Schedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;

@Service
public class ScheduleServiceImpl implements GenericService<Schedule> {

    @Autowired
    GenericDAO<Schedule> scheduleGenericDAO;

    @Override
    @Transactional
    public Schedule findById(long id) {
        return scheduleGenericDAO.findById(id);
    }

    @Override
    @Transactional
    public Collection<Schedule> findAll() {
        return scheduleGenericDAO.findAll();
    }

    @Override
    @Transactional
    public void create(Schedule entity) {
        scheduleGenericDAO.save(entity);
    }

    @Override
    @Transactional
    public void save(Schedule entity) {
        scheduleGenericDAO.save(entity);
    }

    @Override
    @Transactional
    public void delete(Schedule entity) {
        scheduleGenericDAO.delete(entity);
    }

    @Override
    @Transactional
    public void deleteById(long entityId) {
        scheduleGenericDAO.deleteById(entityId);
    }
}
