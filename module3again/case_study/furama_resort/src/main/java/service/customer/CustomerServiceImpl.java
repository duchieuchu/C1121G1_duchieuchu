package service.customer;

import model.customer.Customer;
import repository.customer.CustomerRepository;
import repository.customer.impl.CustomerRepositoryImpl;

import java.sql.SQLException;
import java.util.List;

public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository = new CustomerRepositoryImpl();

    @Override
    public void insertCustomer(Customer customer) throws SQLException {
        this.customerRepository.insertCustomer(customer);
    }

    @Override
    public Customer selectCustomer(Integer id) {
        return this.customerRepository.selectCustomer(id);
    }

    @Override
    public List<Customer> selectAllCustomer() {
        return this.customerRepository.selectAllCustomer();
    }

    @Override
    public void deleteCustomer(Integer id) throws SQLException {
        this.customerRepository.deleteCustomer(id);
    }

    @Override
    public void update(Customer customer) throws SQLException {
        this.customerRepository.update(customer);
    }

    @Override
    public List<Customer> finByName(String name) {
        return this.customerRepository.finByName(name);
    }

    @Override
    public List<Customer> sortByName() {
        return this.customerRepository.sortByName();
    }
}
