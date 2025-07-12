package com.tech.fstest.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tech.fstest.dto.DichVuDTO;
import com.tech.fstest.entity.DichVuEntity;
import com.tech.fstest.mapper.DichVuMapper;
import com.tech.fstest.repository.DichVuRepository;
import com.tech.fstest.service.IDichVuService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DichVuService implements IDichVuService {

    private final DichVuRepository dichVuRepository;
    private final DichVuMapper dichVuMapper;

    @Override
    public List<DichVuDTO> getDichVus() {
        List<DichVuEntity> entities = dichVuRepository.findAll();
        List<DichVuDTO> dtos = entities.stream().map(dichVuMapper::toDTO).toList();
        return dtos;
    }

    @Override
    public DichVuDTO getDichVuByMaDichVu(Long maDichVu) {
        DichVuEntity entity = dichVuRepository.findOneByMaDichVu(maDichVu);
        return dichVuMapper.toDTO(entity);
    }

}
