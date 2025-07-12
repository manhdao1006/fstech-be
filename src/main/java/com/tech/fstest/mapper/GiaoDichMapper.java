package com.tech.fstest.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import com.tech.fstest.dto.GiaoDichDTO;
import com.tech.fstest.entity.GiaoDichEntity;

@Mapper(componentModel = "spring", uses = { DichVuMapper.class,
        KhachHangMapper.class }, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface GiaoDichMapper {

    GiaoDichMapper INSTANCE = Mappers.getMapper(GiaoDichMapper.class);

    @Mapping(target = "maKhachHang", source = "khachHang.maKhachHang")
    @Mapping(target = "maDichVu", source = "dichVu.maDichVu")
    GiaoDichDTO toDTO(GiaoDichEntity entity);

    @Mapping(target = "trangThaiXoa", defaultValue = "1")
    GiaoDichEntity toEntity(GiaoDichDTO dto);

    @Mapping(target = "maGiaoDich", ignore = true)
    GiaoDichEntity toEntity(GiaoDichDTO dto, @MappingTarget GiaoDichEntity updatedGiaoDich);
}
