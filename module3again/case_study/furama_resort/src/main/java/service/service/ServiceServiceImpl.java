package service.service;

import model.service.Service;
import repository.service.ServiceRepository;
import repository.service.impl.ServiceRepositoryImpl;

import java.sql.SQLException;
import java.util.List;

public class ServiceServiceImpl implements ServiceService{
    private final ServiceRepository serviceRepository =new ServiceRepositoryImpl();
    @Override
    public void insertService(Service service) throws SQLException {
        this.serviceRepository.insertService(service);
    }

    @Override
    public Service selectService(Integer id) {
        return this.serviceRepository.selectService(id);
    }

    @Override
    public List<Service> selectAllService() {
        return this.serviceRepository.selectAllService();
    }

    @Override
    public void deleteService(Integer id) throws SQLException {

    }

    @Override
    public void update(Service service) throws SQLException {

    }

    @Override
    public List<Service> finByName(String name) {
        return null;
    }

    @Override
    public List<Service> sortByName() {
        return null;
    }
}
