package com.t_systems.sbb.service;

import com.t_systems.sbb.dao.GenericDAO;
import com.t_systems.sbb.dao.ScheduleDAOImpl;
import com.t_systems.sbb.entity.Schedule;
import com.t_systems.sbb.entity.Station;
import com.t_systems.sbb.entity.Train;
import com.t_systems.sbb.model.TrainItem;
import com.t_systems.sbb.model.TrainSchedule;
import com.t_systems.sbb.model.TrainScheduleItem;
import org.javatuples.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service
public class TrainScheduleService {

    @Autowired
    private GenericDAO<Train> trainGenericDAO;

    @Autowired
    private ScheduleDAOImpl scheduleDAO;

    @Autowired
    private GenericDAO<Station> stationGenericDAO;

    @Transactional
    public List<TrainItem> getTrainsByPathAndTime(long stationIdDeparture, Date dateDeparture, long stationIdArrival, Date dateArrival) {
            List<Map> scheduleList = scheduleDAO.getScheduleByPathAndTime
                    (stationIdDeparture, dateDeparture, stationIdArrival, dateArrival);
            List<TrainItem> specificTrainList = new ArrayList<>();
            for (Map road: scheduleList) {
                Train currentTrain = trainGenericDAO.findById((Long) road.get("departure.train_id"));
                Pair<Date, Station> dateStationDeparture =
                        Pair.with((Date)road.get("departure.departure_time"), stationGenericDAO.findById(stationIdDeparture));
                Pair<Date, Station> dateStationArrival =
                        Pair.with((Date)road.get("arrival.arrival_time"), stationGenericDAO.findById(stationIdArrival));
                specificTrainList.add(new TrainItem(currentTrain, dateStationDeparture, dateStationArrival));
            }
            return  specificTrainList;
    }

    @Transactional
    public TrainSchedule getTrainSchedule(long trainId){
        Train train = trainGenericDAO.findById(trainId);
        Collection<Schedule> scheduleCollection = scheduleDAO.getScheduleByTrain(trainId);
        List<TrainScheduleItem> scheduleItemList = new ArrayList<>();
        for (Schedule schedule: scheduleCollection) {
            TrainScheduleItem scheduleItem =
                    new TrainScheduleItem(schedule.getId(),schedule.getStation(), schedule. getArrivalTime(), schedule.getDepartureTime());
            scheduleItemList.add(scheduleItem);
        }
        scheduleItemList.sort(Comparator.comparing(TrainScheduleItem::getDepartureTime));
        return new TrainSchedule(train, scheduleItemList);
    }
}
