package com.example.sales.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.sales.service.ItemService;
import com.example.sales.model.Item;
import com.example.sales.DTO.ItemEditRequest;
import com.example.sales.repository.ItemLogRepository;
import com.example.sales.model.ItemLog;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
@RestController
@RequestMapping("/item")
public class ItemController {
    @Autowired
    ItemService itemService;

    @Autowired
    ItemLogRepository itemLogRepository;

    @PostMapping("/add")
    public ResponseEntity<String> addItem(@RequestBody Item item) {
        return itemService.addItem(item);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteItem(@RequestBody String name) {
        return itemService.deleteItem(name.replace("\"", "").trim());
    }
    @GetMapping("/all")
    public List<Item> getAllItems() {
        return itemService.getAllItems();
    }

    @PatchMapping("/edit")
    public ResponseEntity<String> editItem(@RequestBody ItemEditRequest itemEditRequest) {
        return itemService.editItem(itemEditRequest);
    }

    @GetMapping("/logs")
    public List<ItemLog> getAllItemLogs(@RequestParam long itemId) {
        return itemService.getAllItemLogs(itemId);
    }
}
