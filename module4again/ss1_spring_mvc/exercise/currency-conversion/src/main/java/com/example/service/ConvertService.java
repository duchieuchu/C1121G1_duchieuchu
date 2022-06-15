package com.example.service;

import com.example.repository.IConvertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConvertService implements IConvertService {
    @Autowired
    private IConvertRepository iConvertRepository;


    @Override
    public Integer convert(Integer rate, Integer usd) {
        return this.iConvertRepository.convert(rate,usd);
    }
}
