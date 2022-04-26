package service.employee;

import model.employee.Employee;
import repository.employee.EmployeeRepository;
import repository.employee.impl.EmployeeRepositoryImpl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository = new EmployeeRepositoryImpl();
//    @Override
//    public void insertEmployee(Employee employee) throws SQLException {
//        this.employeeRepository.insertEmployee(employee);
//    }

    @Override
    public Map<String, String> insertEmployee(Employee employee) throws SQLException {
        Map<String,String>map = new HashMap<>();
        if (employee.getPhone().equals("")){
            map.put("phone","phone không được để trống");
        }else if (!employee.getPhone().matches("^((090)|(091)|([(]84[)][+]90)|([(]84[)][+]91))\\d{7}$")) {
            map.put("phone","phone không hợp lệ");
        }
        if (employee.getIdCard().equals("")){
            map.put("idCard","idCard không được để trống");
        }else if (!employee.getIdCard().matches("^(\\d{9})|(\\d{12})$")) {
            map.put("idCard","idCard không hợp lệ");
        }
        if (employee.getEmail().equals("")){
            map.put("email","email không được để trống");
        }else if (!employee.getEmail().matches("^[\\w#][\\w\\.\\'+#](.[\\w\\\\'#]+)\\@[a-zA-Z0-9]+(.[a-zA-Z0-9]+)*(.[a-zA-Z]{2,20})$")) {
            map.put("email","email không hợp lệ");
        }

        if (map.isEmpty()){
            this.employeeRepository.insertEmployee(employee);
        }
        return map;
    }

    @Override
    public Employee selectEmployee(Integer id) {
        return this.employeeRepository.selectEmployee(id);
    }

    @Override
    public List<Employee> selectAllEmployee() {
        return this.employeeRepository.selectAllEmployee();
    }

    @Override
    public void deleteEmployee(Integer id) throws SQLException {
        this.employeeRepository.deleteEmployee(id);
    }

    @Override
    public Map<String, String> update(Employee employee) throws SQLException {
        return null;
    }

//    @Override
//    public void update(Employee employee) throws SQLException {
//        this.employeeRepository.update(employee);
//    }

    @Override
    public List<Employee> finByName(String name) {
        return this.employeeRepository.finByName(name);
    }

    @Override
    public List<Employee> sortByName() {
        return this.employeeRepository.sortByName();
    }
}
