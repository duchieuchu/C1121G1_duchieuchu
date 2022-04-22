package repository.service.impl;

import model.service.RentalType;
import model.service.Service;
import model.service.ServiceType;
import repository.BaseRepository;
import repository.service.RentalTypeRepository;
import repository.service.ServiceRepository;
import repository.service.ServiceTypeRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceRepositoryImpl implements ServiceRepository {
    private final BaseRepository baseRepository = new BaseRepository();
    private final RentalTypeRepository rentalTypeRepository = new RentalTypeRepositoryImpl();
    private final ServiceTypeRepository serviceTypeRepository = new ServiceTypeRepositoryImpl();
    private static final String SELECT_ALL_SERVICE = "select * from service";
    private static final String INSERT_SERVICE_SQL = "insert into service (service_name," +
            "service_area,service_cost,service_max_people,rental_type_id,service_type_id,standard_room,description_other_convenience,pool_area,number_of_floors) values (?,?,?,?,?,?,?,?,?,?);";

    @Override
    public void insertService(Service service) throws SQLException {
        try (Connection connection = this.baseRepository.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SERVICE_SQL)) {
           preparedStatement.setString(1,service.getName());
           preparedStatement.setInt(2,service.getArea());
            preparedStatement.setDouble(3,service.getCost());
            preparedStatement.setInt(4,service.getMaxPeople());
            preparedStatement.setInt(5,service.getRentalType().getRentalTypeId());
            preparedStatement.setInt(6,service.getServiceType().getServiceTypeId());
            preparedStatement.setString(7,service.getStandardRoom());
            preparedStatement.setString(8,service.getDescriptionOtherConvenience());
            preparedStatement.setDouble(9,service.getPoolArea());
            preparedStatement.setInt(10,service.getNumberOfFloors());
            preparedStatement.executeUpdate();
        }finally {
            baseRepository.close();
        }
    }

    @Override
    public Service selectService(Integer id) {
        List<Service> serviceList = selectAllService();
        Service service = null;
        for (Service service1 : serviceList) {
            if (service1.getId() == id) {
                service = service1;
            }
        }
        return service;
    }

    @Override
    public List<Service> selectAllService() {
        List<Service> services = new ArrayList<>();
        try (Connection connection = this.baseRepository.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_SERVICE)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Integer id = resultSet.getInt("service_id");
                String name = resultSet.getString("service_name");
                Integer area = resultSet.getInt("service_area");
                Double cost = resultSet.getDouble("service_cost");
                Integer maxPeople = resultSet.getInt("service_max_people");
                RentalType rentalType = rentalTypeRepository.selectRentalType(resultSet.getInt("rental_type_id"));
                ServiceType serviceType = serviceTypeRepository.selectServiceType(resultSet.getInt("service_type_id"));
                String standardRoom = resultSet.getString("standard_room");
                String descriptionOtherConvenience = resultSet.getString("description_other_convenience");
                Double poolArea = resultSet.getDouble("pool_area");
                Integer numberOfFloors = resultSet.getInt("number_of_floors");
                services.add(new Service(id, name, area, cost, maxPeople, rentalType, serviceType, standardRoom, descriptionOtherConvenience, poolArea, numberOfFloors));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            baseRepository.close();
        }
        return services;
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
