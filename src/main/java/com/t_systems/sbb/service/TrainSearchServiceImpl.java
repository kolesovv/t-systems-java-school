package com.t_systems.sbb.service;

import com.t_systems.sbb.dao.GenericDAO;
import com.t_systems.sbb.dao.ScheduleDAOImpl;
import com.t_systems.sbb.entity.Station;
import com.t_systems.sbb.entity.Train;
import com.t_systems.sbb.model.TrainItem;
import org.javatuples.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class TrainSearchServiceImpl {

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
}
