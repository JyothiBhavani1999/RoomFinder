package com.jyothi.RoomFinder.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;

@Entity
public class Room {

    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;
    private String city;
    private String address;
    private Double rent;
}
