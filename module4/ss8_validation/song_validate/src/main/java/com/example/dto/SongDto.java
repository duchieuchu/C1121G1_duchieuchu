package com.example.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class SongDto implements Validator {

    private Integer id;
    @NotBlank(message = "name không được có khoảng trắng")
    @NotNull(message = "name không được để null")
    @NotEmpty(message = "name không được để trống")
    @Size(max = 800, message = " name Không vượt quá 800 ký tự")
    private String name;

    @NotBlank(message = "singer không được có khoảng trắng")
    @NotNull(message = "singer không được để null")
    @NotEmpty(message = "singer không được để trống")
    @Size(max = 300, message = "singer Không vượt quá 300 ký tự")
    private String singer;

    @NotBlank(message = "kindOfMusic không được có khoảng trắng")
    @NotNull(message = "kindOfMusic không được để null")
    @NotEmpty(message = "kindOfMusic không được để trống")
    @Size(max = 1000, message = "kindOfMusic Không vượt quá 1000 ký tự")
    private String kindOfMusic;

    @NotBlank(message = "filePath không được có khoảng trắng")
    @NotNull(message = "filePath không được để null")
    @NotEmpty(message = "filePath không được để trống")
    private String filePath;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getKindOfMusic() {
        return kindOfMusic;
    }

    public void setKindOfMusic(String kindOfMusic) {
        this.kindOfMusic = kindOfMusic;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        SongDto songDto =(SongDto) target;
        if (!songDto.name.matches("^[a-zA-Z0-9\\+]*$")){
            errors.rejectValue("name","name.inValid","name nhập không hợp lệ");
        }
        if (!songDto.singer.matches("^[a-zA-Z0-9\\+]*$")){
            errors.rejectValue("singer","singer.inValid","singer nhập không hợp lệ");
        }
        if (!songDto.kindOfMusic.matches("^[a-zA-Z0-9(,)\\+]*$")){
            errors.rejectValue("kindOfMusic","kindOfMusic.inValid","kindOfMusic nhập không hợp lệ");
        }
    }
}
