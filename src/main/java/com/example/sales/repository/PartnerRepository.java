package com.example.sales.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.sales.model.Partner;

@Repository
public interface PartnerRepository extends JpaRepository<Partner, Long> {
    Partner findByName(String name);
}
