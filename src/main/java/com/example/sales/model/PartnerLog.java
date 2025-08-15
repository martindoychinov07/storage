package com.example.sales.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "partner_log")
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@RequiredArgsConstructor
public class PartnerLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
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
    @Column(nullable = false)
    @Getter @Setter
    private String name;

    @NonNull
    @Column(nullable = false)
    @Getter @Setter
    private String address;

    @NonNull
    @Column(nullable = false)
    @Getter @Setter
    private String phone;

    @NonNull
    @Column(nullable = false)
    @Getter @Setter
    private String responsible;

    @NonNull
    @Column(nullable = false)
    @Getter @Setter
    private String account;

    @NonNull
    @Column(nullable = false)
    @Getter @Setter
    private String note;

    @NonNull
    @Column(nullable = false)
    @Getter @Setter
    private Boolean deleted = false;

    @NonNull
    @Column(nullable = false)
    @Getter @Setter
    private long refId;
}