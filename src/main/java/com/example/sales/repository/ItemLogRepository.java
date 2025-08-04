package com.example.sales.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.sales.model.ItemLog;
import com.example.sales.model.Item;

import java.util.List;

@Repository
public interface ItemLogRepository extends JpaRepository<ItemLog, Long> {
    ItemLog findByName(String name);
    List<ItemLog> findByRefId(long id);
}
