package service.customer;

import model.customer.Customer;
import repository.customer.CustomerRepository;
import repository.customer.impl.CustomerRepositoryImpl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository = new CustomerRepositoryImpl();

//    @Override
//    public void insertCustomer(Customer customer) throws SQLException {
//        this.customerRepository.insertCustomer(customer);
//    }


    @Override
    public Map<String, String> insertCustomer(Customer customer) throws SQLException {
        Map<String, String> map = new HashMap<>();
        if (customer.getCustomerCode().equals("")) {
            map.put("customerCode", "customerCode không được để trống");
        } else if (!customer.getCustomerCode().matches("^KH-\\d{4}$")) {
            map.put("customerCode", "customerCode không hợp lệ");
        }
        if (customer.getPhone().equals("")) {
            map.put("phone", "phone không được để trống");
        } else if (!customer.getPhone().matches("^((090)|(091)|([(]84[)][+]90)|([(]84[)][+]91))\\d{7}$")) {
            map.put("phone", "phone không hợp lệ");
        }
        if (customer.getIdCard().equals("")) {
            map.put("idCard", "idCard không được để trống");
        } else if (!customer.getIdCard().matches("^(\\d{9})|(\\d{12})$")) {
            map.put("idCard", "idCard không hợp lệ");
        }
        if (customer.getEmail().equals("")) {
            map.put("email", "email không được để trống");
        } else if (!customer.getEmail().matches("^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+.[a-z]{2,6}$")) {
            map.put("email", "email không hợp lệ");
        }

        if (map.isEmpty()) {
            this.customerRepository.insertCustomer(customer);
        }
        return map;
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
    public Map<String, String> update(Customer customer) throws SQLException {
        Map<String, String> map = new HashMap<>();
        if (customer.getCustomerCode().equals("")) {
            map.put("customerCode", "customerCode không được để trống");
        } else if (!customer.getCustomerCode().matches("^KH-\\d{4}$")) {
            map.put("customerCode", "Định dạng mã khách hàng là KH-XXXX, X là số 0-9");
        }
        if (map.isEmpty()) {
            this.customerRepository.update(customer);
        }
        return map;
    }

//    @Override
//    public void update(Customer customer) throws SQLException {
//        this.customerRepository.update(customer);
//    }

    @Override
    public List<Customer> finByName(String name) {
        return this.customerRepository.finByName(name);
    }

    @Override
    public List<Customer> sortByName() {
        return this.customerRepository.sortByName();
    }
}
