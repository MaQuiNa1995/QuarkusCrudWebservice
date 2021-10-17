package maquina1995.webservice.mapper;

import org.mapstruct.Mapper;

import maquina1995.webservice.dto.PlantDto;
import maquina1995.webservice.entity.Plant;

@Mapper
public interface PlantMapper extends AbstractMapper<Plant, PlantDto> {

}
