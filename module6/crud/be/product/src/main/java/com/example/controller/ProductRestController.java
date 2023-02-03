package com.example.controller;

import com.example.dto.ProductDto;
import com.example.model.Product;
import com.example.service.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/product")
public class ProductRestController {

    @Autowired
    private IProductService iProductService;

    @GetMapping("/getPageProduct")
    public ResponseEntity<Page<Product>> getPageProduct(@PageableDefault(5) Pageable pageable) {
        Page<Product> productPage = this.iProductService.getPageProduct(pageable);
        if (productPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else
            return new ResponseEntity<>(productPage, HttpStatus.OK);
    }



    @PatchMapping("/deleteProduct/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Integer id) {
        this.iProductService.deleteProduct(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/getProductById/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Integer id) {
        Product product = this.iProductService.getProductById(id);
        if (product == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else
            return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @PostMapping("/createProduct")
    public ResponseEntity<Product> createProduct(@Valid @RequestBody ProductDto productDto, BindingResult bindingResult) {
        productDto.validate(productDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Product product = new Product();
        BeanUtils.copyProperties(productDto, product);
        this.iProductService.createProduct(product);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping("/editProduct")
    public ResponseEntity<Product> editProduct(@Valid @RequestBody ProductDto productDto, BindingResult bindingResult) {
        productDto.validate(productDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Product product = new Product();
        BeanUtils.copyProperties(productDto, product);
        this.iProductService.editProduct(product);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping("/deleteProductById/{id}")
    public ResponseEntity<Product> deleteProductById(@PathVariable Integer id) {
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            iProductService.deleteProduct(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }


}
