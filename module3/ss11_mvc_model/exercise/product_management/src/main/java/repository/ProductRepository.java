package repository;

import model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ProductRepository implements IProductRepository {
    static Map<Integer, Product> products = new TreeMap<>();

    static {
        products.put(1, new Product(1, "giày", 100.0, "giày đá banh 7 màu ", "NIKE"));
        products.put(2, new Product(2, "áo", 50.0, "áo thể thao màu xanh", "GUCI"));
        products.put(3, new Product(3, "quần", 50.0, "quần short màu vàng", "VietNam"));
        products.put(4, new Product(4, "mũ", 30.0, "mũ màu trắng", "adidas"));
        products.put(5, new Product(5, "balo", 200.0, "balo sinh tồn, full chức năng", "My"));
        products.put(6, new Product(6, "đồng hồ", 300.0, "dong ho co dien ", "Thuy Si"));
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public void update(int id, Product product) {
        products.put(id, product);
    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public List<Product> findByName(String name) {
        ArrayList<Product> productList = new ArrayList();
        for (Map.Entry<Integer, Product> map : products.entrySet()) {
            if (map.getValue().getName().contains(name)) {
                productList.add(map.getValue());
            }
        }
        return productList;
    }
}
