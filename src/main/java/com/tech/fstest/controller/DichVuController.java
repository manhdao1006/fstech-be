package com.tech.fstest.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tech.fstest.dto.ApiResponse;
import com.tech.fstest.dto.DichVuDTO;
import com.tech.fstest.service.IDichVuService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@CrossOrigin("*")
public class DichVuController {

    private final IDichVuService dichVuService;

    @GetMapping("/dich-vu/danh-sach")
    public ApiResponse<List<DichVuDTO>> getDichVus() {
        return ApiResponse.<List<DichVuDTO>>builder().code(200).message("Danh sách dịch vụ")
                .result(dichVuService.getDichVus()).build();
    }

    @GetMapping("/dich-vu/{maDichVu}")
    public ApiResponse<DichVuDTO> getDichVuByMaDichVu(@PathVariable Long maDichVu) {
        return ApiResponse.<DichVuDTO>builder().code(200).message("Dịch vụ")
                .result(dichVuService.getDichVuByMaDichVu(maDichVu)).build();
    }

}
