package com.redis_cache.poc.port;

import com.redis_cache.poc.core.ProductService;
import com.redis_cache.poc.model.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@CrossOrigin(origins = "*", allowedHeaders = "*", exposedHeaders = "*")
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping("/get/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable long id) {
        long startTime = System.currentTimeMillis();
        Product product = productService.getProduct(id);
        long endTime = System.currentTimeMillis();
        long diff = endTime - startTime;
        System.out.println("Time Taken : "+diff+" ms");
        return ResponseEntity.status(HttpStatus.OK).body(product);
    }


}
