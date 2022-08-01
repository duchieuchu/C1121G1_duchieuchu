package com.example.controller;

import com.example.model.ProductBlock;
import com.example.service.IProductBlockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/rest/product-block")
public class ProductBlockRestController {
    @Autowired
    private IProductBlockService iProductBlockService;

    @GetMapping("")
    public ResponseEntity<Page<ProductBlock>> getAllProductBlock(@PageableDefault(4) Pageable pageable) {
        Page<ProductBlock> productBlockPage = this.iProductBlockService.findAll(pageable);
        if (productBlockPage.isEmpty()){
            return  new ResponseEntity<>(productBlockPage, HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(productBlockPage,HttpStatus.OK);
        }
    }


}
