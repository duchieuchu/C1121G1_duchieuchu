package com.example.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class ProductBlock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String code;

    @OneToMany(mappedBy = "productBlock")
    List<Product> productList;
    private Integer quantity;
    private String dateImport;
    private String dateDo;
    private String dateNoUse;

    public ProductBlock(Integer id, String code, List<Product> productList, Integer quantity, String dateImport, String dateDo, String dateNoUse) {
        this.id = id;
        this.code = code;
        this.productList = productList;
        this.quantity = quantity;
        this.dateImport = dateImport;
        this.dateDo = dateDo;
        this.dateNoUse = dateNoUse;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getDateImport() {
        return dateImport;
    }

    public void setDateImport(String dateImport) {
        this.dateImport = dateImport;
    }

    public String getDateDo() {
        return dateDo;
    }

    public void setDateDo(String dateDo) {
        this.dateDo = dateDo;
    }

    public String getDateNoUse() {
        return dateNoUse;
    }

    public void setDateNoUse(String dateNoUse) {
        this.dateNoUse = dateNoUse;
    }
}
