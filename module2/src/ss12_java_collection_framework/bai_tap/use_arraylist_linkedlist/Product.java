package ss12_java_collection_framework.bai_tap.use_arraylist_linkedlist;

public class Product implements Comparable<Product> {
    private int id;
    private String name;
    private int price;
    private String information;

    public Product() {
    }

    public Product(int id, String name, int price, String information) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.information = information;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", information='" + information + '\'' +
                '}';
    }

    @Override
    public int compareTo(Product o) {
        return this.getPrice()-o.price;
    }
}
