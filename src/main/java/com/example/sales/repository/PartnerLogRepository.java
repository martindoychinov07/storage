package com.example.sales.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.sales.model.Partner;
import com.example.sales.model.PartnerLog;

import java.time.LocalDateTime;

@Repository
public interface PartnerLogRepository  extends JpaRepository<PartnerLog, Long> {
    public PartnerLog findByRefIdAndVersion(long id, LocalDateTime version);
}
