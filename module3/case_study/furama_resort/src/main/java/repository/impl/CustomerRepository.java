package repository.impl;

import model.customer.Customer;
import repository.ICustomerRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepository implements ICustomerRepository {
    private String jdbcURL = "jdbc:mysql://localhost:3306/furama_resort1?allowPublicKeyRetrieval=true&useSSL=FALSE";
    private String jdbcUserName = "root";
    private String jdbcPassword = "codegym19";

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
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
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
                int id = resultSet.getInt("id");
                int customerType = resultSet.getInt("customerType");
                String name = resultSet.getString("name");
                String birthday = resultSet.getString("birthday");
                String gender = resultSet.getString("gender");
                String idCard = resultSet.getString("idCard");
                String phone = resultSet.getString("phone");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                customers.add(new Customer(id,customerType,name,birthday,gender,idCard,phone,email,address));
            }
        }catch (SQLException e){
            printSQLException(e);
        }
        return customers;
    }

    @Override
    public Customer selectCustomer(int id) {
        return null;
    }

    @Override
    public void insertCustomer(Customer customer) throws SQLException {

    }

    @Override
    public boolean deleteCustomer(int id) throws SQLException {
        return false;
    }

    @Override
    public boolean updateCustomer(Customer customer) throws SQLException {
        return false;
    }

    @Override
    public List<Customer> searchCustomer(String customerName, String customerTypeName) {
        return null;
    }
}
