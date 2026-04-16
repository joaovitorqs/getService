package com.jpadev.get_service.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "cards")
@Getter
@Setter
@NoArgsConstructor
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nameClient;
    private String contact;
    private String title;
    private String description;

    private LocalDateTime createdTime;
    private LocalDateTime timeExpired;

    public Card(String nameClient, String contact, String title, String description, LocalDateTime createdTime, LocalDateTime timeExpired) {
        this.nameClient = nameClient;
        this.contact = contact;
        this.title = title;
        this.description = description;
        this.createdTime = createdTime;
        this.timeExpired = timeExpired;
    }
}
