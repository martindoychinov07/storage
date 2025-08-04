package com.example.sales.DTO;

import com.example.sales.model.ItemLog;
import com.example.sales.model.Operation;
import lombok.Getter;
import lombok.Setter;

public class ItemLogRequest {
    @Getter
    @Setter
    private String itemLogName;

    @Getter @Setter
    private String itemName;
}
