package repository.customer.impl;

import model.customer.CustomerType;
import repository.BaseRepository;
import repository.customer.CustomerTypeRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerTypeRepositoryImpl implements CustomerTypeRepository {
    private final BaseRepository baseRepository = new BaseRepository();
    private static final String SELECT_CUSTOMER_TYPE = "select * from customer_type";
    private static final String SELECT_CUSTOMER_TYPE_BY_ID = "select customer_type_name from customer_type where customer_type_id=?;";

    @Override
    public List<CustomerType> selectAllCustomerType() {
        List<CustomerType> customerTypes = new ArrayList<>();
        try (Connection connection = this.baseRepository.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CUSTOMER_TYPE)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Integer customerTypeId = resultSet.getInt("customer_type_id");
                String customerTypeName = resultSet.getString("customer_type_name");
                customerTypes.add(new CustomerType(customerTypeId, customerTypeName));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            baseRepository.close();
        }
        return customerTypes;
    }

    @Override
    public CustomerType selectCustomerType(Integer customerTypeId) {
        CustomerType customerType = null;
        try (Connection connection = this.baseRepository.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CUSTOMER_TYPE_BY_ID)) {
            preparedStatement.setInt(1, customerTypeId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String customerTypeName = resultSet.getString("customer_type_name");
                customerType = new CustomerType(customerTypeId, customerTypeName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            baseRepository.close();
        }
        return customerType;
    }
}
