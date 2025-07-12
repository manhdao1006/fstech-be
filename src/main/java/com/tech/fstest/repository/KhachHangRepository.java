package com.tech.fstest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tech.fstest.entity.KhachHangEntity;

@Repository
public interface KhachHangRepository extends JpaRepository<KhachHangEntity, Long> {

    KhachHangEntity findOneByMaKhachHang(Long maKhachHang);

}
