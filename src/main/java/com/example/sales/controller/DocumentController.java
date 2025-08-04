package com.example.sales.controller;

import com.example.sales.DTO.DocumentCreateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.sales.service.DocumentService;
import com.example.sales.model.Document;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
@RestController
@RequestMapping("/document")
public class DocumentController {
    @Autowired
    DocumentService documentService;

    @PostMapping("/create")
    public ResponseEntity<String> createDocument(@RequestBody DocumentCreateRequest documentCreateRequest) {
        return documentService.createDocument(documentCreateRequest);
    }

    @GetMapping("/all")
    public List<Document> getAllDocuments() {
        return documentService.getAllDocuments();
    }
}
