package com.example.dto;

import com.example.model.contract.AttachService;
import com.example.model.contract.Contract;
import com.example.model.contract.ContractDetail;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class ContractDetailDto implements Validator {
    private Integer id;


    private Contract contract;


    private AttachService attachService;

    private String quantity;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public AttachService getAttachService() {
        return attachService;
    }

    public void setAttachService(AttachService attachService) {
        this.attachService = attachService;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        ContractDetailDto contractDetailDto = (ContractDetailDto) target;
        if ((!contractDetailDto.quantity.matches("^[1-9]+[0-9]*$"))) {
            errors.rejectValue("quantity","quantity.inValid","quantity nhập không hợp lệ");
        }
    }
}
