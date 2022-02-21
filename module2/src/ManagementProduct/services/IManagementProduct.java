package ManagementProduct.services;

import ManagementProduct.utils.NotFoundProductException;

public interface IManagementProduct {
    void addExportProduct();
    void addImportProduct();
    void delete() throws NotFoundProductException;
    void display();
    void search();
}
