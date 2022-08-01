package com.example.controller;

import com.example.model.Product;
import com.example.model.ProductBlock;
import com.example.service.IProductBlockService;
import com.example.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/rest/product-block")
public class ProductBlockRestController {
    @Autowired
    private IProductBlockService iProductBlockService;
//    @Autowired
//    private IProductService iProductService;
//    @GetMapping("/list")
//    public ResponseEntity<List<Product>>getAllProduct(){
//        List<Product>productList=this.iProductService.findAll();
//        return new ResponseEntity<>(productList, HttpStatus.OK);
//    }
//    @GetMapping("")
//    public ResponseEntity<Page<ProductBlock>> getAllProductBlock(@PageableDefault(4) Pageable pageable) {
//        Page<ProductBlock> productBlockPage = this.iProductBlockService.findAll(pageable);
//        if (productBlockPage.isEmpty()){
//            return  new ResponseEntity<>(productBlockPage, HttpStatus.NO_CONTENT);
//        }else {
//            return new ResponseEntity<>(productBlockPage,HttpStatus.OK);
//        }
//    }

    @GetMapping("")
    public ResponseEntity<List<ProductBlock>> getAllProductBlock() {
        List<ProductBlock> productBlockList = this.iProductBlockService.findAll();
        if (productBlockList.isEmpty()) {
            return new ResponseEntity<>(productBlockList, HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(productBlockList, HttpStatus.OK);
        }
    }

    @GetMapping("/findById{id}")
    public ResponseEntity<ProductBlock> findById(@PathVariable Integer id) {
        ProductBlock productBlock = this.iProductBlockService.findById(id);
        return new ResponseEntity<>(productBlock, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Void> createProductBlock(@RequestBody ProductBlock productBlock) {
        this.iProductBlockService.save(productBlock);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteProductBlock(@PathVariable Integer id) {
        this.iProductBlockService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
