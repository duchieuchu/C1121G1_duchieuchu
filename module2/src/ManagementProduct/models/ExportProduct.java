package ManagementProduct.models;

public class ExportProduct extends Product{
    private double exportPrice;
    private String importCountry;

    public ExportProduct(double exportPrice, String importCountry) {
        this.exportPrice = exportPrice;
        this.importCountry = importCountry;
    }

    public ExportProduct(String productCode, String productName, double price, int numberOfProducts, String production, double exportPrice, String importCountry) {
        super(productCode, productName, price, numberOfProducts, production);
        this.exportPrice = exportPrice;
        this.importCountry = importCountry;
    }

    public double getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(double exportPrice) {
        this.exportPrice = exportPrice;
    }

    public String getImportCountry() {
        return importCountry;
    }

    public void setImportCountry(String importCountry) {
        this.importCountry = importCountry;
    }

    @Override
    public String toString() {
        return "ExportProduct{" +
                "id=" + getId() +
                ", productCode='" + getProductCode() + '\'' +
                ", productName='" + getProductName() + '\'' +
                ", price=" + getPrice() +
                ", numberOfProducts=" + getNumberOfProducts() +
                ", production='" + getProduction() + '\'' +
                ", exportPrice=" + exportPrice +
                ", importCountry='" + importCountry + '\'' +
                '}';
    }
    public String toStringToFileCSV(){
        return getId() + "," + getProductCode() + "," + getProductName() + "," + getPrice() + "," + getNumberOfProducts()
                + "," + getProduction()+","+exportPrice+","+importCountry;
    }
}
