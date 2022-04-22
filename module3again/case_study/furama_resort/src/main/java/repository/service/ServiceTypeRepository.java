package repository.service;


import model.service.ServiceType;

import java.util.List;

public interface ServiceTypeRepository {
    List<ServiceType>selectAllServiceType();
    ServiceType selectServiceType (Integer serviceTypeId);
}
