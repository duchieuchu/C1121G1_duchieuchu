package repository.service;


import model.service.RentalType;

import java.util.List;

public interface RentalTypeRepository {
    List<RentalType>selectAllRentalType();
    RentalType selectRentalType (Integer rentalTypeId);
}
