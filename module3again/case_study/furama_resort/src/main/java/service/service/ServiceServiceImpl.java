package service.service;

import model.service.Service;
import repository.service.ServiceRepository;
import repository.service.impl.ServiceRepositoryImpl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ServiceServiceImpl implements ServiceService{
    private final ServiceRepository serviceRepository =new ServiceRepositoryImpl();
//    @Override
//    public void insertService(Service service) throws SQLException {
//        this.serviceRepository.insertService(service);
//    }

    @Override
    public Map<String, String> insertService(Service service) throws SQLException {
        Map<String,String> map = new HashMap<>();
        if (service.getServiceCode().equals("")){
            map.put("serviceCode","serviceCode không được để trống");
        }else if (!service.getServiceCode().matches("^DV-\\d{4}$")){
            map.put("serviceCode","serviceCode không hợp lệ");
        }
        if (service.getMaxPeople().equals("")){
            map.put("maxPeople","maxPeople không được để trống");
        }else if (!service.getMaxPeople().toString().matches("^[1-9]+[0-9]*$")){
            map.put("maxPeople","maxeople không hợp lệ");
        }
        if (service.getArea().equals("")){
            map.put("area","area không được để trống");
        }else if (!service.getArea().toString().matches("^[1-9]+[0-9]*$")){
            map.put("area","area không hợp lệ");
        }
        if (service.getPoolArea().equals("")){
            map.put("poolArea","poolArea không được để trống");
        }else if (!service.getArea().toString().matches("^[1-9]+[0-9]*$")){
            map.put("poolArea","poolArea không hợp lệ");
        }
        if (service.getNumberOfFloors().equals("")){
            map.put("numberOfFloors","numberOfFloors không được để trống");
        }else if (!service.getMaxPeople().toString().matches("^[1-9]+[0-9]*$")){
            map.put("numberOfFloors","numberOfFloors không hợp lệ");
        }

        if (map.isEmpty()){
            this.serviceRepository.insertService(service);
        }
        return map;
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
    public Map<String, String> update(Service service) throws SQLException {
        return null;
    }

//    @Override
//    public void update(Service service) throws SQLException {
//
//    }

    @Override
    public List<Service> finByName(String name) {
        return null;
    }

    @Override
    public List<Service> sortByName() {
        return null;
    }
}
