package repository.customer.impl;

import model.customer.Customer;
import model.customer.CustomerType;
import repository.BaseRepository;
import repository.customer.CustomerRepository;
import repository.customer.CustomerTypeRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepositoryImpl implements CustomerRepository {
    private final BaseRepository baseRepository = new BaseRepository();
    private final CustomerTypeRepository customerTypeRepository = new CustomerTypeRepositoryImpl();
    private static final String SELECT_ALL_CUSTOMER = "select * from customer";
    private static final String INSERT_CUSTOMERS_SQL = "insert into customer (customer_code,customer_type_id," +
            "customer_name,customer_birthday,customer_gender,customer_id_card,customer_phone,customer_email,customer_address) values (?,?,?,?,?,?,?,?,?);";
    private static final String UPDATE_CUSTOMER_SQL = "update customer set customer_type_id =?,customer_name=?,customer_birthday=?," +
            "customer_gender=?,customer_id_card=?,customer_phone=?,customer_email=?,customer_address=? where customer_id=?;";
    private static final String DELETE_CUSTOMER_SQL = "delete from customer where customer_id=?;";
//    private static final String SELECT_CUSTOMER_BY_NAME = "select * from customer where customer_name like?;";
    private static final String SELECT_CUSTOMER_BY_NAME ="select customer_id,customer_type_id,customer_name,customer_birthday,customer_gender,customer_id_card,customer_phone,customer_email,customer_address from customer  where customer_name like?;";

    @Override
    public void insertCustomer(Customer customer) throws SQLException {
        try (Connection connection = this.baseRepository.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CUSTOMERS_SQL)) {
           preparedStatement.setString(1,customer.getCustomerCode());
            preparedStatement.setInt(2, customer.getCustomerType().getCustomerTypeId());
            preparedStatement.setString(3, customer.getName());
            preparedStatement.setString(4, customer.getBirthday());
            preparedStatement.setInt(5, customer.getGender());
            preparedStatement.setString(6, customer.getIdCard());
            preparedStatement.setString(7, customer.getPhone());
            preparedStatement.setString(8, customer.getEmail());
            preparedStatement.setString(9, customer.getAddress());
            preparedStatement.executeUpdate();
        } finally {
            baseRepository.close();
        }
    }

    @Override
    public Customer selectCustomer(Integer id) {
        List<Customer> customerList = selectAllCustomer();
        Customer customer = null;
        for (Customer customer1 : customerList) {
            if (customer1.getId() == id) {
                customer = customer1;
            }
        }
        return customer;
    }

    @Override
    public List<Customer> selectAllCustomer() {
        List<Customer> customers = new ArrayList<>();
        try (Connection connection = this.baseRepository.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CUSTOMER)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Integer id = resultSet.getInt("customer_id");
                String customerCode=resultSet.getString("customer_code");
                CustomerType customerType = customerTypeRepository.selectCustomerType(resultSet.getInt("customer_type_id"));
                String name = resultSet.getString("customer_name");
                String birthday = resultSet.getString("customer_birthday");
                Integer gender = resultSet.getInt("customer_gender");
                String idCard = resultSet.getString("customer_id_card");
                String phone = resultSet.getString("customer_phone");
                String email = resultSet.getString("customer_email");
                String address = resultSet.getString("customer_address");
                customers.add(new Customer(id, customerCode,customerType, name, birthday, gender, idCard, phone, email, address));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            baseRepository.close();
        }
        return customers;
    }

    @Override
    public void deleteCustomer(Integer id) throws SQLException {
        try (Connection connection = this.baseRepository.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CUSTOMER_SQL)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } finally {
            baseRepository.close();
        }
    }

    @Override
    public void update(Customer customer) throws SQLException {
        try (Connection connection = this.baseRepository.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CUSTOMER_SQL)) {
            preparedStatement.setInt(1, customer.getCustomerType().getCustomerTypeId());
            preparedStatement.setString(2, customer.getName());
            preparedStatement.setString(3, customer.getBirthday());
            preparedStatement.setInt(4, customer.getGender());
            preparedStatement.setString(5, customer.getIdCard());
            preparedStatement.setString(6, customer.getPhone());
            preparedStatement.setString(7, customer.getEmail());
            preparedStatement.setString(8, customer.getAddress());
            preparedStatement.setInt(9, customer.getId());
            preparedStatement.executeUpdate();
        } finally {
            baseRepository.close();
        }
    }

    @Override
    public List<Customer> finByName(String name) {
        List<Customer> customerList = new ArrayList<>();
        Connection connection = this.baseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CUSTOMER_BY_NAME);
            preparedStatement.setString(1, "%" + name + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Integer id = resultSet.getInt("customer_id");
                String customerCode = resultSet.getString("customer_code");
                CustomerType customerType = customerTypeRepository.selectCustomerType(resultSet.getInt("customer_type_id"));
                String name1 = resultSet.getString("customer_name");
                String birthday = resultSet.getString("customer_birthday");
                Integer gender = resultSet.getInt("customer_gender");
                String idCard = resultSet.getString("customer_id_card");
                String phone = resultSet.getString("customer_phone");
                String email = resultSet.getString("customer_email");
                String address = resultSet.getString("customer_address");
                customerList.add(new Customer(id,customerCode, customerType, name1, birthday, gender, idCard, phone, email, address));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            baseRepository.close();
        }
        return customerList;
    }

    @Override
    public List<Customer> sortByName() {
        return null;
    }
}
