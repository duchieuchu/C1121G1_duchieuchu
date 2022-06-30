package com.example.dto;

import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Locale;
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
        if (currentValue == 0) {
            productDtoIntegerMap.put(productDto, currentValue);
        } else {
            productDtoIntegerMap.put(productDto, currentValue - 1);
        }
    }

    public void deleteAll() {
        productDtoIntegerMap.clear();
    }
    public String countTotalPayment(){
        // Locale là đối tượng đại diện duy nhất cho các ngôn ngữ và quốc gia, khu vực
        // khác nhau trên toàn thế giới
        Locale locale = new Locale("vi","vn");
        // tạo 1 NumberFormat để định dạng số của khu vực hiện tại của máy ảo JVM
        // dùng để định dạng số chung cho quốc gia
        NumberFormat vn = NumberFormat.getInstance(locale);

        float payment = 0;
        for (Map.Entry<ProductDto, Integer> entry : productDtoIntegerMap.entrySet()) {
            payment += entry.getKey().getPrice() * (float) entry.getValue();
        }

        return vn.format(payment);
    }
}
