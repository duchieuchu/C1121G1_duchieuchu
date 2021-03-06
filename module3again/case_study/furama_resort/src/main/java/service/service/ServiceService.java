package service.service;

import model.customer.Customer;
import model.service.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface ServiceService {
    Map<String, String> insertService(Service service) throws SQLException;

//    void insertService(Service service) throws SQLException;

    Service selectService(Integer id);

    List<Service> selectAllService();

    void deleteService(Integer id) throws SQLException;

    Map<String, String> update(Service service) throws SQLException;
//    void update(Service service) throws SQLException;

    List<Service> finByName(String name);

    List<Service> sortByName();
}
