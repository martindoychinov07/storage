package com.example.sales.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.sales.model.Document;

@Repository
public interface DocumentRepository   extends JpaRepository<Document, Long> {
}
