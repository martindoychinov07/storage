package com.example.sales.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.sales.model.ItemLog;
import com.example.sales.service.ItemLogService;
import com.example.sales.DTO.ItemLogRequest;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
@RestController
@RequestMapping("/itemLog")
public class ItemLogController {
    @Autowired
    ItemLogService itemLogService;

    @PostMapping("/add")
    public ResponseEntity<String> createItemLog(@RequestBody ItemLogRequest itemLogRequest) {
        return itemLogService.createItemLog(itemLogRequest);
    }

    @GetMapping("/all")
    public List<ItemLog> getAllLogs() {
        return itemLogService.getAllLogs();
    }
}
