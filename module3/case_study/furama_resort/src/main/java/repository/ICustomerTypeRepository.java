package repository;

import model.customer.CustomerType;

import java.util.List;

public interface ICustomerTypeRepository {
    List<CustomerType> selectAllCustomerType();

    CustomerType selectCustomerType(int customerTypeId);
}
