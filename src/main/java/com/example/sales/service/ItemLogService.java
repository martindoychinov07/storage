package com.example.sales.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.sales.repository.ItemLogRepository;
import com.example.sales.exception.ItemAlreadyExistsException;
import com.example.sales.model.ItemLog;
import com.example.sales.DTO.ItemLogRequest;
import com.example.sales.exception.ItemNotFoundException;
import com.example.sales.model.Item;
import com.example.sales.repository.ItemRepository;

@Service
public class ItemLogService {
    @Autowired
    ItemLogRepository itemLogRepository;

    @Autowired
    ItemRepository itemRepository;

    public ResponseEntity<String> createItemLog(ItemLogRequest itemLogRequest)
            throws ItemAlreadyExistsException, ItemNotFoundException {
        ItemLog itemLog = itemLogRepository.findByName(itemLogRequest.getItemLogName());

        if (itemLog != null) {
            throw new ItemAlreadyExistsException("ItemLog already exists");
        }

        ItemLog newItemLog = new ItemLog();

        Item item = itemRepository.findByName(itemLogRequest.getItemName());

        if (item == null) {
            throw new ItemNotFoundException("Item not found");
        }

        BeanUtils.copyProperties(item, newItemLog, "id");
        newItemLog.setName(itemLogRequest.getItemLogName());
        newItemLog.setRefId(item.getId());

        itemLogRepository.save(newItemLog);

        return ResponseEntity.ok("New Item Log created");
    }
}
