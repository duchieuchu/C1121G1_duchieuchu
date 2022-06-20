package com.codegym.repository;

import com.codegym.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductRepository implements IProductRepository {
    private static final Map<Integer, Product> products;

    static {
        products = new HashMap<>();
        products.put(1, new Product(1, "giay", "giay bong ro", 100, "Hoa Ki"));
        products.put(2, new Product(2, "mu", "dang cap nhat", 100, "Hoa Ki"));
        products.put(3, new Product(3, "balo", "dang cap nhat", 100, "Hoa Ki"));
        products.put(4, new Product(4, "day chuyen", "dang cap nhat", 100, "Hoa Ki"));
        products.put(5, new Product(5, "bao tay", "dang cap nhat", 100, "Hoa Ki"));
        products.put(6, new Product(6, "ao", "dang cap nhat", 100, "Hoa Ki"));
        products.put(7, new Product(7, "quan", "dang cap nhat", 100, "Hoa Ki"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        int id = (int) (Math.random() * 100);
        product.setId(id);
        products.put(product.getId(), product);
    }

    @Override
    public void delete(Integer id) {
        products.remove(id);
    }

    @Override
    public void update(Integer id, Product product) {
         products.put(id, product);
    }

    @Override
    public Product findById(Integer id) {
        return products.get(id);
    }

    @Override
    public List<Product> findAllByName(String name) {
        List<Product> productList = findAll();
        List<Product> searchList = new ArrayList<>();
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getName().contains(name)) {
                searchList.add(productList.get(i));
            }
        }
        return searchList;
    }


}
