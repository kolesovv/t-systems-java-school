package com.t_systems.sbb.service;


import com.t_systems.sbb.entity.Station;
import com.t_systems.sbb.entity.Train;
import org.javatuples.Pair;

import java.sql.Date;
import java.util.List;

public interface TrainSearchService {

    public List<SpecificTrain> getTrainsByPathAndTime(long stationIdDeparture, Date dateDeparture,
                                                                       long stationIdArrival, Date dateArrival);

    public class SpecificTrain {
        private Train train;
        private Pair<Date, Station> dateStationDeparture;
        private Pair<Date, Station> dateStationArrival;

        public SpecificTrain(Train train, Pair<Date, Station> dateStationDeparture, Pair<Date, Station> dateStationArrival) {
            this.train = train;
            this.dateStationDeparture = dateStationDeparture;
            this.dateStationArrival = dateStationArrival;
        }

        public Train getTrain() {
            return train;
        }

        public void setTrain(Train train) {
            this.train = train;
        }

        public Pair<Date, Station> getDateStationDeparture() {
            return dateStationDeparture;
        }

        public void setDateStationDeparture(Pair<Date, Station> dateStationDeparture) {
            this.dateStationDeparture = dateStationDeparture;
        }

        public Pair<Date, Station> getDateStationArrival() {
            return dateStationArrival;
        }

        public void setDateStationArrival(Pair<Date, Station> dateStationArrival) {
            this.dateStationArrival = dateStationArrival;
        }
    }
}
