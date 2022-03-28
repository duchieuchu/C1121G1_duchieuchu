package service.impl;

import model.customer.Customer;
import repository.customer.ICustomerRepository;
import repository.impl.CustomerRepository;
import service.ICustomerService;

import java.sql.SQLException;
import java.util.List;

public class CustomerService implements ICustomerService {
    private ICustomerRepository customerRepository = new CustomerRepository();

    @Override
    public List<Customer> selectAllCustomers() {
        return this.customerRepository.selectAllCustomers();
    }

    @Override
    public Customer selectCustomer(int id) {
        return this.customerRepository.selectCustomer(id);
    }

    @Override
    public void insertCustomer(Customer customer) throws SQLException {
        customerRepository.insertCustomer(customer);
    }

    @Override
    public void deleteCustomer(int id) throws SQLException {
        this.customerRepository.deleteCustomer(id);
    }

    @Override
    public void updateCustomer(Customer customer) throws SQLException {
        customerRepository.updateCustomer(customer);
    }

    @Override
    public List<Customer> searchCustomer(String customerName, String customerTypeName) {
        return null;
    }
}
