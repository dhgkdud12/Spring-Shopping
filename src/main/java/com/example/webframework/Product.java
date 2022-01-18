package com.example.webframework;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private int id;
    private String category;
    private String img;
    private String name;
    private String size;
    private int price;
}
