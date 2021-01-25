package com.t_systems.sbb.service;


import com.t_systems.sbb.model.TrainItem;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public interface TrainSearchService {

    public List<TrainItem> getTrainsByPathAndTime(long stationIdDeparture, Date dateDeparture,
                                                  long stationIdArrival, Date dateArrival);

}
