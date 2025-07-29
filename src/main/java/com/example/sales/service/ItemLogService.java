package com.example.sales.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.sales.repository.ItemLogRepository;
import com.example.sales.exception.ItemAlreadyExistsException;
import com.example.sales.exception.ItemNotFoundException;
import com.example.sales.model.Item;
import com.example.sales.model.ItemLog;
import com.example.sales.DTO.AddItemRequest;

@Service
public class ItemLogService {
    @Autowired
    ItemLogRepository itemLogRepository;

    public ResponseEntity<String> addItemToDocument(AddItemRequest addItemRequest)
            throws ItemNotFoundException {
        Item check = itemLogRepository.findByName(addItemRequest.getItem().getName());

        if (check == null) {
            throw new ItemNotFoundException("Item not found");
        }

        ItemLog itemLog = new ItemLog();

        BeanUtils.copyProperties(addItemRequest.getItem(), itemLog);
        itemLog.setRefId(addItemRequest.getItem().getId());
        itemLog.setDocId(addItemRequest.getDocId());

        itemLogRepository.save(itemLog);

        return ResponseEntity.ok("Item added to document");
    }
}
