package com.t_systems.sbb.mapper;

import com.t_systems.sbb.dto.ScheduleStationDTO;
import com.t_systems.sbb.dto.StationDTO;
import com.t_systems.sbb.entity.Schedule;
import com.t_systems.sbb.entity.Station;
import org.mapstruct.Mapper;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

@Mapper(componentModel = "spring")
public interface StationMapper {

    Station toEntity (StationDTO stationDTO);

    StationDTO toDto (Station station);

    List<StationDTO> toDto (Collection<Station> entity);

    default LinkedList<ScheduleStationDTO> scheduleStations(List<Schedule> stationSchedule){
        LinkedList<ScheduleStationDTO> nodes = new LinkedList<>();

        for(Schedule station: stationSchedule){
            ScheduleStationDTO stationScheduleDTO = new ScheduleStationDTO();

            stationScheduleDTO.setTrainName(station.getTrain().getTrainName());
            stationScheduleDTO.setArrival(station.getArrivalTime());
            stationScheduleDTO.setDeparture(station.getDepartureTime());

            nodes.add(stationScheduleDTO);
        }
        return nodes;
    }
}
