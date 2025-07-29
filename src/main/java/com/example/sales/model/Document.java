package com.example.sales.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "document")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@RequiredArgsConstructor
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private long id;

    @NonNull
    @Column(nullable = false)
    @Getter @Setter
    private LocalDateTime docDate = LocalDateTime.now();

    @NonNull
    @Column(nullable = false)
    @Getter @Setter
    private long docType;

    @NonNull
    @Column(nullable = false)
    @Getter @Setter
    private String docNumber;

    @NonNull
    @Column(nullable = false)
    @Getter @Setter
    private long supplierId;

    @NonNull
    @Column(nullable = false)
    @Getter @Setter
    private long customerId;

    @NonNull
    @Column(nullable = false)
    @Getter @Setter
    private long payment;

    @NonNull
    @Column(nullable = false)
    @Getter @Setter
    private String note;

    @NonNull
    @Column(nullable = false)
    @Getter @Setter
    private long userId;

    @NonNull
    @Column(nullable = false)
    @Getter @Setter
    private long availability;

    @NonNull
    @Column(nullable = false)
    @Getter @Setter
    private Boolean deleted;

    @NonNull
    @Column(nullable = false)
    @Getter @Setter
    private String reference;

    @NonNull
    @Column(nullable = false)
    @Getter @Setter
    private long partnerLogId;
}
