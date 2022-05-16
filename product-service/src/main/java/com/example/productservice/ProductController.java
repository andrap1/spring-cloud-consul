package com.example.productservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ProductController {

    private static Map<String, List<Product>> productsFromShop=new HashMap<>();

    static{
        List<Product> products=new ArrayList<>();
        Product product1=new Product("Soap", 22.3f);
        products.add(product1);
        productsFromShop.put("SoapsShop", products);
    }

    @GetMapping("/products/{shopName}")
    public List<Product> getProductsFromShop(@PathVariable("shopName") String shopName){
        return this.productsFromShop.get(shopName);
    }
}
