package com.example.sales.DTO;

import lombok.*;

import com.example.sales.model.Document;

public class DocumentCreateRequest {
    @Getter @Setter
    private Document document;

    @Getter @Setter
    private String name;
}
