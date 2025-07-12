package com.tech.fstest.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tech.fstest.dto.ApiResponse;
import com.tech.fstest.dto.KhachHangDTO;
import com.tech.fstest.service.IKhachHangService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@CrossOrigin("*")
public class KhachHangController {

    private final IKhachHangService khachHangService;

    @GetMapping("/khach-hang/danh-sach")
    public ApiResponse<List<KhachHangDTO>> getKhachHangs() {
        return ApiResponse.<List<KhachHangDTO>>builder().code(200).message("Danh sách khách hàng")
                .result(khachHangService.getKhachHangs()).build();
    }

    @GetMapping("/khach-hang/{maKhachHang}")
    public ApiResponse<KhachHangDTO> getKhachHangByMaKhachHang(@PathVariable Long maKhachHang) {
        return ApiResponse.<KhachHangDTO>builder().code(200).message("Khách hàng")
                .result(khachHangService.getKhachHangByMaKhachHang(maKhachHang)).build();
    }

}
