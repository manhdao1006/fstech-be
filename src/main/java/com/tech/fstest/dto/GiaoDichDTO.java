package com.tech.fstest.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GiaoDichDTO {

    private String maGiaoDich;
    private LocalDate ngayGiaoDich;
    private String donGia;
    private String dienTich;
    private String trangThaiXoa;
    private Long maKhachHang;
    private Long maDichVu;

}
