package com.example.sales.service;

import com.example.sales.exception.ItemNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.example.sales.model.Operation;
import com.example.sales.repository.ItemLogRepository;
import com.example.sales.DTO.AddOperationRequest;
import com.example.sales.model.ItemLog;
import com.example.sales.repository.OperationRepository;
import org.springframework.stereotype.Service;

@Service
public class OperationService {
    @Autowired
    ItemLogRepository itemLogRepository;

    @Autowired
    OperationRepository operationRepository;

    @Autowired
    ItemLogService itemLogService;

    public ResponseEntity<String> createOperation(AddOperationRequest addOperationRequest)
            throws ItemNotFoundException {
        ItemLog itemLog = itemLogRepository.findByName(addOperationRequest.getItemLogName());

        if (itemLog == null) {
            throw new ItemNotFoundException("ItemLog not found");
        }

        Operation newOperation = new Operation();
        BeanUtils.copyProperties(addOperationRequest.getOperation(), newOperation);
        newOperation.setItemLogId(itemLog.getId());

        operationRepository.save(newOperation);

        return ResponseEntity.ok("Operation created");
    }
}
