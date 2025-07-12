package com.tech.fstest.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tech.fstest.dto.ApiResponse;
import com.tech.fstest.dto.GiaoDichDTO;
import com.tech.fstest.repository.GiaoDichRepository;
import com.tech.fstest.service.IGiaoDichService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@CrossOrigin("*")
public class GiaoDichController {

    private final IGiaoDichService giaoDichService;
    private final GiaoDichRepository giaoDichRepository;

    @GetMapping("/giao-dich/check-ma")
    public ResponseEntity<Boolean> checkMaGiaoDichExists(@RequestParam String maGiaoDich) {
        boolean exists = giaoDichRepository.existsByMaGiaoDich(maGiaoDich);
        return ResponseEntity.ok(exists);
    }

    @GetMapping("/giao-dich/danh-sach")
    public ApiResponse<List<GiaoDichDTO>> getGiaoDichs() {
        return ApiResponse.<List<GiaoDichDTO>>builder().code(200).message("Danh sách giao dịch")
                .result(giaoDichService.getGiaoDichs()).build();
    }

    @PostMapping("/giao-dich/them-moi")
    public ApiResponse<GiaoDichDTO> addGiaoDich(@RequestBody GiaoDichDTO giaoDichDTO) {
        return ApiResponse.<GiaoDichDTO>builder().code(200).message("Thêm mới thành công")
                .result(giaoDichService.addGiaoDich(giaoDichDTO)).build();
    }

    @PutMapping("giao-dich/cap-nhat/{maGiaoDich}")
    public ApiResponse<GiaoDichDTO> updateGiaoDich(@PathVariable String maGiaoDich,
            @RequestBody GiaoDichDTO giaoDichDTO) {
        return ApiResponse.<GiaoDichDTO>builder().code(200).message("Cập nhật thành công")
                .result(giaoDichService.updateGiaoDich(maGiaoDich, giaoDichDTO)).build();
    }

    @PutMapping("giao-dich/xoa/{maGiaoDich}")
    public ApiResponse<GiaoDichDTO> deleteGiaoDich(@PathVariable String maGiaoDich) {
        return ApiResponse.<GiaoDichDTO>builder().code(200).message("Xóa thành công")
                .result(giaoDichService.deleteGiaoDich(maGiaoDich)).build();
    }

}
