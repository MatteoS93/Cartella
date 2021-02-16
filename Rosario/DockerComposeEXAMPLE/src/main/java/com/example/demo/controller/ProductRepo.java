package com.example.demo.controller;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Product;



@Repository
public interface ProductRepo extends MongoRepository<Product,Long> {

}
