package com.t_systems.sbb.service;

import com.t_systems.sbb.dao.ScheduleDAOImpl;
import com.t_systems.sbb.dao.StationDAOImpl;
import com.t_systems.sbb.dao.TrainDAOImpl;
import com.t_systems.sbb.entity.Schedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.Date;

@Service
public class ScheduleServiceImpl {

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

    @Transactional
    public void create(Date arrivalTime, Date departureTime, long trainId, long stationId) {

    }

    @Transactional
    public void create(Schedule schedule) {

    }

    @Transactional
    public void save(Schedule entity) {
        scheduleDAO.save(entity);
    }

    @Transactional
    public void delete(Schedule entity) {
        scheduleDAO.delete(entity);
    }

    @Transactional
    public void deleteById(long entityId) {
        scheduleDAO.deleteById(entityId);
    }

    @Transactional
    public Collection<Schedule> getScheduleByStation(long id) {
        return scheduleDAO.getScheduleByStation(id);
    }

    @Transactional
    public Collection<Schedule> getScheduleByTrain(long id) {
        return scheduleDAO.getScheduleByTrain(id);
    }
}
