package com.coffee.dto;


import com.coffee.model.account.AppUser;
import com.coffee.model.employee.Employee;
import com.coffee.model.employee.Position;
import lombok.Data;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.*;
import java.sql.Date;
import java.util.List;

@Data
public class EmployeeDTOCreate implements Validator {
    private Integer id;

    @NotBlank(message = "vui lòng điền thông tin.")
    @Size(min = 6,max = 30,message = "Vui lòng nhập name lớn hơn 6 nhỏ hơn 30 kí tự.")
    @Pattern(regexp = "^([A-Z][^A-Z0-9\\s]+)(\\s[A-Z][^A-Z0-9\\s]+)*$", message = "Vui lòng nhập chữ cái đầu In Hoa mỗi từ ")
    private String name;

    @NotBlank(message = "vui lòng điền thông tin.")
    @Size(max = 255,message = "Vui lòng nhập hình ảnh nhỏ hơn 255 kí tự")
    private String image;

    @NotBlank(message = "vui lòng điền thông tin.")
    @Pattern(regexp = "^(09|\\(84\\)\\+9)[01]\\d{7}$", message = "Vui lòng nhập 10 số vs đầu số dạng 090, 091 , (84)+90 , (84)+91")
    private String phoneNumber;

    @NotBlank(message = "vui lòng điền thông tin.")
    @Size(min = 6,max = 255,message = "Vui lòng nhập địa chỉ lớn hơn 6 nhỏ hơn 255 kí tự.")
    private String address;

    @NotBlank(message = "vui lòng điền thông tin.")
    @Email(message = "vui lòng nhập đúng định dạng email.")
    private String email;

    private int gender;

    @PastOrPresent(message = "vui lòng không nhập quá ngày hiện tại.")
    private Date birthday;

    @PositiveOrZero(message = "vui lòng nhập lương lớn hơn 0 .")
    @Max(value = 100000000)
    private Double salary;

    private Integer isDeleted;

    private Position position;

    private AppUser appUser;

    private List<Employee> employeeList;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        EmployeeDTOCreate employeeDTOCreate = (EmployeeDTOCreate) target;
        List<Employee> employeeList = this.getEmployeeList();

        if (!employeeList.isEmpty()) {
            for (Employee employee: employeeList) {
                if (employee.getAppUser().getUserName().equals(employeeDTOCreate.getAppUser().getUserName())) {
                    errors.rejectValue("appUser", "", "userNameExists");
                    break;
                }
                if (employee.getPhoneNumber().equals(employeeDTOCreate.getPhoneNumber())) {
                    errors.rejectValue("phoneNumber", "", "phoneNumberExists");
                    break;
                }
            }
        }
        if (employeeDTOCreate.getSalary() % 100000 != 0) {
            errors.rejectValue("salary", "create.salary", "salary%100000");
        }
    }


}
