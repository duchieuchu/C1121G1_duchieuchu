package repository.contract;

import model.contract.Contract;
import model.customer.Customer;
import model.employee.Employee;
import model.service.Service;
import repository.BaseRepository;
import service.customer.CustomerService;
import service.customer.CustomerServiceImpl;
import service.employee.EmployeeService;
import service.employee.EmployeeServiceImpl;
import service.service.ServiceService;
import service.service.ServiceServiceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContractRepositoryImpl implements ContractRepository {
    private final BaseRepository baseRepository = new BaseRepository();
    private final EmployeeService employeeService = new EmployeeServiceImpl();
    private final CustomerService customerService = new CustomerServiceImpl();
    private final ServiceService serviceService = new ServiceServiceImpl();
    private static final String SELECT_ALL_CONTRACT = "select * from contract";
    private static final String INSERT_CONTRACT_SQL = "insert into contract (contract_start_date,contract_end_date," +
            "contract_deposit,contract_total_money,employee_id,customer_id,service_id) values (?,?,?,?,?,?,?);";

    @Override
    public void insertContract(Contract contract) throws SQLException {
        try (Connection connection = this.baseRepository.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CONTRACT_SQL)) {
            preparedStatement.setString(1, contract.getStartDate());
            preparedStatement.setString(2, contract.getEndDate());
            preparedStatement.setDouble(3, contract.getDeposit());
            preparedStatement.setDouble(4, contract.getTotalMoney());
            preparedStatement.setInt(5, contract.getEmployee().getId());
            preparedStatement.setInt(6,contract.getCustomer().getId() );
            preparedStatement.setInt(7,contract.getService().getId() );
            preparedStatement.executeUpdate();
        }finally {
            baseRepository.close();
        }
    }

    @Override
    public List<Contract> selectAllContract() {
        List<Contract> contracts = new ArrayList<>();
        try (Connection connection = this.baseRepository.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CONTRACT)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Integer id = resultSet.getInt("contract_id");
                String startDate = resultSet.getString("contract_start_date");
                String endDate = resultSet.getString("contract_end_date");
                Double deposit = resultSet.getDouble("contract_deposit");
                Double totalMoney = resultSet.getDouble("contract_total_money");
                Employee employee = employeeService.selectEmployee(resultSet.getInt("employee_id"));
                Customer customer = customerService.selectCustomer(resultSet.getInt("customer_id"));
                Service service = serviceService.selectService(resultSet.getInt("service_id"));
                contracts.add(new Contract(id, startDate, endDate, deposit, totalMoney, employee, customer, service));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            baseRepository.close();
        }
        return contracts;
    }
}
