package com.t_systems.sbb.mapper;

import com.t_systems.sbb.dto.TrainDTO;
import com.t_systems.sbb.entity.Train;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Collection;
import java.util.List;


@Mapper(componentModel = "spring")
public interface TrainMapper {

    @Mapping(source = "schedulePath", target = "schedules")
    Train dtoToEntity (TrainDTO trainDTO);

    @Mapping(source = "schedules", target = "schedulePath")
    TrainDTO entityToDTO (Train trainEntity);

    List<TrainDTO> toDto (Collection<Train> entity);

}
