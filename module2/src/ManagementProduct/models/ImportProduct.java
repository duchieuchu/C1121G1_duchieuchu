package ManagementProduct.models;

public class ImportProduct extends Product{
    private double importPrice ;
    private String importProvince;
    private double importTax;

    public ImportProduct(double importPrice, String importProvince, double importTax) {
        this.importPrice = importPrice;
        this.importProvince = importProvince;
        this.importTax = importTax;
    }

    public ImportProduct(String productCode, String productName, double price, int numberOfProducts, String production, double importPrice, String importProvince, double importTax) {
        super(productCode, productName, price, numberOfProducts, production);
        this.importPrice = importPrice;
        this.importProvince = importProvince;
        this.importTax = importTax;
    }

    public double getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(double importPrice) {
        this.importPrice = importPrice;
    }

    public String getImportProvince() {
        return importProvince;
    }

    public void setImportProvince(String importProvince) {
        this.importProvince = importProvince;
    }

    public double getImportTax() {
        return importTax;
    }

    public void setImportTax(double importTax) {
        this.importTax = importTax;
    }

    @Override
    public String toString() {
        return "ImportedProduct{" +
                "id=" + getId() +
                ", productCode='" + getProductCode() + '\'' +
                ", productName='" + getProductName() + '\'' +
                ", price=" + getPrice() +
                ", numberOfProducts=" + getNumberOfProducts() +
                ", production='" + getProduction() + '\'' +
                ", importPrice=" + importPrice +
                ", importProvince='" + importProvince + '\'' +
                ", importTax=" + importTax +
                '}';
    }
    public String toStringToFileCSV(){
        return getId() + "," + getProductCode() + "," + getProductName() + "," + getPrice() + "," + getNumberOfProducts()
                + "," + getProduction()+","+importPrice+","+importProvince+","+importTax;
    }
}
