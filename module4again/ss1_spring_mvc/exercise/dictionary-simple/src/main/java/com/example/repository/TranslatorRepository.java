package com.example.repository;

import org.springframework.stereotype.Repository;

@Repository
public class TranslatorRepository implements ITranslatorRepository {

    @Override
    public String translate(String english) {
        switch (english) {
            case "one":
                english = "một";
                break;
            case "two":
                english = "hai";
                break;
            case "three":
                english = "ba";
                break;
            case "four":
                english = "bốn";
                break;
            case "five":
                english = "năm";
                break;
            case "six":
                english = "sáu";
                break;
            case "seven":
                english = "bảy";
                break;
            default:
                english ="không tìm thấy";
        }
        return english;
    }
}
