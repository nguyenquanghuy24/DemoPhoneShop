package com.example.phoneshop;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String brand;
    private double price;
    private int stock;
}