package com.t_systems.sbb.service;

import com.t_systems.sbb.entity.Schedule;

import java.sql.Date;
import java.util.Collection;

public interface ScheduleService {
    Schedule findById(final long id);

    Collection<Schedule> findAll();

    void create(Date arr, Date dep, long trainId, long stationId);

    void create(final Schedule schedule);

    void save(final Schedule schedule);

    void delete(final Schedule schedule);

    void deleteById(final long id);

    Collection<Schedule> getScheduleByStation(long id);
}
