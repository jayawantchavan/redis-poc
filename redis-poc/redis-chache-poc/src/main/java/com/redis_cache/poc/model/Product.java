package com.redis_cache.poc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Product implements Serializable {
    long id;

    String name;

    long qty;

    float price;

}
