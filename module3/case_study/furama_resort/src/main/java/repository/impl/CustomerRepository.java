package repository.impl;

import model.customer.Customer;
import model.customer.CustomerType;
import repository.customer.ICustomerRepository;
import repository.customer.ICustomerTypeRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepository implements ICustomerRepository {
    private final ICustomerTypeRepository customerTypeRepository = new CustomerTypeRepository();
    private String jdbcURL = "jdbc:mysql://localhost:3306/furama_resort1?allowPublicKeyRetrieval=true&useSSL=FALSE";
    private String jdbcUserName = "root";
    private String jdbcPassword = "codegym19";

    private static final String DELETE_CUSTOMER_SQL = "delete from customer where customer_id=?;";
    private static final String SELECT_CUSTOMER_BY_ID = "select customer_id,customer_type_id,customer_name,customer_birthday,customer_gender," +
            "customer_id_card,customer_phone,customer_email,customer_address from customer where customer_id =?";
    private static final String UPDATE_CUSTOMER_SQL = "update customer set customer_type_id =?,customer_name=?,customer_birthday=?," +
            "customer_gender=?,customer_id_card=?,customer_phone=?,customer_email=?,customer_address=? where customer_id=?;";
    private static final String INSERT_CUSTOMERS_SQL = "insert into customer" + " (customer_id,customer_type_id," +
            "customer_name,customer_birthday,customer_gender,customer_id_card,customer_phone,customer_email,customer_address) values " + " (?, ?, ?,?, ?, ?,?, ?, ?);";
    private static final String SELECT_ALL_CUSTOMERS = "select * from customer";


    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("SQLState: " + (((SQLException) e).getErrorCode()));
                System.err.println("Message: " + e.getMessage());
                Throwable throwable = ex.getCause();
                while (throwable != null) {
                    System.out.println("Cause" + throwable);
                    throwable = throwable.getCause();
                }
            }
        }
    }

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUserName, jdbcPassword);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    @Override
    public List<Customer> selectAllCustomers() {
        List<Customer> customers = new ArrayList<>();
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CUSTOMERS)) {
            System.out.println(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("customer_id");
                CustomerType customerType = customerTypeRepository.selectCustomerType(resultSet.getInt("customer_type_id"));
                String name = resultSet.getString("customer_name");
                String birthday = resultSet.getString("customer_birthday");
                int gender = resultSet.getInt("customer_gender");
                String idCard = resultSet.getString("customer_id_card");
                String phone = resultSet.getString("customer_phone");
                String email = resultSet.getString("customer_email");
                String address = resultSet.getString("customer_address");
                customers.add(new Customer(id, customerType, name, birthday, gender, idCard, phone, email, address));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return customers;
    }

    @Override
    public Customer selectCustomer(int id) {
        Customer customer = null;
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CUSTOMER_BY_ID)) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                CustomerType customerType =customerTypeRepository.selectCustomerType(resultSet.getInt("customer_type_id")) ;
                String name = resultSet.getString("customer_name");
                String birthday = resultSet.getString("customer_birthday");
                int gender = resultSet.getInt("customer_gender");
                String idCard = resultSet.getString("customer_id_card");
                String phone = resultSet.getString("customer_phone");
                String email = resultSet.getString("customer_email");
                String address = resultSet.getString("customer_address");
                customer = new Customer(id, customerType, name, birthday, gender, idCard, phone, email, address);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return customer;
    }

    @Override
    public void insertCustomer(Customer customer) {
        System.out.println(INSERT_CUSTOMERS_SQL);
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CUSTOMERS_SQL)) {
            preparedStatement.setInt(1, customer.getId());
            preparedStatement.setInt(2, customer.getCustomerType().getCustomerTypeId());
            preparedStatement.setString(3, customer.getName());
            preparedStatement.setString(4, customer.getBirthday());
            preparedStatement.setInt(5, customer.getGender());
            preparedStatement.setString(6, customer.getIdCard());
            preparedStatement.setString(7, customer.getPhone());
            preparedStatement.setString(8, customer.getEmail());
            preparedStatement.setString(9, customer.getAddress());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    @Override
    public boolean deleteCustomer(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_CUSTOMER_SQL)) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    @Override
    public void updateCustomer(Customer customer) throws SQLException {
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CUSTOMER_SQL)) {
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
        }
    }

    @Override
    public List<Customer> searchCustomer(String customerName, String customerTypeName) {
        return null;
    }
}
