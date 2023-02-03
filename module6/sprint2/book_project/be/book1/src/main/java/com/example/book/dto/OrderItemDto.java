package com.example.book.dto;

import com.example.book.models.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemDto {
    private Integer id;
    private String orderDay;
    private Boolean isDeleted;
    private User user;
    private List<OrderDetailsDto> orderDetailsList;
}
