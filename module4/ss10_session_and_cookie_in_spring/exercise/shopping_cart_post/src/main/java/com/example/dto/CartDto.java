package com.example.dto;

import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class CartDto {
    private Map<ProductDto, Integer> productMap = new HashMap<>();

    public CartDto() {
    }

    public Map<ProductDto, Integer> getProductMap() {
        return productMap;
    }

    public void setProductMap(Map<ProductDto, Integer> productMap) {
        this.productMap = productMap;
    }

    //them
    public void addProduct(ProductDto productDto) {
        if (productMap.containsKey(productDto)) {
            Integer currentValue = productMap.get(productDto);
            productMap.put(productDto, currentValue + 1);
        } else {
            productMap.put(productDto, 1);
        }
    }
    public void subProduct(ProductDto productDto) {
        Integer currentValue = productMap.get(productDto);
        if (currentValue==0) {
            productMap.put(productDto, currentValue);
        } else {
            productMap.put(productDto, currentValue - 1);
        }
    }
    public void deleteAll(){
        productMap.clear();
    }
//    public Float countTotalPayment(){
//        float payment = 0;
//        for (Map.Entry<ProductDto, Integer> entry : productMap.entrySet()) {
//            payment += entry.getKey().getPrice() * (Integer) entry.getValue();
//        }
//        return payment;
//    }
    public String countTotalPayment(){
        // Locale là đối tượng đại diện duy nhất cho các ngôn ngữ và quốc gia, khu vực
        // khác nhau trên toàn thế giới
        Locale locale = new Locale("vi","vn");
        // tạo 1 NumberFormat để định dạng số của khu vực hiện tại của máy ảo JVM
        // dùng để định dạng số chung cho quốc gia
        NumberFormat vn = NumberFormat.getInstance(locale);

        float payment = 0;
        for (Map.Entry<ProductDto, Integer> entry : productMap.entrySet()) {
            payment += entry.getKey().getPrice() * (float) entry.getValue();
        }

        return vn.format(payment);
    }

}
