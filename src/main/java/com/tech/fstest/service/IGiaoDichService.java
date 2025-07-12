package com.tech.fstest.service;

import java.util.List;

import com.tech.fstest.dto.GiaoDichDTO;

public interface IGiaoDichService {

    List<GiaoDichDTO> getGiaoDichs();

    GiaoDichDTO addGiaoDich(GiaoDichDTO giaoDichDTO);

    GiaoDichDTO updateGiaoDich(String maGiaoDich, GiaoDichDTO giaoDichDTO);

    GiaoDichDTO deleteGiaoDich(String maGiaoDich);

}
