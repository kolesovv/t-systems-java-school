package com.t_systems.sbb.service;

import com.t_systems.sbb.dao.ScheduleDAOImpl;
import com.t_systems.sbb.dao.StationDAOImpl;
import com.t_systems.sbb.dao.TrainDAOImpl;
import com.t_systems.sbb.entity.Schedule;
import com.t_systems.sbb.entity.Station;
import com.t_systems.sbb.entity.Train;
import com.t_systems.sbb.model.StationSchedule;
import com.t_systems.sbb.model.StationScheduleItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class StationScheduleService {

    @Autowired
    ScheduleDAOImpl scheduleDAO;

    @Autowired
    StationDAOImpl stationDAO;

    @Transactional
    public StationSchedule getStationSchedule(long stationId){
        Station station = stationDAO.findById(stationId);
        Collection<Schedule> scheduleCollection = scheduleDAO.getScheduleByStation(stationId);
        List<StationScheduleItem> scheduleItemList = new ArrayList<>();
        for (Schedule schedule : scheduleCollection) {
            StationScheduleItem scheduleItem =
                    new StationScheduleItem(schedule.getTrain(), schedule.getArrivalTime(), schedule.getDepartureTime());
            scheduleItemList.add(scheduleItem);
        }
        return new StationSchedule(station, scheduleItemList);
    }
}
