package com.example.controller;

import com.example.dto.BaseDto;
import com.example.dto.ProductDto;
import com.example.model.Base;
import com.example.model.Employee;
import com.example.model.Product;
import com.example.service.IBaseService;
import com.example.service.IEmployeeService;
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
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/base")
public class BaseRestController {
    @Autowired
    private IBaseService iBaseService;
    @Autowired
    private IEmployeeService iEmployeeService;

    @GetMapping("/getAllEmployeeList")
    public ResponseEntity<List<Employee>> getAllEmployeeList() {
        List<Employee> productList = this.iEmployeeService.getList();
        if (productList.isEmpty()) {
            return new ResponseEntity<>(productList, HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(productList, HttpStatus.OK);
        }
    }

    @GetMapping("/getAllBaseList")
    public ResponseEntity<List<Base>> getAllProduct() {
        List<Base> productList = this.iBaseService.getAllBase1();
        if (productList.isEmpty()) {
            return new ResponseEntity<>(productList, HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(productList, HttpStatus.OK);
        }
    }

    @GetMapping("/searchList")
    public ResponseEntity<List<Base>> search(String name) {
        if (name == null) {
            name = "";
        }
        List<Base> productList = this.iBaseService.searchBase(name);
        if (productList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(productList, HttpStatus.OK);
        }
    }

    @PatchMapping("/deleteBase/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Integer id) {
        this.iBaseService.deleteBase(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/createBase")
    public ResponseEntity<Product> createProduct(@Valid @RequestBody BaseDto baseDto, BindingResult bindingResult) {
        baseDto.validate(baseDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Base base = new Base();
        BeanUtils.copyProperties(baseDto, base);
        this.iBaseService.createBase(base);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
