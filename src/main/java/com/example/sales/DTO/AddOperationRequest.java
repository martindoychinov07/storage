package com.example.sales.DTO;

import lombok.*;

import com.example.sales.model.Operation;
import com.example.sales.model.ItemLog;

public class AddOperationRequest {
    @Getter @Setter
    private ItemLog itemLog;

    @Getter @Setter
    private Operation operation;
}
