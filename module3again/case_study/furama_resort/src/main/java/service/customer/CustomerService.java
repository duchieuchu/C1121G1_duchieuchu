package service.customer;

import model.customer.Customer;

import java.sql.SQLException;
import java.util.List;

public interface CustomerService {
    void insertCustomer(Customer customer) throws SQLException;

    Customer selectCustomer(Integer id);

    List<Customer> selectAllCustomer();

    void deleteCustomer(Integer id) throws SQLException;

    void update(Customer customer) throws SQLException;

    List<Customer> finByName(String name);

    List<Customer> sortByName();

}
