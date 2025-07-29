package com.example.sales.DTO;

import lombok.*;

import com.example.sales.model.Item;

public class AddItemRequest {
    @Getter @Setter
    private Item item;

    @Getter @Setter
    private long docId;
}
