package com.example.dto;

import com.example.annotation.Author;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class SongDto implements Validator {
    private Integer id;
    @NotNull
    @NotBlank
    @NotEmpty
    @Size(max = 800, message = " name Không vượt quá 800 ký tự")
    @Author
    private String name;

    @NotNull
    @NotBlank
    @NotEmpty
    @Size(max = 300, message = "singer Không vượt quá 300 ký tự")
    private String singer;

    @NotNull
    @NotBlank
    @NotEmpty
    @Size(max = 1000, message = "kindOfMusic Không vượt quá 1000 ký tự")
    private String typeOfMusic;

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

    public String getTypeOfMusic() {
        return typeOfMusic;
    }

    public void setTypeOfMusic(String typeOfMusic) {
        this.typeOfMusic = typeOfMusic;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        SongDto songDto=(SongDto) target;
        if (songDto.name.matches("^[&%$##@!~]")){
            errors.rejectValue("name","name.inValid","name nhập không hợp lệ");
        }
        if (songDto.singer.matches("^[&%$##@!~]")){
            errors.rejectValue("singer","singer.inValid","singer nhập không hợp lệ");
        }
        if (songDto.typeOfMusic.matches("^[&%$##@!~]")){
            errors.rejectValue("kindOfMusic","kindOfMusic.inValid","kindOfMusic nhập không hợp lệ");
        }
    }
}
