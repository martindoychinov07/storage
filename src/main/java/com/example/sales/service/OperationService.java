package com.example.sales.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.example.sales.model.Operation;
import com.example.sales.repository.ItemLogRepository;
import com.example.sales.DTO.AddOperationRequest;
import com.example.sales.model.ItemLog;
import com.example.sales.repository.OperationRepository;

public class OperationService {
    @Autowired
    ItemLogRepository itemLogRepository;

    @Autowired
    OperationRepository operationRepository;

    @Autowired
    ItemLogService itemLogService;

    public ResponseEntity<String> createOperation(AddOperationRequest addOperationRequest) {
        ItemLog itemLog = itemLogRepository.findByName(addOperationRequest.getItemLog().getName());

//        if (itemLog == null) {
//            itemLog = itemLogService.createItemLog(addOperationRequest.getItemLog());
//        }

        Operation newOperation = new Operation();
        BeanUtils.copyProperties(addOperationRequest.getOperation(), newOperation);
        newOperation.setItemLogId(itemLog.getId());

        operationRepository.save(newOperation);

        return ResponseEntity.ok("Operation created");
    }
}
