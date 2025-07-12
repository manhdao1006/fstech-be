package com.tech.fstest.service;

import java.util.List;

import com.tech.fstest.dto.DichVuDTO;

public interface IDichVuService {

    List<DichVuDTO> getDichVus();

    DichVuDTO getDichVuByMaDichVu(Long maDichVu);

}
