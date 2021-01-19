package com.t_systems.sbb.service;

import com.t_systems.sbb.dao.ScheduleDAO;
import com.t_systems.sbb.entity.Schedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Date;
import java.util.Collection;

@Service
public class ScheduleServiceImpl implements ScheduleService {

    @Autowired
    ScheduleDAO scheduleDAO;

    @Override
    @Transactional
    public Schedule findById(long id) {
        return scheduleDAO.findById(id);
    }

    @Override
    @Transactional
    public Collection<Schedule> findAll() {
        return scheduleDAO.findAll();
    }

    @Override
    @Transactional
    public void create(Date arr, Date dep, long trainId, long stationId) {
        scheduleDAO.create(arr, dep, trainId, stationId);
    }

    @Override
    @Transactional
    public void create(Schedule schedule) {

    }

    @Override
    @Transactional
    public void save(Schedule entity) {
        scheduleDAO.save(entity);
    }

    @Override
    @Transactional
    public void delete(Schedule entity) {
        scheduleDAO.delete(entity);
    }

    @Override
    @Transactional
    public void deleteById(long entityId) {
        scheduleDAO.deleteById(entityId);
    }

    @Override
    @Transactional
    public Collection<Schedule> getScheduleByStation(long id) {
        return scheduleDAO.getScheduleByStation(id);
    }

    @Override
    @Transactional
    public Collection<Schedule> getScheduleByTrain(long id) {
        return scheduleDAO.getScheduleByTrain(id);
    }
}
