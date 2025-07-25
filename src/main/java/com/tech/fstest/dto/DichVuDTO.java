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
public class DichVuDTO {

    private Long maDichVu;
    private String tenDichVu;
    private List<GiaoDichDTO> giaoDichs;

}
