package com.example.sales.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "operation")
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@RequiredArgsConstructor
public class Operation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private long id;

    @NonNull
    @Column(nullable = false)
    @Getter @Setter
    private long docId;

    @NonNull
    @Column(nullable = false)
    @Getter @Setter
    private long row;

    @NonNull
    @Column(nullable = false)
    @Getter @Setter
    private long itemLogId;

    @NonNull
    @Column(nullable = false)
    @Getter @Setter
    private String itemNote;

    @NonNull
    @Column(nullable = false)
    @Getter @Setter
    private double packageVar;

    @NonNull
    @Column(nullable = false)
    @Getter @Setter
    private String measure;

    @NonNull
    @Column(nullable = false)
    @Getter @Setter
    private long quantity;

    @NonNull
    @Column(nullable = false)
    @Getter @Setter
    private double price;

    @NonNull
    @Column(nullable = false)
    @Getter @Setter
    private double discount;

    @NonNull
    @Column(nullable = false)
    @Getter @Setter
    private double tax;

    @NonNull
    @Column(nullable = false)
    @Getter @Setter
    private long available;
}
