package com.tech.fstest.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import com.tech.fstest.dto.KhachHangDTO;
import com.tech.fstest.entity.KhachHangEntity;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface KhachHangMapper {

    KhachHangMapper INSTANCE = Mappers.getMapper(KhachHangMapper.class);

    KhachHangDTO toDTO(KhachHangEntity entity);

}
