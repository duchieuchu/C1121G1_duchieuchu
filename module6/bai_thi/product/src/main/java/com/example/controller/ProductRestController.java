package com.example.controller;

import com.example.model.product.Product;
import com.example.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/product")
public class ProductRestController {
    @Autowired
    private IProductService iProductService;


    @GetMapping("/getAllProduct")
    public ResponseEntity<List<Product>> getAllProduct() {
        List<Product> productList = this.iProductService.getAllProduct();
        if (productList.isEmpty()) {
            return new ResponseEntity<>(productList, HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(productList, HttpStatus.OK);
        }
    }

    @PatchMapping("/delete/{id}")
    public ResponseEntity<Void> deleteDish(@PathVariable Integer id) {
        this.iProductService.deleteProduct(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Void> createProductBlock(@RequestBody Product product) {
        this.iProductService.save(product);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
