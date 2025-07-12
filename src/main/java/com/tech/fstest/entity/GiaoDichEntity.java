package com.tech.fstest.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "GIAODICH")
public class GiaoDichEntity {

    @Id
    @Column(name = "maGiaoDich")
    private String maGiaoDich;

    @Column(name = "ngayGiaoDich")
    private LocalDate ngayGiaoDich;

    @Column(name = "donGia")
    private String donGia;

    @Column(name = "dienTich")
    private String dienTich;

    @Column(name = "trangThaiXoa")
    private String trangThaiXoa;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "maKhachHang")
    private KhachHangEntity khachHang;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "maDichVu")
    private DichVuEntity dichVu;

}
