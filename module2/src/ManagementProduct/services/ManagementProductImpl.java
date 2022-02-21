package ManagementProduct.services;

import ManagementProduct.models.ExportProduct;
import ManagementProduct.models.ImportProduct;
import ManagementProduct.models.Product;
import ManagementProduct.utils.NotFoundProductException;
import ManagementProduct.utils.ValidationC10;
import ManagementProduct.utils.WriteFileAndReadFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManagementProductImpl implements IManagementProduct {
    private static final String PRODUCT_PATH = "src/ManagementProduct/data/product.csv";

    static Scanner scanner = new Scanner(System.in);

    ValidationC10 validationC10 = new ValidationC10();
    public static List<Product> productList = WriteFileAndReadFile.convertStringListToProductList(WriteFileAndReadFile.readFileCSVToStringList(PRODUCT_PATH));


    @Override
    public void addExportProduct() {//xuat khau
        List<Product> exportProductList = new ArrayList<>();
        List<String> stringExportProductList;
        productList = WriteFileAndReadFile.convertStringListToProductList(
                WriteFileAndReadFile.readFileCSVToStringList(PRODUCT_PATH));
        String codeProduct = null;
        boolean flagMaSanPham = true;
        while (flagMaSanPham) {
            codeProduct = validationC10.resultCodeProductAfterValidate("Nhập mã sản phẩm: ");
            for (Product product:productList ) {
                if (product.getProductCode().equals(codeProduct)) {
                    System.out.println("Mã sản phẩm đã tồn tại!!! Vui lòng nhập lại!!!");
                    flagMaSanPham = true;
                    break;
                } else {
                    flagMaSanPham = false;
                }
            }
        }
        String productName= validationC10.resultStringAfterValidate("\"enter productName: \"");
        double price = validationC10.resultDoubleAfterValidate("Nhập giá bán: ");
        int numberOfProducts = validationC10.resultIntAfterValidate("Nhập số lượng: ");
        String production = validationC10.resultStringAfterValidate("Nhập nhà sản xuất: ");
        double exportPrice = validationC10.resultDoubleAfterValidate("Nhập giá xuất khẩu: ");
        String importCountry = validationC10.resultStringAfterValidate("Nhập quốc gia nhập sản phẩm: ");

        exportProductList.add(new ExportProduct(codeProduct, productName, price, numberOfProducts, production,
                exportPrice, importCountry));
//        if (productList.isEmpty()) {
//            ;
//        } else {
//            sanPhamXuatKhau.setIdSanPham(sanPhamList.get(sanPhamList.size() - 1).getIdSanPham() + 1);
//        }

        stringExportProductList = WriteFileAndReadFile.convertProductListToStringList(exportProductList);

        WriteFileAndReadFile.writeStringListIntoCSVFile(PRODUCT_PATH, stringExportProductList, true);

    }

    @Override
    public void addImportProduct() {//nhap khau
        List<Product> importProductList = new ArrayList<>();
        List<String> stringImportProductList;

        System.out.print("enter productCode: ");
        String productCode = scanner.nextLine();
        System.out.print("enter productName: ");
        String productName = scanner.nextLine();
        System.out.print("enter price: ");
        double price = Double.parseDouble(scanner.nextLine());
        System.out.print("enter numberOfProducts: ");
        int numberOfProducts = Integer.parseInt(scanner.nextLine());
        System.out.print("enter production: ");
        String production = scanner.nextLine();

        System.out.print("enter importPrice: ");
        double importPrice = Double.parseDouble(scanner.nextLine());
        System.out.print("enter importProvince: ");
        String importProvince = scanner.nextLine();
        System.out.print("enter importTax: ");
        double importTax = Double.parseDouble(scanner.nextLine());

        importProductList.add(new ImportProduct(productCode, productName, price, numberOfProducts, production,
                importPrice, importProvince, importTax));
        stringImportProductList = WriteFileAndReadFile.convertProductListToStringList(importProductList);

        WriteFileAndReadFile.writeStringListIntoCSVFile(PRODUCT_PATH, stringImportProductList, true);

    }

    @Override
    public void delete() throws NotFoundProductException {
        chonMaSanPhamLoop:
        while (true) {
            display();
            System.out.print("Chọn mã sản phẩm muốn xoá: ");
            String maSanPham = scanner.nextLine();
            if (maSanPham.trim().equals("")) {
                System.out.println("Nhập sai!!! Hãy nhập lại!");
            } else {
                List<String> stringList = WriteFileAndReadFile.readFileCSVToStringList(PRODUCT_PATH);
                List<Product> productList = WriteFileAndReadFile.convertStringListToProductList(stringList);
                boolean flag = false;
                for (Product product : productList) {
                    if (product.getProductCode().equals(maSanPham)) {
                        do {
                            int xacNhan;
                            try {
                                System.out.println("Bạn có xác nhận xoá sản phẩm với mã sản phẩm là: " + maSanPham);
                                System.out.println("1. Có");
                                System.out.println("2. Không");
                                System.out.print("Bạn chọn: ");
                                xacNhan = Integer.parseInt(scanner.nextLine());
                                switch (xacNhan) {
                                    case 1:
                                        productList.remove(product);
                                        stringList = WriteFileAndReadFile.convertProductListToStringList(productList);
                                        WriteFileAndReadFile.writeStringListIntoCSVFile(PRODUCT_PATH, stringList, false);
                                        System.out.println("Bạn đã xoá thành công!!!");
                                        break chonMaSanPhamLoop;
                                    case 2:
                                        System.out.println("Bạn đã huỷ xoá!");
                                        break chonMaSanPhamLoop;
                                    default:
                                        System.out.println("Bạn chọn sai!!! Hãy nhập lại!");
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("Nhập sai định dạng!!! Hãy nhập lại!");
                            }
                        } while (true);
                    } else {
                        flag = true;
                    }
                }
                if (flag) {
                    throw new NotFoundProductException();
                }
            }
        }
    }

    @Override
    public void display() {
        List<String> stringList = WriteFileAndReadFile.readFileCSVToStringList(PRODUCT_PATH);
        List<Product> productList = WriteFileAndReadFile.convertStringListToProductList(stringList);
        System.out.println("List of products: ");
        for (Product product : productList) {
            System.out.println(product);
        }

    }

    @Override
    public void search() {
        while (true) {
            display();
            System.out.print("enter codeProduct or nameProduct to search:  ");
            String informationProduct = scanner.nextLine();
            if (informationProduct.trim().equals("")) {
                System.out.println("Error!!! Please enter again!");
            } else {
                List<String> stringList = WriteFileAndReadFile.readFileCSVToStringList(PRODUCT_PATH);
                List<Product> productList = WriteFileAndReadFile.convertStringListToProductList(stringList);
                boolean flag = false;
                for (Product product : productList) {
                    if (product.getProductCode().toLowerCase().contains(informationProduct.toLowerCase())
                            || product.getProductName().toLowerCase().contains(informationProduct.toLowerCase())) {
                        System.out.println(product);
                        flag = true;
                    }
                }
                if (!flag) {
                    System.out.println("Not found!!! Please enter again");
                } else {
                    break;
                }
            }
        }

    }
}
