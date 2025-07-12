package com.tech.fstest.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tech.fstest.dto.KhachHangDTO;
import com.tech.fstest.entity.KhachHangEntity;
import com.tech.fstest.mapper.KhachHangMapper;
import com.tech.fstest.repository.KhachHangRepository;
import com.tech.fstest.service.IKhachHangService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class KhachHangService implements IKhachHangService {

    private final KhachHangRepository khachHangRepository;
    private final KhachHangMapper khachHangMapper;

    @Override
    public List<KhachHangDTO> getKhachHangs() {
        List<KhachHangEntity> entities = khachHangRepository.findAll();
        List<KhachHangDTO> dtos = entities.stream().map(khachHangMapper::toDTO).toList();
        return dtos;
    }

    @Override
    public KhachHangDTO getKhachHangByMaKhachHang(Long maKhachHang) {
        KhachHangEntity entity = khachHangRepository.findOneByMaKhachHang(maKhachHang);
        return khachHangMapper.toDTO(entity);
    }

}
