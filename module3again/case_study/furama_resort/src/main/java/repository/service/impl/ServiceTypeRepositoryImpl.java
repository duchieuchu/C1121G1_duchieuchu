package repository.service.impl;

import model.service.ServiceType;
import repository.BaseRepository;
import repository.service.ServiceTypeRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceTypeRepositoryImpl implements ServiceTypeRepository {
    private final BaseRepository baseRepository = new BaseRepository();
    private static final String SELECT_SERVICE_TYPE = "select * from service_type";
    private static final String SELECT_SERVICE_TYPE_BY_ID = "select service_type_name from service_type where service_type_id=?;";

    @Override
    public List<ServiceType> selectAllServiceType() {
        List<ServiceType> serviceTypes = new ArrayList<>();
        try (Connection connection = this.baseRepository.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SELECT_SERVICE_TYPE)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Integer serviceTypeId = resultSet.getInt("service_type_id");
                String serviceTypeName = resultSet.getString("service_type_name");
                serviceTypes.add(new ServiceType(serviceTypeId, serviceTypeName));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            baseRepository.close();
        }
        return serviceTypes;
    }

    @Override
    public ServiceType selectServiceType(Integer serviceTypeId) {
        ServiceType serviceType = null;
        try (Connection connection = this.baseRepository.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SELECT_SERVICE_TYPE_BY_ID)) {
            preparedStatement.setInt(1,serviceTypeId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String serviceTypeName = resultSet.getString("service_type_name");
                serviceType =new ServiceType(serviceTypeId,serviceTypeName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            baseRepository.close();
        }
        return serviceType;
    }
}
