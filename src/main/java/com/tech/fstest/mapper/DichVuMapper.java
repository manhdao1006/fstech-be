package com.tech.fstest.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import com.tech.fstest.dto.DichVuDTO;
import com.tech.fstest.entity.DichVuEntity;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface DichVuMapper {

    DichVuMapper INSTANCE = Mappers.getMapper(DichVuMapper.class);

    DichVuDTO toDTO(DichVuEntity entity);

}
