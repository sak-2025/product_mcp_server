package com.sak.products;

import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private List<Products> productList = new ArrayList<>();
    private Logger log =LoggerFactory.getLogger(ProductService.class);

@Tool( name ="single_product" , description = "Get Product based on title")
    public Products getProductById(String title) {
        log.info("Getting product by id");
        return productList.stream().filter(product->product.title().equals(title)).findFirst().orElse(null);
    }

    @Tool( name ="product_list" , description = "Get all Product")
    public List<Products> getAllProducts() {
        log.info("Getting all products");
        return productList;
    }

    @PostConstruct
    public void init() {
        log.info("ProductService initialized");
        productList.addAll(List.of(
                    new Products("Java", "Programming Language"),
                    new Products("TV", " Electronics"),
                    new Products("Food", "Grocery")
        ));
    }


}
