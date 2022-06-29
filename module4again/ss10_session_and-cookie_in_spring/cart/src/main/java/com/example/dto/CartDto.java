package com.example.dto;

import java.util.HashMap;
import java.util.Map;

public class CartDto {
    private Map<ProductDto, Integer> productDtoIntegerMap = new HashMap<>();

    public CartDto() {

    }

    public Map<ProductDto, Integer> getProductDtoIntegerMap() {
        return productDtoIntegerMap;
    }

    public void setProductDtoIntegerMap(Map<ProductDto, Integer> productDtoIntegerMap) {
        this.productDtoIntegerMap = productDtoIntegerMap;
    }

    public void addProductToCart(ProductDto productDto) {
        if (productDtoIntegerMap.containsKey(productDto)) {
            Integer currentValue = productDtoIntegerMap.get(productDto);
            productDtoIntegerMap.put(productDto, currentValue + 1);
        } else {
            productDtoIntegerMap.put(productDto, 1);
        }
    }

    public void subProductToCart(ProductDto productDto) {
        Integer currentValue = productDtoIntegerMap.get(productDto);
        if (currentValue==0) {
            productDtoIntegerMap.put(productDto, currentValue);
        } else {
            productDtoIntegerMap.put(productDto, currentValue - 1);
        }
    }
}
