package com.geekbrains.gbrestdemo.controllers;

import com.geekbrains.gbrestdemo.entities.Product;
import com.geekbrains.gbrestdemo.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/**")
public class ProductRestController {

    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(path = "/products")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping(path = "/products/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @PostMapping(path = "/products")
    public Product addProduct(@RequestBody Product product) {
        product = productService.saveOrUpdate(product);
        return product;
    }

    @PutMapping(path = "/products")
    public Product updateProduct(@RequestBody Product product) {
        product = productService.saveOrUpdate(product);
        return product;
    }

    @DeleteMapping(path = "/products/{id}")
    public int deleteProductById(@PathVariable Long id) {
        productService.deleteProductById(id);
        return HttpStatus.OK.value();
    }
}
