package com.t_systems.sbb.mapper;

import com.t_systems.sbb.dto.ScheduleTrainDTO;
import com.t_systems.sbb.dto.TrainDTO;
import com.t_systems.sbb.entity.Schedule;
import com.t_systems.sbb.entity.Train;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;


@Mapper(componentModel = "spring")
public interface TrainMapper {

    @Mapping(source = "schedulePath", target = "schedules")

    @Mappings({
            @Mapping(source = "ticketTrain.number", target = "trainNumber"),
            @Mapping(source = "passenger.name", target = "passengerName"),
            @Mapping(source = "passenger.secondName", target = "passengerSecondName"),

    })

    Train toEntity (TrainDTO trainDTO);

    @Mapping(source = "schedules", target = "schedulePath")
    TrainDTO toDto (Train trainEntity);

    List<TrainDTO> toDto (Collection<Train> entity);

    default LinkedList<ScheduleTrainDTO> scheduleEntityToTrainSchedule(List<Schedule> trainSchedule){
        LinkedList<ScheduleTrainDTO> scheduleTrainDTOS = new LinkedList<>();

        for(Schedule schedule: trainSchedule){
            ScheduleTrainDTO trainScheduleDTO = new ScheduleTrainDTO();

            trainScheduleDTO.setStationName(schedule.getStation().getNameStation());
            trainScheduleDTO.setArrivalTime(schedule.getArrivalTime());
            trainScheduleDTO.setDepartureTime(schedule.getDepartureTime());

            scheduleTrainDTOS.add(trainScheduleDTO);
        }
        return scheduleTrainDTOS;
    }
}
