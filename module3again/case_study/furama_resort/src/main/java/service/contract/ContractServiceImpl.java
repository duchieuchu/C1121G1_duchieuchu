package service.contract;

import model.contract.Contract;
import repository.contract.ContractRepository;
import repository.contract.ContractRepositoryImpl;

import java.sql.SQLException;
import java.util.List;

public class ContractServiceImpl implements ContractService {
    private final ContractRepository contractRepository = new ContractRepositoryImpl();

    @Override
    public void insertContract(Contract contract) throws SQLException {
        this.contractRepository.insertContract(contract);
    }

    @Override
    public List<Contract> selectAllContract() {
        return this.contractRepository.selectAllContract();
    }
}
