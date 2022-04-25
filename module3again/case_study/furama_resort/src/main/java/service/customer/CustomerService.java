package service.customer;

import model.customer.Customer;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface CustomerService {
    Map<String,String>insertCustomer (Customer customer) throws SQLException;
//    void insertCustomer(Customer customer) throws SQLException;

    Customer selectCustomer(Integer id);

    List<Customer> selectAllCustomer();

    void deleteCustomer(Integer id) throws SQLException;

    Map<String,String>update (Customer customer) throws SQLException;
//    void update(Customer customer) throws SQLException;

    List<Customer> finByName(String name);

    List<Customer> sortByName();

}
