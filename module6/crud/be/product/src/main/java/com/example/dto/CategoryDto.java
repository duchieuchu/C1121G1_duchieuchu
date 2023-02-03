package com.example.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class CategoryDto {
    private Integer id;
    private String name;
    private Boolean isDeleted;

}
