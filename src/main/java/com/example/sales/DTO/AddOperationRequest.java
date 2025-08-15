package com.example.sales.DTO;

import lombok.*;

import com.example.sales.model.Operation;
import com.example.sales.model.ItemLog;

@Data
public class AddOperationRequest {
    @Getter @Setter
//    private ItemLog itemLog;
    private String itemLogName;

    @Getter @Setter
    private Operation operation;
}
