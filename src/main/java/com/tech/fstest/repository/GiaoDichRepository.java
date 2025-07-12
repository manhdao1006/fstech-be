package com.tech.fstest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tech.fstest.entity.GiaoDichEntity;

@Repository
public interface GiaoDichRepository extends JpaRepository<GiaoDichEntity, String> {

    List<GiaoDichEntity> findGiaoDichsByTrangThaiXoa(String trangThaiXoa);

    GiaoDichEntity findOneByMaGiaoDich(String maGiaoDich);

    boolean existsByMaGiaoDich(String maGiaoDich);

}
