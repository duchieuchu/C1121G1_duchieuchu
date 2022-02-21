package ManagementProduct.models;

public abstract class Product {
    //: Id sản phẩm, Mã sản phẩm, Tên sản phẩm, Giá bán, Số lượng, Nhà sản xuất.
    static int number = 1;
    private int id;
    private String productCode;
    private String productName;
    private double price;
    private int numberOfProducts;
    private String production;

    public Product(){
        id=number++;
    }

    public Product(String productCode, String productName, double price, int numberOfProducts, String production) {
        this.id =number++;
        this.productCode = productCode;
        this.productName = productName;
        this.price = price;
        this.numberOfProducts = numberOfProducts;
        this.production = production;
    }

    public static int getNumber() {
        return number;
    }

    public static void setNumber(int number) {
        Product.number = number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNumberOfProducts() {
        return numberOfProducts;
    }

    public void setNumberOfProducts(int numberOfProducts) {
        this.numberOfProducts = numberOfProducts;
    }

    public String getProduction() {
        return production;
    }

    public void setProduction(String production) {
        this.production = production;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productCode='" + productCode + '\'' +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                ", numberOfProducts=" + numberOfProducts +
                ", production='" + production + '\'' +
                '}';
    }
    public String toStringToFileCSV(){
        return id + "," + productCode + "," + productName + "," + price + "," + numberOfProducts + "," + production;
    }
}
