package com.example.sales.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.sales.model.Item;
import com.example.sales.DTO.ItemEditRequest;
import com.example.sales.exception.ItemAlreadyExistsException;
import com.example.sales.exception.ItemNotFoundException;
import com.example.sales.repository.ItemLogRepository;
import com.example.sales.repository.ItemRepository;
import com.example.sales.model.ItemLog;

import java.util.List;

@Service
public class ItemService {
    @Autowired
    ItemRepository itemRepository;

    @Autowired
    ItemLogRepository itemLogRepository;

    public ResponseEntity<String> addItem(Item item) {
        if(itemRepository.findByName(item.getName()) != null) {
            throw new ItemAlreadyExistsException("Item already exists");
        }

        ItemLog itemLog = new ItemLog();
        BeanUtils.copyProperties(item, itemLog, "id");

        itemRepository.save(item);
        itemLog.setRefId(item.getId());
        System.out.println(item.getId());
        itemLogRepository.save(itemLog);

        return ResponseEntity.ok("Item added");
    }

    public ResponseEntity<String> deleteItem(String name) {
        Item item = itemRepository.findByName(name);
        if(item == null) {
            throw new ItemNotFoundException("Item not found");
        }

        item.setDeleted(true);

        itemRepository.save(item);

        return ResponseEntity.ok("Item deleted");
    }

    public List<Item> getAllItems() {
        return itemRepository.findByDeletedFalse();
    }

    public ResponseEntity<String> editItem(ItemEditRequest itemEditRequest)
            throws ItemAlreadyExistsException, ItemNotFoundException{
        Item oldItem = itemRepository.findByName(String.valueOf(itemEditRequest.getCurrentName()));

        if (oldItem == null) {
            throw new ItemNotFoundException("Item not found");
        }

        Item newItem = itemRepository.findByName(itemEditRequest.getItem().getName());

        if (newItem != null && !newItem.getName().equals(itemEditRequest.getCurrentName())) {
            throw new ItemAlreadyExistsException("Item already exists");
        }

        BeanUtils.copyProperties(itemEditRequest.getItem(), oldItem, "id");
        itemRepository.save(oldItem);

        return ResponseEntity.ok("Item updated");
    }

    public List<ItemLog> getAllItemLogs(long itemId) {
        return itemLogRepository.findByRefId(itemId);
    }
}
