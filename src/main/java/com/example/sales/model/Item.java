package com.example.sales.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "item")
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@RequiredArgsConstructor
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private long id;

    @NonNull
    @Column(nullable = false)
    @Getter @Setter
    private LocalDateTime version = LocalDateTime.now();;

    @NonNull
    @Column(nullable = false)
    @Getter @Setter
    private String code;

    @NonNull
    @Column(nullable = false, unique = true)
    @Getter @Setter
    private String name;

    @NonNull
    @Column(nullable = false)
    @Getter @Setter
    private Boolean deleted;

    @NonNull
    @Column(nullable = false)
    @Getter @Setter
    private Integer available;

    @NonNull
    @Column(nullable = false)
    @Getter @Setter
    private double price;
}
