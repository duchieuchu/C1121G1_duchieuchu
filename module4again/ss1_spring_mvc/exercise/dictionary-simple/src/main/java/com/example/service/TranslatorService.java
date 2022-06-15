package com.example.service;

import com.example.repository.ITranslatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TranslatorService implements ITranslatorService {
    @Autowired
    private ITranslatorRepository iTranslatorRepository;

    @Override
    public String translate(String english) {
        return this.iTranslatorRepository.translate(english);
    }
}
