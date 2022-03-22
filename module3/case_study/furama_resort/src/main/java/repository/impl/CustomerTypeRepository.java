package repository.impl;

import model.customer.CustomerType;
import repository.ICustomerTypeRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerTypeRepository implements ICustomerTypeRepository {
    private static final String SELECT_CUSTOMER_TYPE = "select * from customer_type";
private static final String SELECT_CUSTOMER_TYPE_BY_ID="select customer_type_id,customer_type_name from customer_type where customer_type_id=?;";

    private String jdbcURL = "jdbc:mysql://localhost:3306/furama_resort1?allowPublicKeyRetrieval=true&useSSL=FALSE";
    private String jdbcUserName = "root";
    private String jdbcPassword = "codegym19";

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
    public List<CustomerType> selectAllCustomerType() {
        List<CustomerType> customerTypes = new ArrayList<>();
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CUSTOMER_TYPE)) {
            System.out.println(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int customerTypeId = resultSet.getInt("customer_type_id");
                String customerTypeName = resultSet.getString("customer_type_name");
                customerTypes.add(new CustomerType(customerTypeId, customerTypeName));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customerTypes;

    }

    @Override
    public CustomerType selectCustomerType(int customerTypeId) {
        CustomerType customerType = null;
        try(Connection connection= getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CUSTOMER_TYPE_BY_ID)){
            preparedStatement.setInt(1,customerTypeId);
            System.out.println(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String customerTypeName =resultSet.getString("customer_type_name");
                customerType = new CustomerType(customerTypeId,customerTypeName);
            }
        }catch (SQLException e){
         e.printStackTrace();
        }
        return customerType;
    }

}
