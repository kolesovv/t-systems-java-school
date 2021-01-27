package com.t_systems.sbb.service;

import com.t_systems.sbb.dao.ScheduleDAOImpl;
import com.t_systems.sbb.dao.StationDAOImpl;
import com.t_systems.sbb.dao.TrainDAOImpl;
import com.t_systems.sbb.entity.Schedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;

@Service
public class ScheduleServiceImpl implements ScheduleService {

    @Autowired
    ScheduleDAOImpl scheduleDAO;

    @Autowired
    TrainDAOImpl trainDAO;

    @Autowired
    StationDAOImpl stationDAO;

    @Transactional
    public Schedule findById(long id) {
        return scheduleDAO.findById(id);
    }

    @Transactional
    public Collection<Schedule> findAll() {
        return scheduleDAO.findAll();
    }

    @Override
    public void create(java.sql.Date arrival, java.sql.Date departure, long trainId, long stationId) {

    }

    @Transactional
    public void create(Schedule schedule) {

    }

    @Transactional
    public void save(Schedule entity) {
        scheduleDAO.save(entity);
    }

    @Transactional
    public void deleteById(long entityId) {
        scheduleDAO.deleteById(entityId);
    }
}
