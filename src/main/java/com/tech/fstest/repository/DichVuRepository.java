package com.tech.fstest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tech.fstest.entity.DichVuEntity;

@Repository
public interface DichVuRepository extends JpaRepository<DichVuEntity, Long> {

    DichVuEntity findOneByMaDichVu(Long maDichVu);

}
