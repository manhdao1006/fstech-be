package com.tech.fstest.service;

import java.util.List;

import com.tech.fstest.dto.KhachHangDTO;

public interface IKhachHangService {

    List<KhachHangDTO> getKhachHangs();

    KhachHangDTO getKhachHangByMaKhachHang(Long maKhachHang);

}
