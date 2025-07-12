package com.tech.fstest.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tech.fstest.dto.GiaoDichDTO;
import com.tech.fstest.entity.DichVuEntity;
import com.tech.fstest.entity.GiaoDichEntity;
import com.tech.fstest.entity.KhachHangEntity;
import com.tech.fstest.mapper.GiaoDichMapper;
import com.tech.fstest.repository.DichVuRepository;
import com.tech.fstest.repository.GiaoDichRepository;
import com.tech.fstest.repository.KhachHangRepository;
import com.tech.fstest.service.IGiaoDichService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GiaoDichService implements IGiaoDichService {

    private final GiaoDichMapper giaoDichMapper;
    private final GiaoDichRepository giaoDichRepository;
    private final KhachHangRepository khachHangRepository;
    private final DichVuRepository dichVuRepository;

    @Override
    public List<GiaoDichDTO> getGiaoDichs() {
        List<GiaoDichEntity> entities = giaoDichRepository.findGiaoDichsByTrangThaiXoa("1");
        List<GiaoDichDTO> dtos = entities.stream().map(giaoDichMapper::toDTO).toList();
        return dtos;
    }

    @Transactional
    @Override
    public GiaoDichDTO addGiaoDich(GiaoDichDTO giaoDichDTO) {
        KhachHangEntity khachHangEntity = khachHangRepository.findOneByMaKhachHang(giaoDichDTO.getMaKhachHang());
        DichVuEntity dichVuEntity = dichVuRepository.findOneByMaDichVu(giaoDichDTO.getMaDichVu());

        GiaoDichEntity giaoDichEntity = giaoDichMapper.toEntity(giaoDichDTO);
        giaoDichEntity.setDichVu(dichVuEntity);
        giaoDichEntity.setKhachHang(khachHangEntity);

        return giaoDichMapper.toDTO(giaoDichRepository.save(giaoDichEntity));
    }

    @Transactional
    @Override
    public GiaoDichDTO updateGiaoDich(String maGiaoDich, GiaoDichDTO giaoDichDTO) {
        GiaoDichEntity giaoDichEntity = giaoDichRepository.findOneByMaGiaoDich(maGiaoDich);

        if (giaoDichDTO.getMaKhachHang() != null) {
            KhachHangEntity khachHangEntity = khachHangRepository.findOneByMaKhachHang(giaoDichDTO.getMaKhachHang());
            giaoDichEntity.setKhachHang(khachHangEntity);

        }

        if (giaoDichDTO.getMaDichVu() != null) {
            DichVuEntity dichVuEntity = dichVuRepository.findOneByMaDichVu(giaoDichDTO.getMaDichVu());
            giaoDichEntity.setDichVu(dichVuEntity);
        }

        GiaoDichEntity giaoDichUpdated = giaoDichMapper.toEntity(giaoDichDTO, giaoDichEntity);
        return giaoDichMapper.toDTO(giaoDichRepository.save(giaoDichUpdated));
    }

    @Transactional
    @Override
    public GiaoDichDTO deleteGiaoDich(String maGiaoDich) {
        GiaoDichEntity giaoDichEntity = giaoDichRepository.findOneByMaGiaoDich(maGiaoDich);
        giaoDichEntity.setTrangThaiXoa("0");
        return giaoDichMapper.toDTO(giaoDichRepository.save(giaoDichEntity));
    }

}
