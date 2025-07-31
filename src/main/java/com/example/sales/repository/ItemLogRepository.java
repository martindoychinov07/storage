package com.example.sales.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.sales.model.ItemLog;
import com.example.sales.model.Item;

@Repository
public interface ItemLogRepository extends JpaRepository<ItemLog, Long> {
    ItemLog findByName(String name);
}
