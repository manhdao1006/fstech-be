package com.tech.fstest.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class KhachHangDTO {

    private Long maKhachHang;
    private String tenKhachHang;
    private String soDienThoai;
    private String email;
    private List<GiaoDichDTO> giaoDichs;

}
