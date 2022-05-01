package com.codegym.service;

import org.springframework.stereotype.Service;

@Service
public class TranslateServiceImpl implements TranslateService{
    @Override
    public String translate(String vnm) {
        String english;
        switch (vnm) {
            case "1":
                english = "one";
                break;
            case "2":
                english = "two";
                break;
            case "ba":
                english = "three";
                break;
            case "4":
                english = "four";
                break;
            case "5":
                english = "five";
                break;
            case "6":
                english = "six";
                break;
            case "7":
                english = "seven";
                break;
            default:
                english = "i dont know";
        }return english;
    }
}
