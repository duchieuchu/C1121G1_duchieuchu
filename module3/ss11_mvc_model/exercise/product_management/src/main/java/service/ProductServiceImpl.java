package service;

import model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductServiceImpl implements ProductService {
    private static Map<Integer, Product> products;

    static {
        products = new HashMap<>();
        products.put(1, new Product(1, "giày", 100.0, "giày đá banh 7 màu ", "NIKE"));
        products.put(2, new Product(2, "áo", 50.0, "áo thể thao màu xanh", "GUCI"));
        products.put(3, new Product(3, "quần", 50.0, "quần short màu vàng", "VietNam"));
        products.put(4, new Product(4, "mũ", 30.0, "mũ màu trắng", "adidas"));
        products.put(5, new Product(5, "balo", 200.0, "balo sinh tồn, full chức năng", "My"));
        products.put(6, new Product(6, "đồng hồ", 300.0, "dong ho co dien ", "Thuy Si"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public Product findById(Integer id) {
        return products.get(id);
    }

    @Override
    public void update(Integer id, Product product) {
        products.put(id, product);
    }

    @Override
    public void remove(Integer id) {
        products.remove(id);
    }

    @Override
    public List<Product> findByName(String name) {
        return null;
    }

}
