package com.tech.fstest.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "DICHVU")
public class DichVuEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "maDichVu")
    private Long maDichVu;

    @Column(name = "tenDichVu")
    private String tenDichVu;

    @OneToMany(mappedBy = "dichVu")
    private List<GiaoDichEntity> giaoDichs = new ArrayList<>();

}
