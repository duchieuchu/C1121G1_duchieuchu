package repository.contract;

import model.contract.Contract;

import java.sql.SQLException;
import java.util.List;

public interface ContractRepository {
    void insertContract(Contract contract) throws SQLException;

    List<Contract> selectAllContract();
}
