package com.example.sales.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "setting")
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@RequiredArgsConstructor
public class Setting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private long id;

    @NonNull
    @Column(nullable = false)
    @Getter @Setter
    private long index;


    @NonNull
    @Column(nullable = false)
    @Getter @Setter
    private String description;

    @NonNull
    @Column(nullable = false)
    @Getter @Setter
    private String value;

    @NonNull
    @Column(nullable = false)
    @Getter @Setter
    private String attribute;

    @NonNull
    @Column(nullable = false)
    @Getter @Setter
    private String rights;
}
