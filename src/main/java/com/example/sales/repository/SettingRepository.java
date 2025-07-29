package com.example.sales.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.sales.model.Setting;

@Repository
public interface SettingRepository extends JpaRepository<Setting, Long> {
}
