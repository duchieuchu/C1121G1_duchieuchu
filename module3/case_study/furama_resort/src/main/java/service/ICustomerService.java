package service;

import model.customer.Customer;

import java.sql.SQLException;
import java.util.List;

public interface ICustomerService {
    List<Customer> selectAllCustomers();

    Customer selectCustomer(int id);

    void insertCustomer(Customer customer) throws SQLException;

    void deleteCustomer(int id) throws SQLException;

    void updateCustomer(Customer customer) throws SQLException;

    List<Customer> searchCustomer(String customerName,String customerTypeName);
}
