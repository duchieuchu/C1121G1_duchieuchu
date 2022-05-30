package com.example.repository.customer;

import com.example.dto.ICustomerUseService;
import com.example.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
    Page<Customer> findAllByNameContaining(String name, Pageable pageable);

    @Query(value = "select * from customer where name like :name or address like :name or code like :name", nativeQuery = true)
    Page<Customer> searchAll(@Param("name") String name, Pageable pageable);

    Page<Customer> findAllByNameContainingOrAddressContainingOrCodeContaining(String name, String address, String code, Pageable pageable);

    @Query(value = "\n" +
            "select customer.`name` as `name`,customer.`code` as `code`,customer.phone as `phone`,contract.id as`contractId`" +
            ",contract_detail.id as`contractDetailId`,attach_service.`name` as `attachServiceName`," +
            "(service.cost+contract_detail.quantity*attach_service.cost) \n" +
            "as totalMoney " +
            "from contract \n" +
            "left join customer on contract.customer_id=customer.id\n" +
            "left join service on contract.service_id=service.id\n" +
            "left join contract_detail on contract.id=contract_detail.contract_id\n" +
            "left join attach_service on attach_service.id=contract_detail.attach_service_id\n" +
            "group by contract_id",
            countQuery = "\n" +
                    "select customer.`name` as `name`,customer.`code` as `code`,customer.phone as `phone`,contract.id as`contractId`" +
                    ",contract_detail.id as`contractDetailId`,attach_service.`name` as `attachServiceName`," +
                    "(service.cost+contract_detail.quantity*attach_service.cost) \n" +
                    "as totalMoney " +
                    "from contract \n" +
                    "left join customer on contract.customer_id=customer.id\n" +
                    "left join service on contract.service_id=service.id\n" +
                    "left join contract_detail on contract.id=contract_detail.contract_id\n" +
                    "left join attach_service on attach_service.id=contract_detail.attach_service_id\n" +
                    "group by contract_id"
            , nativeQuery = true)
    Page<ICustomerUseService> findAllCustomerUserService(Pageable pageable);
}
