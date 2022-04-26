package service.contract;

import model.contract.Contract;

import java.sql.SQLException;
import java.util.List;

public interface ContractService {
    void insertContract(Contract contract) throws SQLException;

    List<Contract> selectAllContract();
}
