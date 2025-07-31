package com.example.sales.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sales.repository.ItemLogRepository;
import com.example.sales.exception.ItemAlreadyExistsException;
import com.example.sales.model.ItemLog;

@Service
public class ItemLogService {
    @Autowired
    ItemLogRepository itemLogRepository;

    public ItemLog createItemLog(ItemLog itemLog) throws ItemAlreadyExistsException {
        if (itemLogRepository.findByName(itemLog.getName()) != null) {
            throw new ItemAlreadyExistsException("ItemLog already exists");
        }

        return itemLogRepository.save(itemLog);
    }
}
