package com.example.sales.controller;

import com.example.sales.DTO.AddOperationRequest;
import com.example.sales.model.Operation;
import com.example.sales.service.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
@RestController
@RequestMapping("/operation")
public class OperationController {
    @Autowired
    OperationService operationService;

    @PostMapping("/create")
    public ResponseEntity<String> createOperation(@RequestBody AddOperationRequest addOperationRequest) {
        return operationService.createOperation(addOperationRequest);
    }
}
