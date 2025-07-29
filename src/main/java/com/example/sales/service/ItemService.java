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

        itemRepository.save(item);

        return ResponseEntity.ok("Item added");
    }

    public ResponseEntity<String> deleteItem(String name) {
        Item item = itemRepository.findByName(name);
        if(item == null) {
            throw new ItemNotFoundException("Item not found");
        }

        itemRepository.delete(item);

        return ResponseEntity.ok("Item deleted");
    }

    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    public ResponseEntity<String> editItem(ItemEditRequest itemEditRequest)
            throws ItemAlreadyExistsException, ItemNotFoundException{
        Item oldItem = itemRepository.findByName(String.valueOf(itemEditRequest.getCurrentName()));

        if (oldItem == null) {
            throw new ItemNotFoundException("Item not found");
        }

        Item newItem = itemRepository.findByName(itemEditRequest.getItem().getName());

        if (newItem != null) {
            throw new ItemAlreadyExistsException("Item already exists");
        }

        BeanUtils.copyProperties(itemEditRequest.getItem(), oldItem, "id");
        itemRepository.save(oldItem);

        return ResponseEntity.ok("Item updated");
    }
}
