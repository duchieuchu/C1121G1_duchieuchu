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
    private static final String INSERT_CUSTOMERS_SQL = "insert into customer (customer_type_id," +
            "customer_name,customer_birthday,customer_gender,customer_id_card,customer_phone,customer_email,customer_address) values (?,?,?,?,?,?,?,?);";

    @Override
    public void insertCustomer(Customer customer) throws SQLException {
        try (Connection connection = this.baseRepository.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CUSTOMERS_SQL)) {
          preparedStatement.setInt(1,customer.getCustomerType().getCustomerTypeId());
          preparedStatement.setString(2,customer.getName());
            preparedStatement.setString(3,customer.getBirthday());
            preparedStatement.setInt(4,customer.getGender());
            preparedStatement.setString(5,customer.getIdCard());
            preparedStatement.setString(6,customer.getPhone());
            preparedStatement.setString(7,customer.getEmail());
            preparedStatement.setString(8,customer.getAddress());
            preparedStatement.executeUpdate();
        }finally {
            baseRepository.close();
        }
    }

    @Override
    public Customer selectCustomer(Integer id) {
        return null;
    }

    @Override
    public List<Customer> selectAllCustomer() {
        List<Customer> customers = new ArrayList<>();
        try (Connection connection = this.baseRepository.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CUSTOMER)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Integer id = resultSet.getInt("customer_id");
                CustomerType customerType = customerTypeRepository.selectCustomerType(resultSet.getInt("customer_type_id"));
                String name = resultSet.getString("customer_name");
                String birthday = resultSet.getString("customer_birthday");
                Integer gender = resultSet.getInt("customer_gender");
                String idCard = resultSet.getString("customer_id_card");
                String phone = resultSet.getString("customer_phone");
                String email = resultSet.getString("customer_email");
                String address = resultSet.getString("customer_address");
                customers.add(new Customer(id, customerType, name, birthday, gender, idCard, phone, email, address));
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

    }

    @Override
    public void update(Customer customer) throws SQLException {

    }

    @Override
    public List<Customer> finByName(String name) {
        return null;
    }

    @Override
    public List<Customer> sortByName() {
        return null;
    }
}
