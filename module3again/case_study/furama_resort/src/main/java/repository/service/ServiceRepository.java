package repository.service;

import model.service.Service;

import java.sql.SQLException;
import java.util.List;

public interface ServiceRepository {
    void insertService(Service service) throws SQLException;

    Service selectService(Integer id);

    List<Service> selectAllService();

    void deleteService(Integer id) throws SQLException;

    void update(Service service) throws SQLException;

    List<Service> finByName(String name);

    List<Service> sortByName();
}
